package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.*;
import shared.model.users.Professor;
import shared.model.users.Student;
import shared.model.users.User;
import shared.model.users.UserRole;
import shared.request.Request;
import shared.response.Response;
import shared.response.ResponseStatus;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.Scanner;

public class ClientHandler implements Runnable {
  private final Server server;
  private final Socket socket;
  private final PrintStream printStream;
  private final String authToken;
  private final GsonBuilder gsonBuilder = new GsonBuilder();
  private final Gson gson;

  private User user;

  public ClientHandler(Server server, Socket socket, int id) throws IOException {
    this.server = server;
    this.socket = socket;
    printStream = new PrintStream(socket.getOutputStream());
    authToken = String.valueOf(new SecureRandom().nextInt());
    printStream.println(authToken);
    printStream.flush();
    gson = gsonBuilder.create();
  }

  @Override
  public void run() {
    try {
      Scanner scanner = new Scanner(socket.getInputStream());
      while (true) {
        String[] strings = scanner.nextLine().split("&");
        if (strings[0].equals(authToken)) {
          Request request = gson.fromJson(strings[1], Request.class);
          handleRequest(request);
        }
      }
    } catch (Exception e) {
      kill();
    }
  }

  private void kill() {
    try {
      socket.close();
    } catch (Exception ignore) {
    }
    printStream.close();
    server.removeClientHandler(this);
  }

