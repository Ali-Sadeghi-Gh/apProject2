package client;

import GUI.MainFrame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
  private Socket socket;
  private PrintWriter out;
  private String authToken;
  private MainFrame mainFrame;

  public Client(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
    try {
      socket = new Socket("localhost", 8000);
      out = new PrintWriter(socket.getOutputStream());
    } catch (IOException ignore) {}
  }

  @Override
  public void run() {

  }
}
