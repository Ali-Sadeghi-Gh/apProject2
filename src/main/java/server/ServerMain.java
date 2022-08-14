package server;

import shared.util.Config;

public class ServerMain {
  public static void main(String[] args) {
    Server server = new Server(Config.getConfig(Config.getMainConfig().getProperty("serverConfig")).getProperty(Integer.class, "port"));
    server.start();
  }
}
