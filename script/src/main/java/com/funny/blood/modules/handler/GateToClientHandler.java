package com.funny.blood.modules.handler;

import com.funny.blood.net.robot.IRobotHandler;
import shell.net.Message;

public interface GateToClientHandler<T extends Message> extends IRobotHandler<T> {}
