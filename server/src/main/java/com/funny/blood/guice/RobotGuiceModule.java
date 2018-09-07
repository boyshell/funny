package com.funny.blood.guice;

import com.funny.blood.RoomGuiceModule;
import com.funny.blood.cfg.ConfigDataSet;
import com.funny.blood.cfg.IConfigProperties;
import com.funny.blood.modules.GateToClientMessageGroup;
import com.funny.blood.modules.HallToClientMessageGroup;
import com.funny.blood.modules.LoginToClientMessageGroup;
import com.funny.blood.modules.RoomToClientMessageGroup;
import com.funny.blood.net.robot.GateClient;
import com.funny.blood.net.robot.MsgToClientFactory;
import com.funny.blood.net.robot.RobotDispatcher;
import com.funny.blood.properties.RobotProperties;
import com.funny.blood.script.RobotScript;
import com.funny.blood.shutdown.AbstractShutdownHooks;
import com.funny.blood.shutdown.RobotShutdownHooks;

public class RobotGuiceModule extends RoomGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, RobotShutdownHooks.class);
    bindSingleton(IConfigProperties.class, RobotProperties.class); // todo 会不会弄2个出来？会的话，优化一下

    bindSingleton(GateClient.class);
    bindSingleton(RobotProperties.class);
    bindSingleton(MsgToClientFactory.class);
    bindSingleton(RobotDispatcher.class);
    bindSingleton(RoomToClientMessageGroup.class);
    bindSingleton(GateToClientMessageGroup.class);
    bindSingleton(HallToClientMessageGroup.class);
    bindSingleton(LoginToClientMessageGroup.class);
    bindSingleton(RobotScript.class);
    bindSingleton(ConfigDataSet.class);
  }
}
