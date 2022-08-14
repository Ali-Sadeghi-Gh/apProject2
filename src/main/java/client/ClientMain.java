package client;

import shared.util.Config;

public class ClientMain {
  public static void main(String[] args) {
    Client client = new Client(getConfig().getProperty(String.class, "address"),
            getConfig().getProperty(Integer.class, "port"));
    client.start();
  }

  private static Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "clientConfig"));
  }
}
