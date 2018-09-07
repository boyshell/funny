package com.funny.blood.guice;

import com.funny.blood.RoomGuiceModule;
import com.funny.blood.cfg.ConfigDataSet;
import com.funny.blood.cfg.IConfigProperties;
import com.funny.blood.modules.*;
import com.funny.blood.net.gate.*;
import com.funny.blood.properties.GateProperties;
import com.funny.blood.script.GateScript;
import com.funny.blood.shutdown.AbstractShutdownHooks;
import com.funny.blood.shutdown.GateShutdownHooks;

public class GateGuiceModule extends RoomGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, GateShutdownHooks.class);
    bindSingleton(IConfigProperties.class, GateProperties.class);

    bindSingleton(GateProperties.class);
    bindSingleton(GateScript.class);
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
  }
}
