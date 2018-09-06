package com.funny.blood.net.gate;

import com.funny.blood.cfg.ConfigDataSet;
import com.funny.blood.modules.MessageVersion;
import com.funny.blood.modules.base.net.KickType;
import com.funny.blood.modules.base.net.RemoveClientUserInLoginRequest;
import com.funny.blood.modules.base.verify.Login0Request;
import com.funny.blood.modules.base.verify.LoginRequest;
import com.funny.blood.modules.base.verify.VersionCheckError;
import com.funny.blood.modules.base.verify.VersionCheckRequest;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.utils.Null;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

public class ClientToGateDispatcherScript implements IDispatcherScript {
  private static final Logger logger = LoggerFactory.getLogger(ClientToGateDispatcherScript.class);

  private final HallClient hallClient;
  private final LoginClient loginClient;
  private final ConfigDataSet configDataSet;
  private final GateServer gateServer;

  @Inject
  public ClientToGateDispatcherScript(
      HallClient hallClient,
      LoginClient loginClient,
      ConfigDataSet configDataSet,
      GateServer gateServer) {
    this.hallClient = hallClient;
    this.loginClient = loginClient;
    this.configDataSet = configDataSet;
    this.gateServer = gateServer;
  }

  @Override
  public void tick(Channel channel, long now) {
    // todo
  }

  @Override
  public void onChannelActive(Channel channel) {
    // 这里不要即时发送消息
    ClientToGateUser netUser = new ClientToGateUser(channel);
    channel.attr(ClientToGateUser.KEY).set(netUser);
    if (gateServer.getChannels().putIfAbsent(channel.id().asLongText(), netUser) != null) {
      logger.error("{}", channel, new NullPointerException());
    }
  }

  @Override
  public void onChannelInactive(Channel channel) {
    channel.attr(ClientToGateUser.KEY).remove();
    String id = channel.id().asLongText();
    loginClient.write(new RemoveClientUserInLoginRequest(id));
    if (gateServer.getChannels().remove(id) == null) {
      logger.error("{}", channel, new NullPointerException());
    }
  }

  @Override
  public void onChannelRead(Channel channel, Message message) {
    ClientToGateUser netUser = channel.attr(ClientToGateUser.KEY).get();
    if (netUser == null) {
      netUser.disconnect(KickType.FLOW, "net user未初始化");
      return;
    }
    // 版本验证
    if (!netUser.isVersionOK()) {
      if (message instanceof VersionCheckRequest) {
        checkVersion(netUser, (VersionCheckRequest) message);
      } else {
        netUser.disconnect(KickType.VERSION_ILLEGAL, "版本验证失败");
      }
      return;
    }
    // 登录处理
    if (netUser.getUserID() == Null.ID) {
      if (message instanceof LoginRequest) {
        LoginRequest m = (LoginRequest) message;
        loginClient.write(
            new Login0Request(
                channel.id().asLongText(),
                m.getAccount(),
                m.getTimestamp(),
                m.getMd5(),
                m.getTime()));
      } else {
        netUser.disconnect(KickType.NOT_VERIFY, "登录未完成");
      }
      return;
    }
    // 其他消息处理
    switch (message.to()) {
        //      case LOGIN:
        //        loginClient.forward(channel.id().asLongText(), message);
        //        break;
      case GAME:
        if (netUser.getGameClient() != null) {
          netUser.getGameClient().forward(channel.id().asLongText(), message);
        } else {
          logger.warn("FORWARD ERROR:{}", message.getClass().getSimpleName());
        }
        break;
      case HALL:
        hallClient.forward(channel.id().asLongText(), message);
        break;
      default:
        netUser.disconnect(KickType.ILLEGAL_MSG, "不应该发送的消息:" + message.toString());
        break;
    }
  }

  private void checkVersion(ClientToGateUser netUser, VersionCheckRequest message) {
    if (!configDataSet.getConfigGroup().CODE_VERSION.equals(message.getConfigCodeVersion())) {
      netUser.write(VersionCheckError.CONFIG_CODE);
      return;
    }
    if (!MessageVersion.VERSION.equals(message.getMessageCodeVersion())) {
      netUser.write(VersionCheckError.MESSAGE_CODE);
      return;
    }
    netUser.setVersionOK(true);
    if (configDataSet.getVersionMsg() != null) {
      netUser.write(configDataSet.getVersionMsg());
    } else {
      netUser.write(configDataSet.getConfigGroup().DATA_VERSION);
    }
  }
}
