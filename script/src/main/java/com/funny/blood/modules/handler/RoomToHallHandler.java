package com.funny.blood.modules.handler;

import com.funny.blood.server.hall.net.IGateAndRoomToHallHandler;
import shell.net.Message;

public interface RoomToHallHandler<T extends Message> extends IGateAndRoomToHallHandler<T> {}
