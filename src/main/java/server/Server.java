package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
  private static Server instance;
  private final int port;
  private final List<ClientHandler> clientHandlers = new ArrayList<>();
  private int previousClientHandlerId = 1000;

  public Server(int port) {
    instance = this;
    this.port = port;
    init();
  }

  private void init() {
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      while (true) {
        Socket socket = serverSocket.accept();

        ClientHandler clientHandler = new ClientHandler(socket, previousClientHandlerId++);
        clientHandlers.add(clientHandler);
        new Thread(clientHandler).start();
      }
    } catch (IOException ignore) {}
  }
}
