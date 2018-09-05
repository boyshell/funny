package com.funny.blood.cfg;

import com.google.inject.Inject;

public class ConfigDataSet {
  private volatile ConfigGroup configGroup;
  private volatile byte[] versionMsg;

  @Inject
  public ConfigDataSet() {}

  public void setConfigGroup(ConfigGroup configGroup) {
    this.configGroup = configGroup;
  }

  public ConfigGroup getConfigGroup() {
    return configGroup;
  }

  public byte[] getVersionMsg() {
    return versionMsg;
  }

  public void setVersionMsg(byte[] versionMsg) {
    this.versionMsg = versionMsg;
  }
}
