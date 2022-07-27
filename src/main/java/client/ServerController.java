package client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.EducationalRequest;
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
      Loop.stopCurrent();
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

  public Response sendAddTemporaryScoreByStudentRequest(String courseId, String objection, String answer, String score) {
    Request request = new Request(RequestType.ADD_TEMPORARY_SCORE_BY_STUDENT);
    request.addData("courseId", courseId);
    request.addData("objection", objection);
    request.addData("answer", answer);
    request.addData("score", score);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendAddTemporaryScoreByProfessorRequest(String studentId, String courseId, String objection, String answer, String score) {
    Request request = new Request(RequestType.ADD_TEMPORARY_SCORE_BY_PROFESSOR);
    request.addData("studentId", studentId);
    request.addData("courseId", courseId);
    request.addData("objection", objection);
    request.addData("answer", answer);
    request.addData("score", score);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendAddScoreRequest(String courseId, int studentsCount) {
    Request request = new Request(RequestType.ADD_SCORE);
    request.addData("courseId", courseId);
    request.addData("studentsCount", String.valueOf(studentsCount));
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

  public Response sendDormitoryRequest() {
    sendRequest(new Request(RequestType.DORMITORY_REQUEST));
    return scanResponse();
  }

  public Response sendDefendingRequest() {
    sendRequest(new Request(RequestType.DEFENDING_REQUEST));
    return scanResponse();
  }

  public Response sendAnswerEducationalRequestRequest(EducationalRequest.Type type, String requestId, boolean accepted) {
    Request request = new Request(RequestType.ANSWER_EDUCATIONAL_REQUEST);
    request.addData("type", type);
    request.addData("requestId", requestId);
    request.addData("accepted", accepted);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendRemoveProfessorRequest(String professorId) {
    Request request = new Request(RequestType.REMOVE_PROFESSOR);
    request.addData("professorId", professorId);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendAddProfessorRequest(String name, String email, String melliCode, String phoneNumber,
                                          String password, String roomNumber, String degree, String position) {
    Request request = new Request(RequestType.ADD_PROFESSOR);
    request.addData("name", name);
    request.addData("email", email);
    request.addData("melliCode", melliCode);
    request.addData("phoneNumber", phoneNumber);
    request.addData("password", password);
    request.addData("roomNumber", roomNumber);
    request.addData("degree", degree);
    request.addData("position", position);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendChangeProfessorRequest(String professorId, String name, String email, String melliCode, String phoneNumber,
                                             String password, String roomNumber, String degree, String position) {
    Request request = new Request(RequestType.CHANGE_PROFESSOR);
    request.addData("professorId", professorId);
    request.addData("name", name);
    request.addData("email", email);
    request.addData("melliCode", melliCode);
    request.addData("phoneNumber", phoneNumber);
    request.addData("password", password);
    request.addData("roomNumber", roomNumber);
    request.addData("degree", degree);
    request.addData("position", position);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendAddCourseRequest(String name, String grade, String credit, String examTime, String classTime, String professorId) {
    Request request = new Request(RequestType.ADD_COURSE);
    request.addData("name", name);
    request.addData("grade", grade);
    request.addData("credit", credit);
    request.addData("examTime", examTime);
    request.addData("classTime", classTime);
    request.addData("professorId", professorId);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendRemoveCourseRequest(String courseId) {
    Request request = new Request(RequestType.REMOVE_COURSE);
    request.addData("courseId", courseId);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendChangeCourseRequest(String courseId, String name, String professorId, String credit,
                                          String classTime, String examDate, String grade) {
    Request request = new Request(RequestType.CHANGE_COURSE);
    request.addData("courseId", courseId);
    request.addData("name", name);
    request.addData("professorId", professorId);
    request.addData("credit", credit);
    request.addData("classTime", classTime);
    request.addData("examDate", examDate);
    request.addData("grade", grade);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendAddStudentRequest(String name, String email, String melliCode, String supervisorId, String phoneNumber,
                                    String password, String enteringYear, String status, String grade) {
    Request request = new Request(RequestType.ADD_STUDENT);
    request.addData("name", name);
    request.addData("email", email);
    request.addData("melliCode", melliCode);
    request.addData("supervisorId", supervisorId);
    request.addData("phoneNumber", phoneNumber);
    request.addData("password", password);
    request.addData("enteringYear", enteringYear);
    request.addData("status", status);
    request.addData("grade", grade);
    sendRequest(request);
    return scanResponse();
  }
}