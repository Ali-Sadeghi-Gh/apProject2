package client;

import GUI.MainFrame;

public class Main {
  public static void main(String[] args) {
    Client client = new Client(new MainFrame());
    new Thread(client).start();
  }
}
