package com.funny.blood;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class CmdParams {
  @Option(
      name = "-s",
      aliases = "--script",
      metaVar = "script.jar的路径",
      required = true,
      usage = "/xx/xx/xx/script.jar")
  private String scriptPath;

  @Option(
      name = "-m",
      aliases = "--mode",
      metaVar = "模式",
      required = true,
      usage = "leader|logic|scene|robot|all-but-robot")
  private String mode;

  public String getScriptPath() {
    return scriptPath;
  }

  public String getMode() {
    return mode;
  }

  public CmdParams(String[] args) throws CmdLineException {
    CmdLineParser parser = new CmdLineParser(this);
    try {
      parser.parseArgument(args);
    } catch (CmdLineException e) {
      parser.printUsage(System.err);
      throw e;
    }
  }
}
