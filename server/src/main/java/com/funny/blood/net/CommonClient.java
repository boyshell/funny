package com.funny.blood.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.misc.Factory;
import shell.net.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class CommonClient extends TcpClient {
  private static final Logger logger = LoggerFactory.getLogger(CommonClient.class);

  private volatile CommonChannel channel;

  public CommonClient(
      String name,
      int workerNum,
      MessageHandler messageHandler,
      ThreadFactory threadFactory,
      Factory<ByteToMessageHandler> decoderFactory,
      Factory<MessageToByteHandler> encoderFactory,
      String host,
      int port)
      throws InterruptedException {
    super(name, workerNum, messageHandler, threadFactory, decoderFactory, encoderFactory);

    Executors.newSingleThreadScheduledExecutor()
        .scheduleWithFixedDelay(
            () -> {
              if (channel != null && channel.getChannel().isActive()) {
                return;
              }
              try {
                channel = new CommonChannel(connect(host, port));
              } catch (Exception e) {
                logger.error("", e);
              }
            },
            0,
            1,
            TimeUnit.SECONDS);
  }

  public boolean write(Message message) {
    return write(Message.encodeToBytes(message));
  }

  public boolean write(byte[] message) {
    if (channel == null) {
      return false;
    }
    return channel.write(message);
  }
}
