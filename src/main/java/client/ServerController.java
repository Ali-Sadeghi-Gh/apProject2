package client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.EducationalRequest;
import shared.model.PanelName;
import shared.util.Config;
import shared.request.*;
import shared.response.Response;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerController {
  private Socket socket;
  private PrintStream printStream;
  private Scanner scanner;
  private String authToken;
  private final Gson gson = new GsonBuilder().create();


  public boolean connectToServer() {
    boolean isConnected;
    try {
      socket = new Socket(getConfig().getProperty(String.class, "address"),
              getConfig().getProperty(Integer.class, "port"));
      printStream = new PrintStream(socket.getOutputStream());
      scanner = new Scanner(socket.getInputStream());
      authToken = scanner.nextLine();
      isConnected = true;
    } catch (Exception e) {
      isConnected = false;
    }
    return isConnected;
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "clientConfig"));
  }

  public void kill() {
    try {
      scanner.close();
      printStream.close();
      socket.close();
    } catch (Exception ignore) {}
    System.exit(0);
  }

  private void sendRequest(Request request) {
    String requestString = gson.toJson(request);
    try {
      printStream.println(authToken + "&" + requestString);
      printStream.flush();
    } catch (Exception e) {
      System.out.println(Config.getConfig(Config.getMainConfig().getProperty(String.class, "clientConfig")).getProperty(String.class, "printError"));
      Offline.getInstance().start();
    }
  }

  private Response scanResponse() {
    Response response = null;
    try {
      response = gson.fromJson(scanner.nextLine(), Response.class);
    } catch (Exception e) {
      System.out.println(Config.getConfig(Config.getMainConfig().getProperty(String.class, "clientConfig")).getProperty(String.class, "scanError"));
      Offline.getInstance().start();
    }
    return response;
  }

  public Response sendOfflineInformRequest() {
    Request request = new Request(RequestType.OFFLINE_INFORM);
    sendRequest(request);
    return scanResponse();
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

  public Response sendLoginRequest(String id, String password) {
    Request request = new Request(RequestType.LOGIN);
    request.addData("id", id);
    request.addData("password", password);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendChangePasswordRequest(String currentPassword, String newPassword) {
    Request request = new Request(RequestType.CHANGE_PASSWORD);
    request.addData("currentPassword", currentPassword);
    request.addData("newPassword", newPassword);
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

  public Response sendSearchStudentStatusByIdRequest(String id) {
    Request request = new Request(RequestType.SEARCH_STUDENT_STATUS_BY_ID);
    request.addData("id", id);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendSearchStudentStatusByNameRequest(String name) {
    Request request = new Request(RequestType.SEARCH_STUDENT_STATUS_BY_NAME);
    request.addData("name", name);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendSearchCourseTemporaryRequest(String courseId) {
    Request request = new Request(RequestType.SEARCH_COURSE_TEMPORARY);
    request.addData("courseId", courseId);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendSearchProfessorTemporaryRequest(String professorId) {
    Request request = new Request(RequestType.SEARCH_PROFESSOR_TEMPORARY);
    request.addData("professorId", professorId);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendSearchStudentTemporaryRequest(String studentId) {
    Request request = new Request(RequestType.SEARCH_STUDENT_TEMPORARY);
    request.addData("studentId", studentId);
    sendRequest(request);
    return scanResponse();
  }

  public Response sendSearchCourseSummaryRequest(String courseId) {
    Request request = new Request(RequestType.SEARCH_COURSE_SUMMARY);
    request.addData("courseId", courseId);
    sendRequest(request);
    return scanResponse();
  }

  public void sendMessengerSendTextRequest(String message, String contactId) {
    Request request = new Request(RequestType.MESSENGER_SEND_TEXT);
    request.addData("message", message);
    request.addData("contactId", contactId);
    sendRequest(request);
  }

  public void sendMessengerSendFileRequest(String[] strings,String fileName, String contactId) {
    Request request = new Request(RequestType.MESSENGER_SEND_FILE);
    request.addData("strings", strings);
    request.addData("fileName", fileName);
    request.addData("contactId", contactId);
    sendRequest(request);
  }

  public void sendSetUserRequest(String id) {
    Request request = new Request(RequestType.SET_USER);
    request.addData("id", id);
    sendRequest(request);
  }
}