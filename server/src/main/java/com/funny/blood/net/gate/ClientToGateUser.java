package com.funny.blood.net.gate;

import com.funny.blood.modules.base.net.KickRequest;
import com.funny.blood.modules.base.net.KickType;
import com.funny.blood.net.CommonChannel;
import com.funny.blood.utils.Null;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import shell.net.NetUtil;

public class ClientToGateUser extends CommonChannel {
  public static final AttributeKey<ClientToGateUser> KEY =
      NetUtil.createAttributeKey(ClientToGateUser.class);

  private boolean versionOK = false;
  private int userID = Null.ID;
  private GameClient gameClient;

  public ClientToGateUser(Channel channel) {
    super(channel);
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public boolean isVersionOK() {
    return versionOK;
  }

  public void setVersionOK(boolean versionOK) {
    this.versionOK = versionOK;
  }

  public GameClient getGameClient() {
    return gameClient;
  }

  public void setGameClient(GameClient gameClient) {
    this.gameClient = gameClient;
  }

  public void disconnect(KickType type, String reason) {
    closeAndWrite(new KickRequest().setType(type), reason);
  }
}
