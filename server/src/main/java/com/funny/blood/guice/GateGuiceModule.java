package com.funny.blood.guice;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.cfg.ConfigDataSet;
import com.funny.blood.modules.LoginToGateMessageGroup;
import com.funny.blood.net.gate.*;
import com.funny.blood.properties.GateProperties;
import com.funny.blood.script.GateScript;
import com.funny.blood.shutdown.GateShutdownHooks;
import com.funny.blood.shutdown.AbstractShutdownHooks;

public class GateGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, GateShutdownHooks.class);

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
  }
}
