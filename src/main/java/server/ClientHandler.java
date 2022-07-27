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
        Response response;
        Course course = Controller.getInstance().findCourse(Integer.parseInt(String.valueOf(request.getData("courseId"))));
        if (Integer.parseInt(String.valueOf(request.getData("studentsCount"))) == Controller.getInstance().findTemporaryScoreByCourse(course).length) {
          Controller.getInstance().setFinalScores(course);
          response = new Response(ResponseStatus.OK);
          response.setErrorMessage("scores submitted");
        } else {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("scores must submit temporary first");
        }
        sendResponse(response);
        break;
      case GET_RECOMMENDATION_RESULT:
        Student student = (Student) user;
        professor = Controller.getInstance().findProfessorById(Integer.parseInt((String) request.getData("professorId")));
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
      case DROPOUT_REQUEST:
        student = (Student) user;
        response = new Response(ResponseStatus.OK);
        EducationalRequest educationalRequest = Controller.getInstance().addRequest(String.valueOf(student.getId()),
                null, student.getFacultyName(), null, EducationalRequest.Type.dropout);
        response.addData("result", educationalRequest.getResult());
        response.setErrorMessage("your request submitted");
        sendResponse(response);
        break;
      case DORMITORY_REQUEST:
        student = (Student) user;
        response = new Response(ResponseStatus.OK);
        response.addData("result", Controller.getInstance().getDormitoryRequest(student));
        response.setErrorMessage("your request submitted");
        sendResponse(response);
        break;
      case DEFENDING_REQUEST:
        student = (Student) user;
        response = new Response(ResponseStatus.OK);
        student.setDefendingTurn(Controller.getInstance().getDefendingTurn(student));
        response.addData("result", student.getDefendingTurn());
        response.setErrorMessage("your request submitted");
        sendResponse(response);
        break;
      case ANSWER_RECOMMENDATION:
        educationalRequest = Controller.getInstance().findRequestById(Integer.parseInt(String.valueOf(request.getData("requestId"))));
        if (educationalRequest != null && educationalRequest.getType().equals(EducationalRequest.Type.recommendation)
                && educationalRequest.getProfessorId().equals(String.valueOf(user.getId()))
                && !educationalRequest.isFinished()) {
          Controller.getInstance().answerRecommendation(educationalRequest, (Boolean) request.getData("accepted"));
          response = new Response(ResponseStatus.OK);
          response.setErrorMessage("answer submitted");
        } else {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("request not found");
        }
        sendResponse(response);
        break;
      case REMOVE_PROFESSOR:
        int id = Integer.parseInt(String.valueOf(request.getData("professorId")));
        response = new Response(ResponseStatus.OK);
        if(user.getId() == id) {
          response.setErrorMessage("you can't remove yourself");
        } else {
          if (Controller.getInstance().removeProfessor(id, user.getFacultyName())) {
            response.setErrorMessage("professor with id: " + id + " removed");
          } else {
            response.setErrorMessage("professor not found");
          }
        }
        sendResponse(response);
        break;
      case ADD_PROFESSOR:
        id = Controller.getInstance().addProfessor((String) request.getData("name"), (String) request.getData("email"), (String) request.getData("melliCode"),
                user.getFacultyName(), (String) request.getData("phoneNumber"), (String) request.getData("password"), (String) request.getData("roomNumber"),
                (String) request.getData("degree"), (String) request.getData("position"));
        response = new Response(ResponseStatus.OK);
        response.setErrorMessage("professor with id " + id + " added");
        sendResponse(response);
        break;
      case CHANGE_PROFESSOR:
        Professor changingProfessor = Controller.getInstance().findProfessorById(Integer.parseInt(String.valueOf(request.getData("professorId"))));
        if (changingProfessor == null || !changingProfessor.getFacultyName().equals(user.getFacultyName())) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("professor not found");
        } else {
          Controller.getInstance().changeProfessor(changingProfessor, (String) request.getData("name"),
                  (String) request.getData("email"), (String) request.getData("melliCode"),
                  (String) request.getData("phoneNumber"), (String) request.getData("password"),
                  (String) request.getData("roomNumber"), (String) request.getData("degree"),
                  (String) request.getData("position"));
          response = new Response(ResponseStatus.OK);
          response.setErrorMessage("professor's information changed");
        }
        sendResponse(response);
        break;
      case ADD_COURSE:
        if (Controller.getInstance().findProfessorById(Integer.parseInt(String.valueOf(request.getData("professorId")))) == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("professor not found");
        } else {
          response = new Response(ResponseStatus.OK);
          id = Controller.getInstance().addCourse((String) request.getData("name"), user.getFacultyName(),
                  (String) request.getData("grade"), (String) request.getData("credit"),
                  (String) request.getData("examTime"), (String) request.getData("classTime"),
                  (String) request.getData("professorId"));
          response.setErrorMessage("course with id: " + id + " added");
        }
        sendResponse(response);
        break;
      case REMOVE_COURSE:
        id = Integer.parseInt(String.valueOf(request.getData("courseId")));
        response = new Response(ResponseStatus.OK);
        if(Controller.getInstance().removeCourse(id, user.getFacultyName())) {
          response.setErrorMessage("course with id: " + id + " removed");
        } else {
          response.setErrorMessage("course not found");
        }
        sendResponse(response);
        break;
      case CHANGE_COURSE:
        Course changingCourse = Controller.getInstance().findCourse(Integer.parseInt(String.valueOf(request.getData("courseId"))));
        if (changingCourse == null || !changingCourse.getFacultyName().equals(user.getFacultyName())) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("course not found");
        } else {
          if (Controller.getInstance().findProfessorById(Integer.parseInt((String) request.getData("professorId"))) == null) {
            response = new Response(ResponseStatus.ERROR);
            response.setErrorMessage("professor not found");
          } else {
            Controller.getInstance().changeCourse(changingCourse, (String) request.getData("name"),
                    (String) request.getData("grade"), (String) request.getData("credit"),
                    (String) request.getData("examDate"), (String) request.getData("classTime"),
                    (String) request.getData("professorId"));
            response = new Response(ResponseStatus.OK);
            response.setErrorMessage("course's information changed");
          }
        }
        sendResponse(response);
        break;
      case ADD_STUDENT:
        Professor supervisor = Controller.getInstance().findProfessorById(Integer.parseInt((String) request.getData("supervisorId")));
        if (supervisor == null) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("invalid supervisor id");
        } else {
          id = Controller.getInstance().addStudent((String) request.getData("name"), (String) request.getData("email"),
          (String) request.getData("melliCode"), user.getFacultyName(), (String) request.getData("phoneNumber"),
                  (String) request.getData("password"), String.valueOf(supervisor.getId()), (String) request.getData("enteringYear"),
                  (String) request.getData("status"), (String) request.getData("grade"));
          response = new Response(ResponseStatus.OK);
          response.setErrorMessage("student with id " + id + " added");
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
      case CoursesListEduPanel:
        response.addData("faculties", Controller.getInstance().getFacultiesName());
        response.addData("data", Controller.getInstance().getCoursesData((String) request.getData("faculty"),
                (String) request.getData("professor"), (String) request.getData("grade")));
        break;
      case ProfessorsListPanel:
      case ProfessorsListDeanPanel:
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
      case DropoutRequestPanel:
        student = (Student) user;
        EducationalRequest educationalRequest = Controller.getInstance().findRequestByFaculty(student, student.getFacultyName(), EducationalRequest.Type.dropout);
        if (educationalRequest != null) {
          response.addData("result", educationalRequest.getResult());
        } else {
          response.addData("result", "");
        }
        break;
      case DormitoryRequestPanel:
        student = (Student) user;
        if (student.getGrade() != null && student.getGrade().equals(Student.Grade.masters)) {
          response.addData("result", student.getDormitoryRequest()==null ? "" : student.getDormitoryRequest());
        } else {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("this section is only for masters students");
        }
        break;
      case DefendingRequestPanel:
        student = (Student) user;
        if (student.getGrade() != null && student.getGrade().equals(Student.Grade.phd)) {
          response.addData("result", student.getDefendingTurn()==null ? "" : student.getDefendingTurn());
        } else {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("this section is only for phd students");
        }
        break;
      case ProfessorsCourseList:
        professor = (Professor) user;
        response.addData("data", Controller.getInstance().getCoursesDataByProfessor(professor));
        break;
      case ProfessorTemporaryScoreList:
        Course course = Controller.getInstance().findCourse(Integer.parseInt((String) request.getData("courseId")));
        response.addData("data", Controller.getInstance().getStudentsTemporaryScoreDataByCourse(course));
        response.addData("courseName", course.getName()==null ? "-" : course.getName());
        response.addData("courseId", String.valueOf(course.getId()));
        response.addData("faculty", course.getFacultyName()==null ? "-" : course.getFacultyName());
        response.addData("credit", String.valueOf(course.getCredit()));
        response.addData("grade", course.getGrade()==null ? "-" : course.getGrade().name());
        break;
      case RecommendationListPanel:
        response.addData("data", Controller.getInstance().getRecommendationData((Professor) user, EducationalRequest.Type.recommendation));
        break;
      case AddProfessorDeanPanel:
        String[] positions;
        if (Controller.getInstance().findEduAssistantByFaculty(user.getFacultyName()) == null) {
          positions = new String[]{Professor.Position.professor.name(), Professor.Position.eduAssistant.name()};
        } else {
          positions = new String[]{Professor.Position.professor.name()};
        }
        response.addData("positions", positions);
        break;
      case ChangeProfessorPanel:
        Professor changingProfessor = Controller.getInstance().findProfessorById(Integer.parseInt(String.valueOf(request.getData("professorId"))));
        if (changingProfessor == null || !changingProfessor.getFacultyName().equals(user.getFacultyName())) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("professor not found");
        } else {
          response.addData("id", String.valueOf(changingProfessor.getId()));
          response.addData("name", changingProfessor.getName()==null ? "" : changingProfessor.getName());
          response.addData("melliCode", changingProfessor.getMelliCode()==null ? "" : changingProfessor.getMelliCode());
          response.addData("email", changingProfessor.getEmail()==null ? "" : changingProfessor.getEmail());
          response.addData("phoneNumber", changingProfessor.getPhoneNumber()==null ? "" : changingProfessor.getPhoneNumber());
          response.addData("roomNumber", changingProfessor.getRoomNumber()==null ? "" : changingProfessor.getRoomNumber());
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
      case ChangeCoursePanel:
        Course changingCourse = Controller.getInstance().findCourse(Integer.parseInt(String.valueOf(request.getData("courseId"))));
        if (changingCourse == null || !changingCourse.getFacultyName().equals(user.getFacultyName())) {
          response = new Response(ResponseStatus.ERROR);
          response.setErrorMessage("course not found");
        } else {
          response.addData("id", String.valueOf(changingCourse.getId()));
          response.addData("name", changingCourse.getName()==null ? "" : changingCourse.getName());
          response.addData("professorId", Controller.getInstance().findProfessorByCourse(changingCourse.getId())==null ?
                  "" : String.valueOf(Controller.getInstance().findProfessorByCourse(changingCourse.getId()).getId()));
          response.addData("credit", String.valueOf(changingCourse.getCredit()));
          response.addData("classTime", changingCourse.getClassTime()==null ? "" : changingCourse.getClassTime());
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
            grades = new String[] {Student.Grade.underGraduate.name(), Student.Grade.masters.name(), Student.Grade.phd.name()};
          } else if (changingCourse.getGrade().equals(Student.Grade.masters)) {
            grades = new String[] {Student.Grade.masters.name(), Student.Grade.phd.name(), Student.Grade.underGraduate.name()};
          } else {
            grades = new String[] {Student.Grade.phd.name(), Student.Grade.underGraduate.name(), Student.Grade.masters.name()};
          }
          response.addData("grades", grades);
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
