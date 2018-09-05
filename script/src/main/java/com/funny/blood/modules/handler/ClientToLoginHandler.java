package com.funny.blood.modules.handler;

import com.funny.blood.modules.user.login.User;
import shell.net.Message;

public interface ClientToLoginHandler<T extends Message> {
    void exec(User user, T message);
}
