package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.*;
import shared.model.users.*;
import shared.util.Config;
import shared.util.Time;
import shared.request.Request;
import shared.response.Response;
import shared.response.ResponseStatus;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientHandler implements Runnable {
  private final Server server;
  private final Socket socket;
  private final PrintStream printStream;
  private final String authToken;
  private final Gson gson;

  private User user;

  public ClientHandler(Server server, Socket socket) throws IOException {
    this.server = server;
    this.socket = socket;
    printStream = new PrintStream(socket.getOutputStream());
    authToken = String.valueOf(new SecureRandom().nextInt());
    printStream.println(authToken);
    printStream.flush();
    gson = new GsonBuilder().create();
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
      case OFFLINE_INFORM:
        handleOfflineInform();
        break;
      case SET_USER:
        user = Controller.getInstance().findUserById(Integer.parseInt(String.valueOf(request.getData("id"))));
        break;
      case LOGIN:
        handleLogin(request);
        break;
      case CHANGE_PASSWORD:
        Response response;
        if (String.valueOf(request.getData("currentPassword")).hashCode() != user.getPassword()) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "incorrectPasswordMessage"));
        } else {
          response = new Response(ResponseStatus.OK);
          Controller.getInstance().changePassword(String.valueOf(request.getData("newPassword")), user);
          Controller.getInstance().setUserLoginTime(user);
          UserRole userRole = null;
          if (user instanceof Student) {
            userRole = UserRole.STUDENT;
          } else if (user instanceof Professor) {
            Professor professor = (Professor) user;
            if (professor.getPosition().equals(Professor.Position.eduAssistant)) {
              userRole = UserRole.EDU_ASSISTANT;
            } else {
              userRole = UserRole.PROFESSOR;
            }
          }
          response.addData("userRole", userRole);
        }
        sendResponse(response);
        break;
      case UPDATE:
        handleUpdate(request);
        break;
      case CHANGE_PHONE_NUMBER:
        if (!(user instanceof MrMohseni)) {
          Controller.getInstance().changePhoneNumber((String) request.getData("phoneNumber"), user);
        }
        sendResponse(new Response(ResponseStatus.OK));
        break;
      case CHANGE_EMAIL:
        if (!(user instanceof MrMohseni)) {
          Controller.getInstance().changeEmail((String) request.getData("email"), user);
        }
        sendResponse(new Response(ResponseStatus.OK));
        break;
      case IS_DEAN:
        Professor professor = (Professor) user;
        sendResponse(new Response(professor.getPosition().equals(Professor.Position.dean) ? ResponseStatus.OK : ResponseStatus.ERROR));
        break;
      case ADD_TEMPORARY_SCORE_BY_STUDENT:
        Controller.getInstance().addTemporaryScore(String.valueOf(user.getId()),
                (String) request.getData("courseId"), (String) request.getData("objection"),
                (String) request.getData("answer"), (String) request.getData("score"));
        sendResponse(new Response(ResponseStatus.OK));
        break;
      case ADD_TEMPORARY_SCORE_BY_PROFESSOR:
        Controller.getInstance().addTemporaryScore((String) request.getData("studentId"),
                (String) request.getData("courseId"), (String) request.getData("objection"),
                (String) request.getData("answer"), (String) request.getData("score"));
        sendResponse(new Response(ResponseStatus.OK));
        break;
      case ADD_SCORE:
        Course course = Controller.getInstance().findCourse(Integer.parseInt(String.valueOf(request.getData("courseId"))));
        if (Integer.parseInt(String.valueOf(request.getData("studentsCount"))) == Controller.getInstance().findTemporaryScoreByCourse(course).length) {
          Controller.getInstance().setFinalScores(course);
          response = new Response(ResponseStatus.OK);
          response.setErrorMessage(getConfig().getProperty(String.class, "submitScoreOkMessage"));
        } else {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "submitScoreErrorMessage"));
        }
        sendResponse(response);
        break;
      case GET_RECOMMENDATION_RESULT:
        Student student = (Student) user;
        professor = Controller.getInstance().findProfessorById(Integer.parseInt((String) request.getData("professorId")));
        if (professor == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "professorNotFoundMessage"));
        } else {
          response = new Response(ResponseStatus.OK);
          EducationalRequest educationalRequest = Controller.getInstance().findRequestByProfessor(student, professor, EducationalRequest.Type.recommendation);
          if (educationalRequest == null) {
            educationalRequest = Controller.getInstance().addRequest(String.valueOf(student.getId()), String.valueOf(professor.getId()),
                    null, null, EducationalRequest.Type.recommendation);
            response.setErrorMessage(getConfig().getProperty(String.class, "requestOkMessage"));
          } else {
            response.setErrorMessage(getConfig().getProperty(String.class, "recommendationErrorMessage"));
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
        if (Controller.getInstance().getPassCredit(student) < getConfig().getProperty(Integer.class, "minorMinCredit")) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "minorCreditErrorMessage"));
        } else if (Controller.getInstance().getAverageScoreByStudent(student) < getConfig().getProperty(Integer.class, "minorMinScore")) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "minorScoreErrorMessage"));
        } else {
          EducationalRequest educationalRequest = Controller.getInstance().addRequest(String.valueOf(student.getId()),
                  null, student.getFacultyName(), (String) request.getData("faculty"),
                  EducationalRequest.Type.minor);
          response = new Response(ResponseStatus.OK);
          response.addData("result", educationalRequest.getResult());
          response.addData("targetFaculty", educationalRequest.getTargetFaculty());
          response.addData("faculties", new String[0]);
          response.setErrorMessage(getConfig().getProperty(String.class, "requestOkMessage"));
        }
        sendResponse(response);
        break;
      case DROPOUT_REQUEST:
        student = (Student) user;
        response = new Response(ResponseStatus.OK);
        EducationalRequest educationalRequest = Controller.getInstance().addRequest(String.valueOf(student.getId()),
                null, student.getFacultyName(), null, EducationalRequest.Type.dropout);
        response.addData("result", educationalRequest.getResult());
        response.setErrorMessage(getConfig().getProperty(String.class, "requestOkMessage"));
        sendResponse(response);
        break;
      case DORMITORY_REQUEST:
        student = (Student) user;
        response = new Response(ResponseStatus.OK);
        response.addData("result", Controller.getInstance().getDormitoryRequest(student));
        response.setErrorMessage(getConfig().getProperty(String.class, "requestOkMessage"));
        sendResponse(response);
        break;
      case DEFENDING_REQUEST:
        student = (Student) user;
        response = new Response(ResponseStatus.OK);
        student.setDefendingTurn(Controller.getInstance().getDefendingTurn(student));
        response.addData("result", student.getDefendingTurn());
        response.setErrorMessage(getConfig().getProperty(String.class, "requestOkMessage"));
        sendResponse(response);
        break;
      case ANSWER_EDUCATIONAL_REQUEST:
        response = new Response(ResponseStatus.OK);
        educationalRequest = Controller.getInstance().findRequestById(Integer.parseInt(String.valueOf(request.getData("requestId"))));
        if (educationalRequest != null && educationalRequest.getType().equals(EducationalRequest.Type.valueOf((String) request.getData("type"))) && !educationalRequest.isFinished()) {
          switch (educationalRequest.getType()) {
            case recommendation:
              if (educationalRequest.getProfessorId().equals(String.valueOf(user.getId()))) {
                Controller.getInstance().answerRecommendation(educationalRequest, (Boolean) request.getData("accepted"));
                response = new Response(ResponseStatus.OK);
                response.setErrorMessage(getConfig().getProperty(String.class, "answerSubmitMessage"));
              } else {
                response = new Response(ResponseStatus.ERROR);
                response.setErrorMessage(getConfig().getProperty(String.class, "requestNotFoundMessage"));
              }
              break;
            case dropout:
              if (educationalRequest.getFaculty().equals(user.getFacultyName())) {
                Controller.getInstance().answerDropout(educationalRequest, Boolean.parseBoolean(String.valueOf(request.getData("accepted"))));
                response = new Response(ResponseStatus.OK);
                response.setErrorMessage(getConfig().getProperty(String.class, "answerSubmitMessage"));
              } else {
                response = new Response(ResponseStatus.ERROR);
                response.setErrorMessage(getConfig().getProperty(String.class, "requestNotFoundMessage"));
              }
              break;
            case minor:
              if (educationalRequest.getFaculty().equals(user.getFacultyName()) || educationalRequest.getTargetFaculty().equals(user.getFacultyName())) {
                Controller.getInstance().answerMinor(educationalRequest, user.getFacultyName(), Boolean.parseBoolean(String.valueOf(request.getData("accepted"))));
                response = new Response(ResponseStatus.OK);
                response.setErrorMessage(getConfig().getProperty(String.class, "answerSubmitMessage"));
              } else {
                response = new Response(ResponseStatus.ERROR);
                response.setErrorMessage(getConfig().getProperty(String.class, "requestNotFoundMessage"));
              }
              break;
          }
        } else {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "requestNotFoundMessage"));
        }
        sendResponse(response);
        break;
      case REMOVE_PROFESSOR:
        int id = Integer.parseInt(String.valueOf(request.getData("professorId")));
        response = new Response(ResponseStatus.OK);
        if (user.getId() == id) {
          response.setErrorMessage(getConfig().getProperty(String.class, "removeDeanErrorMessage"));
        } else {
          if (Controller.getInstance().removeProfessor(id, user.getFacultyName())) {
            response.setErrorMessage(String.format(getConfig().getProperty(String.class, "removeProfessorMessage"), id));
          } else {
            response.setErrorMessage(getConfig().getProperty(String.class, "professorNotFoundMessage"));
          }
        }
        sendResponse(response);
        break;
      case ADD_PROFESSOR:
        id = Controller.getInstance().addProfessor((String) request.getData("name"), (String) request.getData("email"), (String) request.getData("melliCode"),
                user.getFacultyName(), (String) request.getData("phoneNumber"), (String) request.getData("password"), (String) request.getData("roomNumber"),
                (String) request.getData("degree"), (String) request.getData("position"));
        response = new Response(ResponseStatus.OK);
        response.setErrorMessage(String.format(getConfig().getProperty(String.class, "addProfessorMessage"), id));
        sendResponse(response);
        break;
      case CHANGE_PROFESSOR:
        Professor changingProfessor = Controller.getInstance().findProfessorById(Integer.parseInt(String.valueOf(request.getData("professorId"))));
        if (changingProfessor == null || !changingProfessor.getFacultyName().equals(user.getFacultyName())) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "professorNotFoundMessage"));
        } else {
          Controller.getInstance().changeProfessor(changingProfessor, (String) request.getData("name"),
                  (String) request.getData("email"), (String) request.getData("melliCode"),
                  (String) request.getData("phoneNumber"), (String) request.getData("password"),
                  (String) request.getData("roomNumber"), (String) request.getData("degree"),
                  (String) request.getData("position"));
          response = new Response(ResponseStatus.OK);
          response.setErrorMessage(getConfig().getProperty(String.class, "changeProfessorMessage"));
        }
        sendResponse(response);
        break;
      case ADD_COURSE:
        if (Controller.getInstance().findProfessorById(Integer.parseInt(String.valueOf(request.getData("professorId")))) == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "professorNotFoundMessage"));
        } else {
          response = new Response(ResponseStatus.OK);
          id = Controller.getInstance().addCourse((String) request.getData("name"), user.getFacultyName(),
                  (String) request.getData("grade"), (String) request.getData("credit"),
                  (String) request.getData("examTime"), (String) request.getData("classTime"),
                  (String) request.getData("professorId"));
          response.setErrorMessage(String.format(getConfig().getProperty(String.class, "addCourseMessage"), id));
        }
        sendResponse(response);
        break;
      case REMOVE_COURSE:
        id = Integer.parseInt(String.valueOf(request.getData("courseId")));
        response = new Response(ResponseStatus.OK);
        if (Controller.getInstance().removeCourse(id, user.getFacultyName())) {
          response.setErrorMessage(String.format(getConfig().getProperty(String.class, "removeCourseMessage"), id));
        } else {
          response.setErrorMessage(getConfig().getProperty(String.class, "removeCourseMessage"));
        }
        sendResponse(response);
        break;
      case CHANGE_COURSE:
        Course changingCourse = Controller.getInstance().findCourse(Integer.parseInt(String.valueOf(request.getData("courseId"))));
        if (changingCourse == null || !changingCourse.getFacultyName().equals(user.getFacultyName())) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "removeCourseMessage"));
        } else {
          if (Controller.getInstance().findProfessorById(Integer.parseInt((String) request.getData("professorId"))) == null) {
            response = new Response(ResponseStatus.ERROR);
            response.setErrorMessage(getConfig().getProperty(String.class, "professorNotFoundMessage"));
          } else {
            Controller.getInstance().changeCourse(changingCourse, (String) request.getData("name"),
                    (String) request.getData("grade"), (String) request.getData("credit"),
                    (String) request.getData("examDate"), (String) request.getData("classTime"),
                    (String) request.getData("professorId"));
            response = new Response(ResponseStatus.OK);
            response.setErrorMessage(getConfig().getProperty(String.class, "changeCourseMessage"));
          }
        }
        sendResponse(response);
        break;
      case ADD_STUDENT:
        Professor supervisor = Controller.getInstance().findProfessorById(Integer.parseInt((String) request.getData("supervisorId")));
        if (supervisor == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "invalidSupervisorMessage"));
        } else {
          id = Controller.getInstance().addStudent((String) request.getData("name"), (String) request.getData("email"),
                  (String) request.getData("melliCode"), user.getFacultyName(), (String) request.getData("phoneNumber"),
                  (String) request.getData("password"), String.valueOf(supervisor.getId()), (String) request.getData("enteringYear"),
                  (String) request.getData("status"), (String) request.getData("grade"));
          response = new Response(ResponseStatus.OK);
          response.setErrorMessage(String.format(getConfig().getProperty(String.class, "addStudentMessage"), id));
        }
        sendResponse(response);
        break;
      case SEARCH_STUDENT_STATUS_BY_ID:
        id = Integer.parseInt(String.valueOf(request.getData("id")));
        student = Controller.getInstance().findStudentById(id);
        if (student == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "studentNotFoundMessage"));
        } else {
          response = new Response(ResponseStatus.OK);
          response.addData("id", String.valueOf(student.getId()));
          response.addData("name", student.getName());
          response.addData("credit", String.valueOf(Controller.getInstance().getPassCredit(student)));
          response.addData("averageScore", String.valueOf(Controller.getInstance().getAverageScoreByStudent(student)));
          response.addData("data", Controller.getInstance().getScoresData(student));
        }
        sendResponse(response);
        break;
      case SEARCH_STUDENT_STATUS_BY_NAME:
        student = Controller.getInstance().findStudentByName(String.valueOf(request.getData("name")));
        if (student == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "studentNotFoundMessage"));
        } else {
          response = new Response(ResponseStatus.OK);
          response.addData("id", String.valueOf(student.getId()));
          response.addData("name", student.getName());
          response.addData("credit", String.valueOf(Controller.getInstance().getPassCredit(student)));
          response.addData("averageScore", String.valueOf(Controller.getInstance().getAverageScoreByStudent(student)));
          response.addData("data", Controller.getInstance().getScoresData(student));
        }
        sendResponse(response);
        break;
      case SEARCH_COURSE_TEMPORARY:
        course = Controller.getInstance().findCourse(Integer.parseInt(String.valueOf(request.getData("courseId"))));
        if (course == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "courseNotFoundMessage"));
        } else {
          response = new Response(ResponseStatus.OK);
          response.addData("id", String.valueOf(course.getId()));
          response.addData("name", course.getName() == null ? "-" : course.getName());
          response.addData("grade", course.getGrade() == null ? "-" : course.getGrade().name());
          response.addData("professor", Controller.getInstance().findProfessorByCourse(course.getId()) == null ? "-"
                  : Controller.getInstance().findProfessorByCourse(course.getId()).getName());
          response.addData("faculty", course.getFacultyName() == null ? "-" : course.getFacultyName());

          TemporaryScore[] temporaryScores = Controller.getInstance().findTemporaryScoreByCourse(course);
          Score[] scores = Controller.getInstance().findScoreByCourse(course);
          String[] cols;
          String[][] data;
          if (scores.length == 0 && temporaryScores.length == 0) {
            cols = new String[]{"id", "name", "faculty", "grade"};
            data = Controller.getInstance().getStudentsDataByCourse(course);
          } else if (scores.length == 0) {
            cols = new String[]{"id", "name", "faculty", "grade", "objection", "answer", "score"};
            data = Controller.getInstance().getStudentsTemporaryScoreDataByCourse(course);
          } else {
            cols = new String[]{"id", "name", "faculty", "grade", "score"};
            data = Controller.getInstance().getStudentsScoreDataByCourse(course);
          }
          response.addData("cols", cols);
          response.addData("data", data);
        }
        sendResponse(response);
        break;
      case SEARCH_PROFESSOR_TEMPORARY:
        professor = Controller.getInstance().findProfessorById(Integer.parseInt(String.valueOf(request.getData("professorId"))));
        if (professor == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "professorNotFoundMessage"));
        } else {
          response = new Response(ResponseStatus.OK);
          response.addData("id", String.valueOf(professor.getId()));
          response.addData("name", professor.getName() == null ? "-" : professor.getName());
          response.addData("faculty", professor.getFacultyName() == null ? "-" : professor.getFacultyName());
          response.addData("degree", professor.getDegree() == null ? "-" : professor.getDegree());
          response.addData("data", Controller.getInstance().getAllScoresDataByProfessor(professor));
        }
        sendResponse(response);
        break;
      case SEARCH_STUDENT_TEMPORARY:
        student = Controller.getInstance().findStudentById(Integer.parseInt(String.valueOf(request.getData("studentId"))));
        if (student == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "studentNotFoundMessage"));
        } else {
          response = new Response(ResponseStatus.OK);
          response.addData("id", String.valueOf(student.getId()));
          response.addData("name", student.getName() == null ? "-" : student.getName());
          response.addData("grade", student.getGrade() == null ? "-" : student.getGrade().name());
          response.addData("faculty", student.getFacultyName() == null ? "-" : student.getFacultyName());
          response.addData("data", Controller.getInstance().getCourseTemporaryScoreDataByStudent(student));
        }
        sendResponse(response);
        break;
      case SEARCH_COURSE_SUMMARY:
        course = Controller.getInstance().findCourse(Integer.parseInt(String.valueOf(request.getData("courseId"))));
        if (course == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "courseNotFoundMessage"));
        } else if (Controller.getInstance().findScoreByCourse(course).length == 0) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "finalizeScoreErrorMessage"));
        } else {
          response = new Response(ResponseStatus.OK);
          response.addData("id", String.valueOf(course.getId()));
          response.addData("name", course.getName() == null ? "-" : course.getName());
          response.addData("professor", Controller.getInstance().findProfessorByCourse(course.getId()) == null ? "-"
                  : Controller.getInstance().findProfessorByCourse(course.getId()).getName());
          response.addData("grade", course.getGrade() == null ? "-" : course.getGrade().name());
          response.addData("faculty", course.getFacultyName() == null ? "-" : course.getFacultyName());

          response.addData("averageScore", String.valueOf(Controller.getInstance().getAverageScoreByCourse(course)));
          response.addData("studentCount", String.valueOf(Controller.getInstance().getStudentsCount(course)));
          response.addData("passedStudentCount", String.valueOf(Controller.getInstance().getPassStudentsCount(course)));
          response.addData("failStudentCount", String.valueOf(Controller.getInstance().getFailStudentsCount(course)));
          response.addData("averageScoreWithoutFail", String.valueOf(Controller.getInstance().getPassAverageScoreByCourse(course)));
        }
        sendResponse(response);
        break;
      case MESSENGER_SEND_TEXT:
        String contactId = (String) request.getData("contactId");
        Controller.getInstance().sendTextMessage(user, contactId, (String) request.getData("message"));
        break;
      case MESSENGER_SEND_TEXT_MR_MOHSENI:
        Controller.getInstance().sendTextMessage(user, (String) request.getData("message"),
                (String) request.getData("faculty"), (String) request.getData("grade"),
                (String) request.getData("enteringYear"));
        break;
      case MESSENGER_SEND_FILE:
        contactId = (String) request.getData("contactId");
        Controller.getInstance().sendFileMessage(user, contactId, (ArrayList<String>) request.getData("strings"), (String) request.getData("fileName"));
        break;
      case MESSENGER_SEND_FILE_MR_MOHSENI:
        Controller.getInstance().sendFileMessage(user, (ArrayList<String>) request.getData("strings"), (String) request.getData("fileName")
                , (String) request.getData("faculty"), (String) request.getData("grade"),
                (String) request.getData("enteringYear"));
        break;
      case ADD_CONTACT:
        //todo
        User u = Controller.getInstance().findUserById(Integer.parseInt(String.valueOf(request.getData("contactId"))));
        if (u == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "contactNotFoundErrorMessage"));
        } else {
          if (user.getContacts().contains(String.valueOf(u.getId()))) {
            response = new Response(ResponseStatus.ERROR);
            response.setErrorMessage(getConfig().getProperty(String.class, "existContactErrorMessage"));
          } else {
            response = new Response(ResponseStatus.OK);
            user.addContact(String.valueOf(u.getId()));
          }
        }
        sendResponse(response);
        break;
    }
  }

  private void handleUpdate(Request request) {
    PanelName panelName = Enum.valueOf(PanelName.class, (String) request.getData("panelName"));

    Response response = new Response(ResponseStatus.OK);
    switch (panelName) {
      case STUDENT_PANEL:
      case EDU_ASSISTANT_PANEL:
      case PROFESSOR_PANEL:
      case ADMIN_PANEL:
      case MR_MOHSENI_PANEL:
        response.addData("id", String.valueOf(user.getId()));
        response.addData("lastLogin", user.getLastLogIn());
        response.addData("email", user.getEmail());
        response.addData("name", user.getName());
        response.addData("currentTime", Time.getCurrentTime());
        break;
      case STUDENT_MAIN_PANEL:
        Student student = (Student) user;
        response.addData("educationalStatus", student.getStatus());
        response.addData("supervisor", Controller.getInstance().findProfessorById(Integer.parseInt(student.getSupervisorId())).getName());
        break;
      case STUDENT_PROFILE_PANEL:
        student = null;
        if (user instanceof Student) {
          student = (Student) user;
        } else if (user instanceof MrMohseni) {
          student = Controller.getInstance().findStudentById(Integer.parseInt(String.valueOf(request.getData("studentId"))));
        }
        if (student != null) {
          response.addData("id", String.valueOf(student.getId()));
          response.addData("melliCode", student.getMelliCode());
          response.addData("faculty", student.getFacultyName());
          response.addData("phoneNumber", student.getPhoneNumber());
          response.addData("enteringYear", student.getEnteringYear());
          response.addData("grade", student.getGrade());
          response.addData("status", student.getStatus());
          response.addData("supervisor", Controller.getInstance().findProfessorById(Integer.parseInt(student.getSupervisorId())).getName());
          response.addData("averageScore", Controller.getInstance().getAverageScoreByStudent(student));
        }
        break;
      case PROFESSOR_PROFILE_PANEL:
        Professor professor = (Professor) user;
        response.addData("id", String.valueOf(professor.getId()));
        response.addData("melliCode", professor.getMelliCode());
        response.addData("faculty", professor.getFacultyName());
        response.addData("phoneNumber", professor.getPhoneNumber());
        response.addData("degree", professor.getDegree());
        response.addData("roomNumber", professor.getRoomNumber());
        break;
      case COURSES_LIST_PANEL:
      case COURSES_LIST_EDU_PANEL:
        response.addData("faculties", Controller.getInstance().getFacultiesName());
        response.addData("data", Controller.getInstance().getCoursesData((String) request.getData("faculty"),
                (String) request.getData("professor"), (String) request.getData("grade")));
        break;
      case PROFESSORS_LIST_PANEL:
      case PROFESSORS_LIST_DEAN_PANEL:
        response.addData("faculties", Controller.getInstance().getFacultiesName());
        response.addData("data", Controller.getInstance().getProfessorsData((String) request.getData("faculty"),
                (String) request.getData("name"), (String) request.getData("grade")));
        break;
      case STUDENT_EDUCATIONAL_OUT_PANEL:
        response.addData("credit", String.valueOf(Controller.getInstance().getPassCredit((Student) user)));
        response.addData("averageScore", String.valueOf(Controller.getInstance().getAverageScoreByStudent((Student) user)));
        response.addData("data", Controller.getInstance().getScoresData((Student) user));
        break;
      case STUDENT_TEMPORARY_SCORE_LIST:
        response.addData("data", Controller.getInstance().getCourseTemporaryScoreDataByStudent((Student) user));
        break;
      case WEEKLY_SCHEDULE_PANEL:
        response.addData("data", Controller.getInstance().getScheduleData(user));
        break;
      case EXAM_LIST_PANEL:
        response.addData("data", Controller.getInstance().getExamListData(user));
        break;
      case RECOMMENDATION_REQUEST_PANEL:
        student = (Student) user;
        if (student.getGrade() == null || (!student.getGrade().equals(Student.Grade.masters) && !student.getGrade().equals(Student.Grade.underGraduate))) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "sectionForUndergraduateMastersErrorMessage"));
        }
        break;
      case MINOR_REQUEST_PANEL:
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
          response.setErrorMessage(getConfig().getProperty(String.class, "sectionForUndergraduateErrorMessage"));
        }
        break;
      case DROPOUT_REQUEST_PANEL:
        student = (Student) user;
        EducationalRequest educationalRequest = Controller.getInstance().findRequestByFaculty(student, student.getFacultyName(), EducationalRequest.Type.dropout);
        if (educationalRequest != null) {
          response.addData("result", educationalRequest.getResult());
        } else {
          response.addData("result", "");
        }
        break;
      case DORMITORY_REQUEST_PANEL:
        student = (Student) user;
        if (student.getGrade() != null && student.getGrade().equals(Student.Grade.masters)) {
          response.addData("result", student.getDormitoryRequest() == null ? "" : student.getDormitoryRequest());
        } else {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "sectionForMastersErrorMessage"));
        }
        break;
      case DEFENDING_REQUEST_PANEL:
        student = (Student) user;
        if (student.getGrade() != null && student.getGrade().equals(Student.Grade.phd)) {
          response.addData("result", student.getDefendingTurn() == null ? "" : student.getDefendingTurn());
        } else {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "sectionForPhdErrorMessage"));
        }
        break;
      case PROFESSORS_COURSE_LIST:
        professor = (Professor) user;
        response.addData("data", Controller.getInstance().getCoursesDataByProfessor(professor));
        break;
      case PROFESSOR_TEMPORARY_SCORE_LIST:
        Course course = Controller.getInstance().findCourse(Integer.parseInt((String) request.getData("courseId")));
        response.addData("data", Controller.getInstance().getStudentsTemporaryScoreDataByCourse(course));
        response.addData("courseName", course.getName() == null ? "-" : course.getName());
        response.addData("courseId", String.valueOf(course.getId()));
        response.addData("faculty", course.getFacultyName() == null ? "-" : course.getFacultyName());
        response.addData("credit", String.valueOf(course.getCredit()));
        response.addData("grade", course.getGrade() == null ? "-" : course.getGrade().name());
        break;
      case RECOMMENDATION_LIST_PANEL:
        response.addData("data", Controller.getInstance().getRecommendationData((Professor) user, EducationalRequest.Type.recommendation));
        break;
      case ADD_PROFESSOR_DEAN_PANEL:
        String[] positions;
        if (Controller.getInstance().findEduAssistantByFaculty(user.getFacultyName()) == null) {
          positions = new String[]{Professor.Position.professor.name(), Professor.Position.eduAssistant.name()};
        } else {
          positions = new String[]{Professor.Position.professor.name()};
        }
        response.addData("positions", positions);
        break;
      case CHANGE_PROFESSOR_PANEL:
        Professor changingProfessor = Controller.getInstance().findProfessorById(Integer.parseInt(String.valueOf(request.getData("professorId"))));
        if (changingProfessor == null || !changingProfessor.getFacultyName().equals(user.getFacultyName())) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("professor not found");
        } else {
          response.addData("id", String.valueOf(changingProfessor.getId()));
          response.addData("name", changingProfessor.getName() == null ? "" : changingProfessor.getName());
          response.addData("melliCode", changingProfessor.getMelliCode() == null ? "" : changingProfessor.getMelliCode());
          response.addData("email", changingProfessor.getEmail() == null ? "" : changingProfessor.getEmail());
          response.addData("phoneNumber", changingProfessor.getPhoneNumber() == null ? "" : changingProfessor.getPhoneNumber());
          response.addData("roomNumber", changingProfessor.getRoomNumber() == null ? "" : changingProfessor.getRoomNumber());
          String[] degrees;
          if (changingProfessor.getDegree() == null || changingProfessor.getDegree().equals(Professor.Degree.assistant)) {
            degrees = new String[]{Professor.Degree.assistant.name(), Professor.Degree.associate.name(), Professor.Degree.full.name()};
          } else if (changingProfessor.getDegree().equals(Professor.Degree.associate)) {
            degrees = new String[]{Professor.Degree.associate.name(), Professor.Degree.assistant.name(), Professor.Degree.full.name()};
          } else {
            degrees = new String[]{Professor.Degree.full.name(), Professor.Degree.assistant.name(), Professor.Degree.associate.name()};
          }
          response.addData("degrees", degrees);
          if (changingProfessor.getPosition() == null || changingProfessor.getPosition().equals(Professor.Position.professor)) {
            if (Controller.getInstance().findEduAssistantByFaculty(user.getFacultyName()) == null) {
              positions = new String[]{Professor.Position.professor.name(), Professor.Position.eduAssistant.name()};
            } else {
              positions = new String[]{Professor.Position.professor.name()};
            }
          } else if (changingProfessor.getPosition().equals(Professor.Position.eduAssistant)) {
            positions = new String[]{Professor.Position.eduAssistant.name(), Professor.Position.professor.name()};
          } else {
            positions = new String[]{Professor.Position.dean.name()};
          }
          response.addData("positions", positions);
        }
        break;
      case CHANGE_COURSE_PANEL:
        Course changingCourse = Controller.getInstance().findCourse(Integer.parseInt(String.valueOf(request.getData("courseId"))));
        if (changingCourse == null || !changingCourse.getFacultyName().equals(user.getFacultyName())) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage(getConfig().getProperty(String.class, "courseNotFoundMessage"));
        } else {
          response.addData("id", String.valueOf(changingCourse.getId()));
          response.addData("name", changingCourse.getName() == null ? "" : changingCourse.getName());
          response.addData("professorId", Controller.getInstance().findProfessorByCourse(changingCourse.getId()) == null ?
                  "" : String.valueOf(Controller.getInstance().findProfessorByCourse(changingCourse.getId()).getId()));
          response.addData("credit", String.valueOf(changingCourse.getCredit()));
          response.addData("classTime", changingCourse.getClassTime() == null ? "" : changingCourse.getClassTime());
          if (changingCourse.getExamTime() != null) {
            String[] exam = changingCourse.getExamTime().split(" ");
            String[] examDate = exam[0].split("/");
            String[] examTime = exam[1].split(":");
            response.addData("examYear", examDate[0]);
            response.addData("examMonth", examDate[1]);
            response.addData("examDay", examDate[2]);
            response.addData("examHour", examTime[0]);
            response.addData("examMinute", examTime[1]);
          } else {
            response.addData("examYear", "");
            response.addData("examMonth", "");
            response.addData("examDay", "");
            response.addData("examHour", "");
            response.addData("examMinute", "");
          }
          String[] grades;
          if (changingCourse.getGrade() == null || changingCourse.getGrade().equals(Student.Grade.underGraduate)) {
            grades = new String[]{Student.Grade.underGraduate.name(), Student.Grade.masters.name(), Student.Grade.phd.name()};
          } else if (changingCourse.getGrade().equals(Student.Grade.masters)) {
            grades = new String[]{Student.Grade.masters.name(), Student.Grade.phd.name(), Student.Grade.underGraduate.name()};
          } else {
            grades = new String[]{Student.Grade.phd.name(), Student.Grade.underGraduate.name(), Student.Grade.masters.name()};
          }
          response.addData("grades", grades);
        }
        break;
      case DROPOUT_LIST_PANEL:
        response.addData("data", Controller.getInstance().getDropoutData(user.getFacultyName(), EducationalRequest.Type.dropout));
        break;
      case MINOR_LIST_PANEL:
        response.addData("data", Controller.getInstance().getMinorData(user.getFacultyName(), EducationalRequest.Type.minor));
        break;
      case MESSENGER_PANEL:
        response.addData("chats", user.getMessenger().getChats());
        String contactId = (String) request.getData("contactId");
        if (!contactId.equals("0")) {
          response.addData("chat", user.getMessenger().getChat(contactId));
        }
        break;
      case CREATE_CHAT_PANEL:
        response.addData("data", Controller.getInstance().getContactData(user));
        if (user instanceof MrMohseni) {
          response.addData("faculties", Controller.getInstance().getFacultiesName());
        }
        break;
      case SEARCH_STUDENT_PANEL:
        response.addData("data", Controller.getInstance().getStudentsDataByBeginId((String) request.getData("studentId")));
        break;
    }
    sendResponse(response);
  }

  private void handleLogin(Request request) {
    User user = Controller.getInstance().logIn(Integer.parseInt(String.valueOf(request.getData("id"))), (String) request.getData("password"));
    Response response;

    if (user == null) {
      response = new Response(ResponseStatus.ERROR);
      response.setErrorMessage(getConfig().getProperty(String.class, "loginErrorMessage"));
    } else {
      this.user = user;
      if (Time.needToChangPassword(user)) {
        response = new Response(ResponseStatus.ERROR);
      } else {
        Controller.getInstance().setUserLoginTime(user);
        response = new Response(ResponseStatus.OK);

        UserRole userRole = null;
        if (user instanceof Student) {
          userRole = UserRole.STUDENT;
        } else if (user instanceof Professor) {
          Professor professor = (Professor) user;
          if (professor.getPosition().equals(Professor.Position.eduAssistant)) {
            userRole = UserRole.EDU_ASSISTANT;
          } else {
            userRole = UserRole.PROFESSOR;
          }
        } else if (user instanceof Admin) {
          userRole = UserRole.ADMIN;
        } else if (user instanceof MrMohseni) {
          userRole = UserRole.MR_MOHSENI;
        }
        response.addData("userRole", userRole);
      }
    }

    sendResponse(response);
  }

  private void handleOfflineInform() {
    Controller.getInstance().saveData();
    Response response = new Response(ResponseStatus.OK);

    response.addData("id", String.valueOf(user.getId()));
    response.addData("lastLogin", user.getLastLogIn());
    response.addData("email", user.getEmail());
    response.addData("name", user.getName());

    response.addData("melliCode", user.getMelliCode());
    response.addData("faculty", user.getFacultyName());
    response.addData("phoneNumber", user.getPhoneNumber());
    UserRole userRole = null;
    if (user instanceof Student) {
      Student student = (Student) user;
      userRole = UserRole.STUDENT;
      response.addData("weeklyScheduleData", Controller.getInstance().getScheduleData(user));
      response.addData("examListData", Controller.getInstance().getExamListData(user));

      response.addData("educationalStatus", student.getStatus());
      response.addData("supervisor", Controller.getInstance().findProfessorById(Integer.parseInt(student.getSupervisorId())).getName());
      response.addData("enteringYear", student.getEnteringYear());
      response.addData("grade", student.getGrade());
      response.addData("status", student.getStatus());
      response.addData("supervisor", Controller.getInstance().findProfessorById(Integer.parseInt(student.getSupervisorId())).getName());
      response.addData("averageScore", Controller.getInstance().getAverageScoreByStudent(student));

      response.addData("credit", String.valueOf(Controller.getInstance().getPassCredit(student)));
      response.addData("averageScore", String.valueOf(Controller.getInstance().getAverageScoreByStudent(student)));
      response.addData("educationalData", Controller.getInstance().getScoresData(student));
    } else if (user instanceof Professor) {
      response.addData("weeklyScheduleData", Controller.getInstance().getScheduleData(user));
      response.addData("examListData", Controller.getInstance().getExamListData(user));
      Professor professor = (Professor) user;
      response.addData("degree", professor.getDegree());
      response.addData("roomNumber", professor.getRoomNumber());
      if (professor.getPosition().equals(Professor.Position.eduAssistant)) {
        userRole = UserRole.EDU_ASSISTANT;
      } else {
        userRole = UserRole.PROFESSOR;
      }
    } else if (user instanceof Admin) {
      userRole = UserRole.ADMIN;
    } else if (user instanceof MrMohseni) {
      userRole = UserRole.MR_MOHSENI;
    }
    response.addData("userRole", userRole);

    response.addData("chats", user.getMessenger().getChats());

    sendResponse(response);
  }

  public void sendResponse(Response response) {
    String responseString = gson.toJson(response);
    printStream.println(responseString);
    printStream.flush();
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty("serverConfig"));
  }
}
