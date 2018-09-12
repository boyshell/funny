package com.funny.blood.modules.handler;

import com.funny.blood.server.hall.net.IGateAndRoomToHallHandler;
import shell.net.Message;

public interface GateToHallHandler<T extends Message> extends IGateAndRoomToHallHandler<T> {}
