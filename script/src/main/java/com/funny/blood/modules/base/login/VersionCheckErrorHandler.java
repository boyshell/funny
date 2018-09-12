package com.funny.blood.modules.base.login;

import com.funny.blood.modules.handler.GateToClientHandler;
import com.funny.blood.server.robot.net.RobotUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VersionCheckErrorHandler implements GateToClientHandler<VersionCheckError> {
    private static final Logger logger = LoggerFactory.getLogger(VersionCheckErrorHandler.class);

    @Override
    public void exec(RobotUser user, VersionCheckError message) {
        logger.error("version check error");
    }
}
