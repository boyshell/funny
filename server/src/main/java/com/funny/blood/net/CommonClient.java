package com.funny.blood.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.misc.Factory;
import shell.net.*;

import java.util.concurrent.ThreadFactory;

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
      throws Exception {
    super(name, workerNum, messageHandler, threadFactory, decoderFactory, encoderFactory);

    channel = new CommonChannel(connect(host, port));
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
