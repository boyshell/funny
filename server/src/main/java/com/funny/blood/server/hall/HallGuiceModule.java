package com.funny.blood.server.hall;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.db.DBPool;
import com.funny.blood.db.IDBProperties;
import com.funny.blood.modules.ClientToHallMessageGroup;
import com.funny.blood.modules.GateToHallMessageGroup;
import com.funny.blood.modules.RoomToHallMessageGroup;
import com.funny.blood.modules.user.hall.UserInHallDataSet;
import com.funny.blood.server.hall.net.GateAndRoomToHallFactory;
import com.funny.blood.server.hall.net.HallDispatcher;
import com.funny.blood.server.hall.net.HallServer;
import com.funny.blood.AbstractShutdownHooks;

public class HallGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, HallShutdownHooks.class);
    bindSingleton(IDBProperties.class, HallProperties.class);

    bindSingleton(HallServer.class);
    bindSingleton(HallScriptHolder.class);
    bindSingleton(GateAndRoomToHallFactory.class);
    bindSingleton(HallDispatcher.class);
    bindSingleton(HallProperties.class);
    bindSingleton(GateToHallMessageGroup.class);
    bindSingleton(RoomToHallMessageGroup.class);
    bindSingleton(ClientToHallMessageGroup.class);
    bindSingleton(DBPool.class);
    bindSingleton(UserInHallDataSet.class);
  }
}
