package com.funny.blood.server.robot;

import com.funny.blood.ILauncher;
import com.funny.blood.server.robot.net.GateClient;
import com.funny.blood.server.robot.net.RobotDispatcherScript;
import com.google.inject.Inject;

public class RobotLauncher implements ILauncher {
  private final RobotScriptHolder script;
  private final RobotDispatcherScript dispatcherScript;
  private final GateClient gateClient;
  private final RobotProperties properties;

  @Inject
  public RobotLauncher(
      RobotScriptHolder script,
      RobotDispatcherScript dispatcherScript,
      GateClient gateClient,
      RobotProperties properties) {
    this.script = script;
    this.dispatcherScript = dispatcherScript;
    this.gateClient = gateClient;
    this.properties = properties;
  }

  @Override
  public void launch() throws Exception {
    for (int i = 0; i < properties.ROBOT_NUM; ++i) {
      gateClient.connect(properties.GATE_HOST, properties.GATE_PORT);
    }
  }

  @Override
  public void registerScript() {
    script.robotDispatcher = dispatcherScript;
  }
}
