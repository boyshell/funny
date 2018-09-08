package com.funny.blood.guice;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.ILauncher;
import com.funny.blood.launcher.HallLauncher;
import com.funny.blood.modules.base.user.hall.UserInHallModule;
import com.funny.blood.modules.hg.ClientToHallHandlerGroup;
import com.funny.blood.modules.hg.GateToHallHandlerGroup;
import com.funny.blood.modules.hg.RoomToHallHandlerGroup;
import com.funny.blood.net.hall.GateAndRoomToHallDispatcherScript;
import com.funny.blood.net.hall.GateAndRoomToHallHandlerGroup;

public class HallScriptGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(ILauncher.class, HallLauncher.class);

    bindSingleton(GateAndRoomToHallDispatcherScript.class);
    bindSingleton(GateAndRoomToHallHandlerGroup.class);
    bindSingleton(GateToHallHandlerGroup.class);
    bindSingleton(RoomToHallHandlerGroup.class);
    bindSingleton(ClientToHallHandlerGroup.class);
    bindSingleton(UserInHallModule.class);
  }
}
