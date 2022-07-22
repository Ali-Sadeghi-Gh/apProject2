package client;

public class ClientMain {
  public static void main(String[] args) {
    Client client = new Client(8000);
    client.start();
  }
}
