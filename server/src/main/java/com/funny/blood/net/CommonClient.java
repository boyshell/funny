package com.funny.blood.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.misc.Factory;
import shell.net.*;

import java.util.concurrent.ThreadFactory;

import static com.google.common.base.Preconditions.checkArgument;

public class CommonClient extends TcpClient {
  private static final Logger logger = LoggerFactory.getLogger(CommonClient.class);

  private final String host;
  private final int port;
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

    this.host = host;
    this.port = port;
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

  public void startup() throws Exception {
    checkArgument(channel == null);
    channel = new CommonChannel(connect(host, port));
  }
}
