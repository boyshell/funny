package com.funny.blood.modules.handler;

import com.funny.blood.net.login.GateToLoginUser;
import shell.net.Message;

public interface GateToLoginHandler<T extends Message> {
  void exec(GateToLoginUser netUser, T message);
}
