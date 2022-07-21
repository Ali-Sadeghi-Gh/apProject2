package client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.PanelName;
import shared.request.*;
import shared.response.Response;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ServerController {
  private PrintStream printStream;
  private Scanner scanner;
  private final GsonBuilder gsonBuilder = new GsonBuilder();
  private final Gson gson;
  private final int port;

  public ServerController(int port) {
    this.port = port;

    gson = gsonBuilder.create();
  }

  public void connectToServer() {
    try {
      Socket socket = new Socket(InetAddress.getLocalHost(), port);
      printStream = new PrintStream(socket.getOutputStream());
      scanner = new Scanner(socket.getInputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void sendRequest(Request request) {
    String requestString = gson.toJson(request);
    printStream.println(requestString);
    printStream.flush();
  }

  public Response sendUpdateRequest(PanelName panelName) {
    Request request = new Request(RequestType.UPDATE);
    request.addData("panelName", panelName);
    sendRequest(request);
    return gson.fromJson(scanner.nextLine(), Response.class);
  }

  public Response sendLoginRequest(int id, String password) {
    Request request = new Request(RequestType.LOGIN);
    request.addData("id", id);
    request.addData("password", password);
    sendRequest(request);

    return gson.fromJson(scanner.nextLine(), Response.class);
  }
}
