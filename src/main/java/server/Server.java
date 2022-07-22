package server;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import shared.model.Data;

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
  }

  public void start() {
    Controller.getInstance().startProgram();
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      while (true) {
        Socket socket = serverSocket.accept();

        ClientHandler clientHandler = new ClientHandler(this, socket, previousClientHandlerId++);
        clientHandlers.add(clientHandler);
        new Thread(clientHandler).start();
      }
    } catch (IOException ignore) {}
  }

  public void removeClientHandler(ClientHandler clientHandler) {
    clientHandlers.remove(clientHandler);
  }
}
