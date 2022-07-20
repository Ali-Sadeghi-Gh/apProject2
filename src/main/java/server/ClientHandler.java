package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.Scanner;

public class ClientHandler implements Runnable {
  private final Socket socket;
  private final int id;
  private final PrintWriter out;
  private final String authToken;
  private final GsonBuilder gsonBuilder = new GsonBuilder();
  private final Gson gson;

  public ClientHandler(Socket socket, int id) throws IOException {
    this.socket = socket;
    this.id = id;
    out = new PrintWriter(socket.getOutputStream());
    authToken = String.valueOf(new SecureRandom().nextInt());

    gson = gsonBuilder.create();
  }

  @Override
  public void run() {
    try {
      Scanner scanner = new Scanner(socket.getInputStream());
      while (true) {

      }
    } catch (IOException ignore) {}
  }
}
