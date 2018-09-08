package com.funny.blood.modules.handler;

import com.funny.blood.modules.user.login.UserInLogin;
import shell.net.Message;

public interface ClientToLoginHandler<T extends Message> {
    void exec(UserInLogin user, T message);
}
