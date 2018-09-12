package com.funny.blood.server.gate;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.cfg.ConfigDataSet;
import com.funny.blood.cfg.IConfigProperties;
import com.funny.blood.modules.*;
import com.funny.blood.server.gate.net.*;
import com.funny.blood.AbstractShutdownHooks;

public class GateGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, GateShutdownHooks.class);
    bindSingleton(IConfigProperties.class, GateProperties.class);

    bindSingleton(GateProperties.class);
    bindSingleton(GateScriptHolder.class);
    bindSingleton(ConfigDataSet.class);

    bindSingleton(ClientToGateDispatcher.class);
    bindSingleton(GateServer.class);
    bindSingleton(MsgFromClientFactory.class);

    bindSingleton(LoginToGateDispatcher.class);
    bindSingleton(LoginToGateMessageGroup.class);
    bindSingleton(LoginClient.class);

    bindSingleton(HallClient.class);

    bindSingleton(ClientToRoomMessageGroup.class);
    bindSingleton(ClientToGateMessageGroup.class);
    bindSingleton(ClientToHallMessageGroup.class);
    bindSingleton(ClientToLoginMessageGroup.class);
    bindSingleton(HallToGateMessageGroup.class);
    bindSingleton(HallToGateDispatcher.class);
  }
}