  private void handleRequest(Request request) {
    switch (request.getRequestType()) {
      case LOGIN:
        handleLogin(request);
        break;
      case UPDATE:
        handleUpdate(request);
        break;
      case CHANGE_PHONE_NUMBER:
        Controller.getInstance().changePhoneNumber((String) request.getData("phoneNumber"), user);
        sendResponse(new Response(ResponseStatus.OK));
        break;
      case CHANGE_EMAIL:
        Controller.getInstance().changeEmail((String) request.getData("email"), user);
        sendResponse(new Response(ResponseStatus.OK));
        break;
      case IS_DEAN:
        Professor professor = (Professor) user;
        sendResponse(new Response(professor.getPosition().equals(Professor.Position.dean) ? ResponseStatus.OK : ResponseStatus.ERROR));
        break;
      case ADD_TEMPORARY_SCORE:
        Controller.getInstance().addTemporaryScore(String.valueOf(user.getId()),
                (String) request.getData("courseId"), (String) request.getData("objection"),
                (String) request.getData("answer"), (String) request.getData("score"));
        sendResponse(new Response(ResponseStatus.OK));
        break;
      case GET_RECOMMENDATION_RESULT:
        Student student = (Student) user;
        professor = Controller.getInstance().findProfessorById(Integer.parseInt((String) request.getData("professorId")));
        Response response;
        if (professor == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("professor id not found");
        } else {
          response = new Response(ResponseStatus.OK);
          EducationalRequest educationalRequest = Controller.getInstance().findRequestByProfessor(student, professor, EducationalRequest.Type.recommendation);
          if (educationalRequest == null) {
            educationalRequest = Controller.getInstance().addRequest(String.valueOf(student.getId()), String.valueOf(professor.getId()),
                    null, null, EducationalRequest.Type.recommendation);
            response.setErrorMessage("your request submitted");
          } else {
            response.setErrorMessage("you request recommendation before");
          }
          response.addData("result", educationalRequest.getResult());
        }
        sendResponse(response);
        break;
      case ENROLLMENT_CERTIFICATION:
        response = new Response(ResponseStatus.OK);
        response.addData("certification", Controller.getInstance().getEnrollmentString((Student) user));
        sendResponse(response);
        break;
      case MINOR_REQUEST:
        student = (Student) user;
        if (Controller.getInstance().getPassCredit(student) < 8) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("you must have at least 8 passed credits");
        } else if (Controller.getInstance().getAverageScoreByStudent(student) < 18) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("your average score must be above 18");
        } else {
          EducationalRequest educationalRequest = Controller.getInstance().addRequest(String.valueOf(student.getId()),
                  null, student.getFacultyName(), (String) request.getData("faculty"),
                  EducationalRequest.Type.minor);
          response = new Response(ResponseStatus.OK);
          response.addData("result", educationalRequest.getResult());
          response.addData("targetFaculty", educationalRequest.getTargetFaculty());
          response.addData("faculties", new String[0]);
          response.setErrorMessage("your request submitted");
        }
        sendResponse(response);
        break;
    }
  }

  private void handleUpdate(Request request) {
    PanelName panelName = Enum.valueOf(PanelName.class, (String) request.getData("panelName"));

    Response response = new Response(ResponseStatus.OK);
    switch (panelName) {
      case StudentPanel:
      case EduAssistantPanel:
      case ProfessorPanel:
        response.addData("id", user.getId());
        response.addData("lastLogin", user.getLastLogIn());
        response.addData("email", user.getEmail());
        response.addData("name", user.getName());
        response.addData("currentTime", Time.getCurrentTime());
        break;
      case StudentMainPanel:
        Student student = (Student) user;
        response.addData("educationalStatus", student.getStatus());
        response.addData("supervisor", Controller.getInstance().findProfessorById(Integer.parseInt(student.getSupervisorId())).getName());
        break;
      case StudentProfilePanel:
        student = (Student) user;
        response.addData("id", student.getId());
        response.addData("melliCode", student.getMelliCode());
        response.addData("faculty", student.getFacultyName());
        response.addData("phoneNumber", student.getPhoneNumber());
        response.addData("enteringYear", student.getEnteringYear());
        response.addData("grade", student.getGrade());
        response.addData("status", student.getStatus());
        response.addData("supervisor", Controller.getInstance().findProfessorById(Integer.parseInt(student.getSupervisorId())).getName());
        response.addData("averageScore", Controller.getInstance().getAverageScoreByStudent(student));
        break;
      case ProfessorProfilePanel:
        Professor professor = (Professor) user;
        response.addData("id", professor.getId());
        response.addData("melliCode", professor.getMelliCode());
        response.addData("faculty", professor.getFacultyName());
        response.addData("phoneNumber", professor.getPhoneNumber());
        response.addData("degree", professor.getDegree());
        response.addData("roomNumber", professor.getRoomNumber());
        break;
      case CoursesListPanel:
        response.addData("faculties", Controller.getInstance().getFacultiesName());
        response.addData("data", Controller.getInstance().getCoursesData((String) request.getData("faculty"),
                (String) request.getData("professor"), (String) request.getData("grade")));
        break;
      case ProfessorListPanel:
      case ProfessorListDeanPanel:
        response.addData("faculties", Controller.getInstance().getFacultiesName());
        response.addData("data", Controller.getInstance().getProfessorsData((String) request.getData("faculty"),
                (String) request.getData("name"), (String) request.getData("grade")));
        break;
      case StudentEducationalOutPanel:
        response.addData("credit", Controller.getInstance().getPassCredit((Student) user));
        response.addData("averageScore", Controller.getInstance().getAverageScoreByStudent((Student) user));
        response.addData("data", Controller.getInstance().getScoresData((Student) user));
        break;
      case StudentTemporaryScoreList:
        response.addData("data", Controller.getInstance().getCourseTemporaryScoreDataByStudent((Student) user));
        break;
      case WeeklySchedulePanel:
        response.addData("data", Controller.getInstance().getScheduleData(user));
        break;
      case ExamListPanel:
        response.addData("data", Controller.getInstance().getExamListData(user));
        break;
      case RecommendationRequestPanel:
        student = (Student) user;
        if (student.getGrade() == null || (!student.getGrade().equals(Student.Grade.masters) && !student.getGrade().equals(Student.Grade.underGraduate))) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("this section is only for undergraduate and masters students");
        }
        break;
      case MinorRequestPanel:
        student = (Student) user;
        if (student.getGrade() != null && student.getGrade().equals(Student.Grade.underGraduate)) {
          EducationalRequest educationalRequest = Controller.getInstance().findRequestByFaculty(student, student.getFacultyName(), EducationalRequest.Type.minor);
          if (educationalRequest == null) {
            response.addData("result", "");
            response.addData("targetFaculty", "");
            response.addData("faculties", Controller.getInstance().getMinorFacultiesName(student.getFacultyName()));
          } else {
            response.addData("result", educationalRequest.getResult());
            response.addData("targetFaculty", educationalRequest.getTargetFaculty());
            response.addData("faculties", new String[0]);
          }
        } else {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("this section is only for undergraduate students");
        }
        break;
    }
    sendResponse(response);
  }

  private void handleLogin(Request request) {
    User user = Controller.getInstance().logIn((int) Double.parseDouble(String.valueOf(request.getData("id"))), (String) request.getData("password"));

    Response response;

    if (user == null) {
      response = new Response(ResponseStatus.ERROR);
      response.setErrorMessage("wrong id or password input");
    } else {
      this.user = user;
      Controller.getInstance().setUserLoginTime(user);
      response = new Response(ResponseStatus.OK);

      UserRole userRole = null;
      if (user instanceof Student) {
        userRole = UserRole.Student;
      } else if (user instanceof Professor) {
        Professor professor = (Professor) user;
        if (professor.getPosition().equals(Professor.Position.eduAssistant)) {
          userRole = UserRole.EduAssistant;
        } else {
          userRole = UserRole.Professor;
        }
      }
      response.addData("userRole", userRole);
    }

    sendResponse(response);
  }

  public void sendResponse(Response response) {
    String responseString = gson.toJson(response);
    printStream.println(responseString);
    printStream.flush();
  }
}
