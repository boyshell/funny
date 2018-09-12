package com.funny.blood.server.robot;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.cfg.ConfigDataSet;
import com.funny.blood.cfg.IConfigProperties;
import com.funny.blood.modules.GateToClientMessageGroup;
import com.funny.blood.modules.HallToClientMessageGroup;
import com.funny.blood.modules.LoginToClientMessageGroup;
import com.funny.blood.modules.RoomToClientMessageGroup;
import com.funny.blood.server.robot.net.GateClient;
import com.funny.blood.server.robot.net.MsgToClientFactory;
import com.funny.blood.server.robot.net.RobotDispatcher;
import com.funny.blood.AbstractShutdownHooks;

public class RobotGuiceModule extends GameGuiceModule {
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
    bindSingleton(RobotScriptHolder.class);
    bindSingleton(ConfigDataSet.class);
  }
}
