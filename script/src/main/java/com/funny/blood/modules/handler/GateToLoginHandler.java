package com.funny.blood.modules.handler;

import com.funny.blood.server.login.net.GateToLoginUser;
import shell.net.Message;

public interface GateToLoginHandler<T extends Message> {
  void exec(GateToLoginUser netUser, T message);
}
