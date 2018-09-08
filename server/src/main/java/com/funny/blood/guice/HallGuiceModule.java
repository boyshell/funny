package com.funny.blood.guice;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.db.DBPool;
import com.funny.blood.db.IDBProperties;
import com.funny.blood.modules.ClientToHallMessageGroup;
import com.funny.blood.modules.GateToHallMessageGroup;
import com.funny.blood.modules.RoomToHallMessageGroup;
import com.funny.blood.modules.user.hall.UserInHallDataSet;
import com.funny.blood.net.hall.GateAndRoomToHallFactory;
import com.funny.blood.net.hall.HallDispatcher;
import com.funny.blood.net.hall.HallServer;
import com.funny.blood.properties.HallProperties;
import com.funny.blood.script.HallScript;
import com.funny.blood.shutdown.AbstractShutdownHooks;
import com.funny.blood.shutdown.HallShutdownHooks;

public class HallGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, HallShutdownHooks.class);
    bindSingleton(IDBProperties.class, HallProperties.class);

    bindSingleton(HallServer.class);
    bindSingleton(HallScript.class);
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
