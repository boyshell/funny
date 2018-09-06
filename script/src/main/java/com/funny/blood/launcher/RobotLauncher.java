package com.funny.blood.launcher;

import com.funny.blood.ILauncher;
import com.funny.blood.net.robot.GateClient;
import com.funny.blood.net.robot.RobotDispatcherScript;
import com.funny.blood.properties.RobotProperties;
import com.funny.blood.script.RobotScript;
import com.google.inject.Inject;

public class RobotLauncher implements ILauncher {
  private final RobotScript script;
  private final RobotDispatcherScript dispatcherScript;
  private final GateClient gateClient;
  private final RobotProperties properties;

  @Inject
  public RobotLauncher(
      RobotScript script,
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
