package com.funny.blood.modules.handler;

import com.funny.blood.server.robot.net.IRobotHandler;
import shell.net.Message;

public interface HallToClientHandler<T extends Message> extends IRobotHandler<T> {}
