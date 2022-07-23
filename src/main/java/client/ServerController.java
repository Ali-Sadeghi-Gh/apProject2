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
  private Socket socket;
  private PrintStream printStream;
  private Scanner scanner;
  private String authToken;
  private final GsonBuilder gsonBuilder = new GsonBuilder();
  private final Gson gson;
  private final int port;

  public ServerController(int port) {
    this.port = port;
    gson = gsonBuilder.create();
  }

  public void connectToServer() {
    try {
      socket = new Socket(InetAddress.getLocalHost(), port);
      printStream = new PrintStream(socket.getOutputStream());
      scanner = new Scanner(socket.getInputStream());
      authToken = scanner.nextLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void kill() {
    scanner.close();
    printStream.close();
    try {
      socket.close();
    } catch (Exception ignore) {}
    System.exit(0);
  }

  private void sendRequest(Request request) {
    String requestString = gson.toJson(request);
    printStream.println(authToken + "&" + requestString);
    printStream.flush();
  }

  private Response scanResponse() {
    Response response = null;
    try {
      response = gson.fromJson(scanner.nextLine(), Response.class);
    } catch (Exception e) {
      System.out.println("scanning error");
    }
    return response;
  }

  public Response sendUpdateRequest(PanelName panelName) {
    Request request = new Request(RequestType.UPDATE);
    request.addData("panelName", panelName);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendUpdateRequest(PanelName panelName, Request request) {
    request.addData("panelName", panelName);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendLoginRequest(int id, String password) {
    Request request = new Request(RequestType.LOGIN);
    request.addData("id", id);
    request.addData("password", password);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendChangePhoneNumberRequest(String phoneNumber) {
    Request request = new Request(RequestType.CHANGE_PHONE_NUMBER);
    request.addData("phoneNumber", phoneNumber);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendChangeEmailRequest(String email) {
    Request request = new Request(RequestType.CHANGE_EMAIL);
    request.addData("email", email);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendIsDeanRequest() {
    sendRequest(new Request(RequestType.IS_DEAN));
    return scanResponse();
  }

  public Response sendAddTemporaryScoreRequest(String courseId, String objection, String answer, String score) {
    Request request = new Request(RequestType.ADD_TEMPORARY_SCORE);
    request.addData("courseId", courseId);
    request.addData("objection", objection);
    request.addData("answer", answer);
    request.addData("score", score);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendGetRecommendationResultRequest(String professorId) {
    Request request = new Request(RequestType.GET_RECOMMENDATION_RESULT);
    request.addData("professorId", professorId);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendEnrollmentCertificationRequest() {
    sendRequest(new Request(RequestType.ENROLLMENT_CERTIFICATION));
    return scanResponse();
  }

  public Response sendMinorRequest(String faculty) {
    Request request = new Request(RequestType.MINOR_REQUEST);
    request.addData("faculty", faculty);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendDropoutRequest() {
    sendRequest(new Request(RequestType.DROPOUT_REQUEST));
    return scanResponse();
  }
}
