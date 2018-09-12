package com.funny.blood.server.gate.net;

import com.funny.blood.modules.base.net.KickRequest;
import com.funny.blood.modules.base.net.KickType;
import com.funny.blood.modules.base.room.GameType;
import com.funny.blood.net.CommonChannel;
import com.funny.blood.utils.Null;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import shell.net.NetUtil;

public class ClientToGateUser extends CommonChannel {
  public static final AttributeKey<ClientToGateUser> KEY =
      NetUtil.createAttributeKey(ClientToGateUser.class);

  private boolean versionOK = false;
  private int userID = Null.ID;
  private Room room;

  public ClientToGateUser(Channel channel) {
    super(channel);
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public boolean isVersionOK() {
    return versionOK;
  }

  public void setVersionOK(boolean versionOK) {
    this.versionOK = versionOK;
  }

  public void disconnect(KickType type, String reason) {
    closeAndWrite(new KickRequest().setType(type), reason);
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public static class Room {
    private final GameType gameType;
    private final int roomID;

    public Room(GameType gameType, int roomID) {
      this.gameType = gameType;
      this.roomID = roomID;
    }

    public GameType getGameType() {
      return gameType;
    }

    public int getRoomID() {
      return roomID;
    }
  }
}
