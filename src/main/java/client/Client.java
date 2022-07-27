package client;

import GUI.*;
import GUI.professors.*;
import GUI.professors.dean.AddProfessorDeanPanel;
import GUI.professors.dean.ChangeProfessorPanel;
import GUI.professors.dean.ProfessorsListDeanPanel;
import GUI.professors.dean.RemoveProfessorPanel;
import GUI.professors.eduAssistant.*;
import GUI.student.*;
import shared.model.PanelName;
import shared.model.users.*;
import shared.request.*;
import shared.response.*;

import javax.swing.*;
import java.util.ArrayList;

public class Client {
  private final MainFrame mainFrame;
  private ServerController serverController;
  private final int port;

  public Client(int port) {
    this.port = port;
    mainFrame = new MainFrame(this);
  }

  public void kill() {
    serverController.kill();
  }

  public void start() {
    serverController = new ServerController(port);
    serverController.connectToServer();
    loginCLI();
  }

  private void loginCLI() {
    mainFrame.setContentPane(new LogInPanel(mainFrame, this));
  }

  public void login(int id, String password) {
    Response response = serverController.sendLoginRequest(id, password);

    if (response.getStatus().equals(ResponseStatus.OK)) {
      mainPanelCLI(response);
    } else {
      loginCLI();
      mainFrame.showMessage(response.getErrorMessage());
    }
  }

  private void mainPanelCLI(Response response) {
    if (String.valueOf(response.getData("userRole")).equals(UserRole.Student.toString())) {
      changePanel(PanelName.StudentMainPanel, null);
    } else if (String.valueOf(response.getData("userRole")).equals(UserRole.EduAssistant.toString())) {
      changePanel(PanelName.EduAssistantPanel, null);
    } else if (String.valueOf(response.getData("userRole")).equals(UserRole.Professor.toString())) {
      changePanel(PanelName.ProfessorPanel, null);
    }
  }

  private void updateStudentPanel(StudentPanel studentPanel) {
    Response response = serverController.sendUpdateRequest(PanelName.StudentPanel);
    studentPanel.update((int) Double.parseDouble(String.valueOf(response.getData("id"))),
            (String) response.getData("lastLogin"), (String) response.getData("email"),
            (String) response.getData("name"), (String) response.getData("currentTime"));
  }

  private void updateProfessorPanel(ProfessorPanel professorPanel) {
    Response response = serverController.sendUpdateRequest(PanelName.ProfessorPanel);
    professorPanel.update((int) Double.parseDouble(String.valueOf(response.getData("id"))),
            (String) response.getData("lastLogin"), (String) response.getData("email"),
            (String) response.getData("name"), (String) response.getData("currentTime"));
  }

  private void updateEduAssistantPanel(EduAssistantPanel eduAssistantPanel) {
    Response response = serverController.sendUpdateRequest(PanelName.EduAssistantPanel);
    eduAssistantPanel.update((int) Double.parseDouble(String.valueOf(response.getData("id"))),
            (String) response.getData("lastLogin"), (String) response.getData("email"),
            (String) response.getData("name"), (String) response.getData("currentTime"));
  }

  public void logout() {
    Loop.stopCurrent();
    loginCLI();
  }

  public void changePanel(PanelName panelName, UserRole userRole) {
    switch (panelName) {
      case StudentMainPanel:
        changeToStudentMainPanel();
        break;
      case ProfessorPanel:
        changeToProfessorPanel();
        break;
      case EduAssistantPanel:
        changeToEduAssistantPanel();
        break;
      case StudentProfilePanel:
        changeToStudentProfilePanel();
        break;
      case ProfessorProfilePanel:
        changeToProfessorProfilePanel(userRole);
        break;
      case StudentEducationalOutPanel:
        changeToStudentEducationalPanel();
        break;
      case StudentTemporaryScoreList:
        changeToStudentTemporaryScoreList();
        break;
      case WeeklySchedulePanel:
        changeToWeeklySchedulePanel(userRole);
        break;
      case ExamListPanel:
        changeToExamListPanel(userRole);
        break;
      case RecommendationRequestPanel:
        changeToRecommendationRequestPanel();
        break;
      case EnrollmentCertificatePanel:
        changeToEnrollmentCertificatePanel();
        break;
      case MinorRequestPanel:
        changeToMinorRequestPanel();
        break;
      case DropoutRequestPanel:
        changeToDropoutRequestPanel();
        break;
      case DormitoryRequestPanel:
        changeToDormitoryRequestPanel();
        break;
      case DefendingRequestPanel:
        changeToDefendingRequestPanel();
        break;
      case ProfessorsCourseList:
        changeToProfessorsCourseList(userRole);
        break;
      case RecommendationListPanel:
        changeToRecommendationListPanel(userRole);
        break;
      case AnswerRecommendationPanel:
        changeToAnswerRecommendationPanel(userRole);
        break;
      case RemoveProfessorPanel:
        changeToRemoveProfessorPanel();
        break;
      case AddProfessorDeanPanel:
        changeToAddProfessorDeanPanel();
        break;
      case ChangeProfessorPanel:
        changeToChangeProfessorPanel();
        break;
      case AddCoursePanel:
        changeToAddCoursePanel();
        break;
      case RemoveCoursePanel:
        changeToRemoveCoursePanel();
        break;
      case ChangeCoursePanel:
        changeToChangeCoursePanel();
        break;
      case AddStudentOrProfessorPanel:
        changeToAddStudentOrProfessorPanel();
        break;
      case AddProfessorPanel:
        changeToAddProfessorPanel();
    }
  }

  private void changeToStudentMainPanel() {
    StudentMainPanel studentMainPanel = new StudentMainPanel();
    StudentPanel studentPanel = new StudentPanel(mainFrame, studentMainPanel, this);
    mainFrame.setContentPane(studentPanel);

    new Loop(1, () -> {
      Response response1 = serverController.sendUpdateRequest(PanelName.StudentMainPanel);
      studentMainPanel.update((String) response1.getData("educationalStatus"),
              (String) response1.getData("supervisor"));

      updateStudentPanel(studentPanel);
    }).start();
  }

  private void changeToProfessorPanel() {
    ProfessorPanel professorPanel = new ProfessorPanel(mainFrame, new JPanel(), this);
    mainFrame.setContentPane(professorPanel);

    new Loop(1, () -> updateProfessorPanel(professorPanel)).start();
  }

  private void changeToEduAssistantPanel() {
    EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, new JPanel(), this);
    mainFrame.setContentPane(eduAssistantPanel);

    new Loop(1, () -> updateEduAssistantPanel(eduAssistantPanel)).start();
  }

  private void changeToStudentProfilePanel() {
    StudentProfilePanel studentProfilePanel = new StudentProfilePanel(mainFrame, this);
    StudentPanel studentPanel = new StudentPanel(mainFrame, studentProfilePanel, this);
    mainFrame.setContentPane(studentPanel);

    new Loop(1, () -> {
      Response response = serverController.sendUpdateRequest(PanelName.StudentProfilePanel);
      studentProfilePanel.update((int) Double.parseDouble(String.valueOf(response.getData("id"))),
              (String) response.getData("melliCode"), (String) response.getData("faculty"),
              (String) response.getData("phoneNumber"), (String) response.getData("enteringYear"),
              (String) response.getData("grade"), (String) response.getData("status"),
              (String) response.getData("supervisor"), Double.parseDouble(String.valueOf(response.getData("averageScore"))));

      updateStudentPanel(studentPanel);
    }).start();
  }

  private void changeToProfessorProfilePanel(UserRole userRole) {
    ProfessorProfilePanel professorProfilePanel = new ProfessorProfilePanel(mainFrame, this);
    JPanel jPanel = null;
    if (userRole.equals(UserRole.EduAssistant)) {
      jPanel = new EduAssistantPanel(mainFrame, professorProfilePanel, this);
    } else if (userRole.equals(UserRole.Professor)) {
      jPanel = new ProfessorPanel(mainFrame, professorProfilePanel, this);
    }
    mainFrame.setContentPane(jPanel);

    JPanel finalJPanel = jPanel;
    new Loop(1, () -> {
      Response response = serverController.sendUpdateRequest(PanelName.ProfessorProfilePanel);
      professorProfilePanel.update((int) Double.parseDouble(String.valueOf(response.getData("id"))),
              (String) response.getData("melliCode"), (String) response.getData("faculty"),
              (String) response.getData("phoneNumber"), (String) response.getData("degree"),
              (String) response.getData("roomNumber"));

      if (userRole.equals(UserRole.EduAssistant)) {
        EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) finalJPanel;
        updateEduAssistantPanel(eduAssistantPanel);
      } else if (userRole.equals(UserRole.Professor)) {
        ProfessorPanel professorPanel = (ProfessorPanel) finalJPanel;
        updateProfessorPanel(professorPanel);
      }
    }).start();
  }

  public void changePhoneNumber(String phoneNumber) {
    Response response = serverController.sendChangePhoneNumberRequest(phoneNumber);
    if (response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage("successfully changed");
    }
  }

  public void changeEmail(String email) {
    Response response = serverController.sendChangeEmailRequest(email);
    if (response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage("successfully changed");
    }
  }

  public void changeToCoursesListPanel(UserRole userRole, String faculty, String professor, String grade) {
    CoursesListPanel coursesListPanel = new CoursesListPanel(mainFrame, this, userRole);
    JPanel jPanel = null;
    if (userRole.equals(UserRole.Student)) {
      jPanel = new StudentPanel(mainFrame, coursesListPanel, this);
    } else if ((userRole.equals(UserRole.Professor))) {
      jPanel = new ProfessorPanel(mainFrame, coursesListPanel, this);
    }
    mainFrame.setContentPane(jPanel);

    Request request = new Request(RequestType.UPDATE);
    request.addData("faculty", faculty);
    request.addData("professor", professor);
    request.addData("grade", grade);
    Response response = serverController.sendUpdateRequest(PanelName.CoursesListPanel, request);

    ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
    ArrayList<String[]> strings = new ArrayList<>();
    for (ArrayList<String> arrayList1 : arrayList) {
      strings.add(arrayList1.toArray(new String[0]));
    }
    coursesListPanel.update(((ArrayList<String>) response.getData("faculties")).toArray(new String[0]),
            ((strings.toArray(new String[0][0]))));

    JPanel finalJPanel = jPanel;
    new Loop(1, () -> {
      if (userRole.equals(UserRole.Student)) {
        StudentPanel studentPanel = (StudentPanel) finalJPanel;
        updateStudentPanel(studentPanel);
      } else if (userRole.equals(UserRole.Professor)) {
        ProfessorPanel professorPanel = (ProfessorPanel) finalJPanel;
        updateProfessorPanel(professorPanel);
      }
    }).start();
  }

  public void changeToProfessorsListPanel(UserRole userRole, String faculty, String name, String grade) {
    if (userRole.equals(UserRole.Professor)) {
      Response response = serverController.sendIsDeanRequest();
      if (response.getStatus().equals(ResponseStatus.OK)) {
        ProfessorsListDeanPanel professorsListDeanPanel = new ProfessorsListDeanPanel(mainFrame, this);
        ProfessorPanel professorPanel = new ProfessorPanel(mainFrame, professorsListDeanPanel, this);
        mainFrame.setContentPane(professorPanel);

        Request request = new Request(RequestType.UPDATE);
        request.addData("faculty", faculty);
        request.addData("name", name);
        request.addData("grade", grade);
        Response response1 = serverController.sendUpdateRequest(PanelName.ProfessorsListDeanPanel, request);

        ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response1.getData("data");
        ArrayList<String[]> strings = new ArrayList<>();
        for (ArrayList<String> arrayList1 : arrayList) {
          strings.add(arrayList1.toArray(new String[0]));
        }
        professorsListDeanPanel.update((((ArrayList<String>) response1.getData("faculties")).toArray(new String[0])),
                ((strings.toArray(new String[0][0]))));

        new Loop(1, () -> updateProfessorPanel(professorPanel)).start();
        return;
      }
    }

    ProfessorsListPanel professorsListPanel = new ProfessorsListPanel(mainFrame, this, userRole);
    JPanel jPanel = null;
    if (userRole.equals(UserRole.Student)) {
      jPanel = new StudentPanel(mainFrame, professorsListPanel, this);
    } else if ((userRole.equals(UserRole.Professor))) {
      jPanel = new ProfessorPanel(mainFrame, professorsListPanel, this);
    } else if (userRole.equals(UserRole.EduAssistant)) {
      jPanel = new EduAssistantPanel(mainFrame, professorsListPanel, this);
    }
    mainFrame.setContentPane(jPanel);

    Request request = new Request(RequestType.UPDATE);
    request.addData("faculty", faculty);
    request.addData("name", name);
    request.addData("grade", grade);
    Response response = serverController.sendUpdateRequest(PanelName.ProfessorsListPanel, request);

    ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
    ArrayList<String[]> strings = new ArrayList<>();
    for (ArrayList<String> arrayList1 : arrayList) {
      strings.add(arrayList1.toArray(new String[0]));
    }
    professorsListPanel.update((((ArrayList<String>) response.getData("faculties")).toArray(new String[0])),
            ((strings.toArray(new String[0][0]))));

    JPanel finalJPanel = jPanel;
    new Loop(1, () -> {
      if (userRole.equals(UserRole.Student)) {
        StudentPanel studentPanel = (StudentPanel) finalJPanel;
        updateStudentPanel(studentPanel);
      } else if (userRole.equals(UserRole.Professor)) {
        ProfessorPanel professorPanel = (ProfessorPanel) finalJPanel;
        updateProfessorPanel(professorPanel);
      } else if (userRole.equals(UserRole.EduAssistant)) {
        EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) finalJPanel;
        updateEduAssistantPanel(eduAssistantPanel);
      }
    }).start();
  }

  private void changeToStudentEducationalPanel() {
    StudentEducationalOuterPanel studentEducationalOuterPanel = new StudentEducationalOuterPanel(this);
    StudentPanel studentPanel = new StudentPanel(mainFrame, studentEducationalOuterPanel, this);
    mainFrame.setContentPane(studentPanel);

    new Loop(1, () -> {
      Response response = serverController.sendUpdateRequest(PanelName.StudentEducationalOutPanel);
      ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
      ArrayList<String[]> strings = new ArrayList<>();
      for (ArrayList<String> arrayList1 : arrayList) {
        strings.add(arrayList1.toArray(new String[0]));
      }
      studentEducationalOuterPanel.update((int) Double.parseDouble(String.valueOf(response.getData("credit"))),
              Double.parseDouble(String.valueOf(response.getData("averageScore"))),
              ((strings.toArray(new String[0][0]))));

      updateStudentPanel(studentPanel);
    }).start();
  }

  private void changeToStudentTemporaryScoreList() {
    StudentTemporaryScoreList studentTemporaryScoreList = new StudentTemporaryScoreList(mainFrame, this);
    StudentPanel studentPanel = new StudentPanel(mainFrame, studentTemporaryScoreList, this);
    mainFrame.setContentPane(studentPanel);

    Response response = serverController.sendUpdateRequest(PanelName.StudentTemporaryScoreList);
    ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
    ArrayList<String[]> strings = new ArrayList<>();
    for (ArrayList<String> arrayList1 : arrayList) {
      strings.add(arrayList1.toArray(new String[0]));
    }
    studentTemporaryScoreList.update(strings.toArray(new String[0][0]));

    new Loop(1, () -> updateStudentPanel(studentPanel)).start();
  }

  public void addTemporaryScoreByStudent(String courseId, String objection, String answer, String score) {
    Response response = serverController.sendAddTemporaryScoreByStudentRequest(courseId, objection, answer, score);
    if (response.getStatus().equals(ResponseStatus.OK)) {
      changePanel(PanelName.StudentTemporaryScoreList, null);
    }
  }

  public void addTemporaryScoreByProfessor(UserRole userRole, String studentId, String courseId, String objection, String answer, String score) {
    Response response = serverController.sendAddTemporaryScoreByProfessorRequest(studentId, courseId, objection, answer, score);
    if (response.getStatus().equals(ResponseStatus.OK)) {
      changeToProfessorTemporaryScoreList(userRole, courseId);
    }
  }

  public void addScore(UserRole userRole, String courseId, int studentsCount) {
    Response response = serverController.sendAddScoreRequest(courseId, studentsCount);
    mainFrame.showMessage(response.getErrorMessage());
    if (response.getStatus().equals(ResponseStatus.OK)) {
      changePanel(PanelName.ProfessorsCourseList, userRole);
    } else {
      changeToProfessorTemporaryScoreList(userRole, courseId);
    }
  }

  private void changeToWeeklySchedulePanel(UserRole userRole) {
    WeeklySchedulePanel weeklySchedulePanel = new WeeklySchedulePanel(mainFrame, this);
    JPanel jPanel = null;
    if (userRole.equals(UserRole.Student)) {
      jPanel = new StudentPanel(mainFrame, weeklySchedulePanel, this);
    } else if ((userRole.equals(UserRole.Professor))) {
      jPanel = new ProfessorPanel(mainFrame, weeklySchedulePanel, this);
    } else if (userRole.equals(UserRole.EduAssistant)) {
      jPanel = new EduAssistantPanel(mainFrame, weeklySchedulePanel, this);
    }
    mainFrame.setContentPane(jPanel);

    JPanel finalJPanel = jPanel;
    new Loop(1, () -> {
      Response response = serverController.sendUpdateRequest(PanelName.WeeklySchedulePanel);
      ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
      ArrayList<String[]> strings = new ArrayList<>();
      for (ArrayList<String> arrayList1 : arrayList) {
        strings.add(arrayList1.toArray(new String[0]));
      }
      weeklySchedulePanel.update(strings.toArray(new String[0][0]));

      if (userRole.equals(UserRole.Student)) {
        StudentPanel studentPanel = (StudentPanel) finalJPanel;
        updateStudentPanel(studentPanel);
      } else if (userRole.equals(UserRole.Professor)) {
        ProfessorPanel professorPanel = (ProfessorPanel) finalJPanel;
        updateProfessorPanel(professorPanel);
      } else if (userRole.equals(UserRole.EduAssistant)) {
        EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) finalJPanel;
        updateEduAssistantPanel(eduAssistantPanel);
      }
    }).start();
  }

  private void changeToExamListPanel(UserRole userRole) {
    ExamListPanel examListPanel = new ExamListPanel(mainFrame, this);
    JPanel jPanel = null;
    if (userRole.equals(UserRole.Student)) {
      jPanel = new StudentPanel(mainFrame, examListPanel, this);
    } else if ((userRole.equals(UserRole.Professor))) {
      jPanel = new ProfessorPanel(mainFrame, examListPanel, this);
    } else if (userRole.equals(UserRole.EduAssistant)) {
      jPanel = new EduAssistantPanel(mainFrame, examListPanel, this);
    }
    mainFrame.setContentPane(jPanel);

    JPanel finalJPanel = jPanel;
    new Loop(1, () -> {
      Response response = serverController.sendUpdateRequest(PanelName.ExamListPanel);
      ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
      ArrayList<String[]> strings = new ArrayList<>();
      for (ArrayList<String> arrayList1 : arrayList) {
        strings.add(arrayList1.toArray(new String[0]));
      }
      examListPanel.update(strings.toArray(new String[0][0]));

      if (userRole.equals(UserRole.Student)) {
        StudentPanel studentPanel = (StudentPanel) finalJPanel;
        updateStudentPanel(studentPanel);
      } else if (userRole.equals(UserRole.Professor)) {
        ProfessorPanel professorPanel = (ProfessorPanel) finalJPanel;
        updateProfessorPanel(professorPanel);
      } else if (userRole.equals(UserRole.EduAssistant)) {
        EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) finalJPanel;
        updateEduAssistantPanel(eduAssistantPanel);
      }
    }).start();
  }

  private void changeToRecommendationRequestPanel() {
    Response response = serverController.sendUpdateRequest(PanelName.RecommendationRequestPanel);
    if (!response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      return;
    }
    RecommendationRequestPanel recommendationRequestPanel = new RecommendationRequestPanel(mainFrame, this);
    StudentPanel studentPanel = new StudentPanel(mainFrame, recommendationRequestPanel, this);
    mainFrame.setContentPane(studentPanel);

    new Loop(1, () -> updateStudentPanel(studentPanel)).start();
  }

  public void getRecommendationResult(RecommendationRequestPanel recommendationRequestPanel, String professorId) {
    Response response = serverController.sendGetRecommendationResultRequest(professorId);

    if (response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      recommendationRequestPanel.update((String) response.getData("result"));
    } else {
      mainFrame.showMessage(response.getErrorMessage());
    }
  }

  private void changeToEnrollmentCertificatePanel() {
    EnrollmentCertificatePanel enrollmentCertificatePanel = new EnrollmentCertificatePanel(this);
    StudentPanel studentPanel = new StudentPanel(mainFrame, enrollmentCertificatePanel, this);
    mainFrame.setContentPane(studentPanel);

    new Loop(1, () -> updateStudentPanel(studentPanel)).start();
  }

  public void enrollmentCertificate(EnrollmentCertificatePanel enrollmentCertificatePanel) {
    Response response = serverController.sendEnrollmentCertificationRequest();
    if (response.getStatus().equals(ResponseStatus.OK)) {
      enrollmentCertificatePanel.update((String) response.getData("certification"));
    }
  }

  private void changeToMinorRequestPanel() {
    Response response = serverController.sendUpdateRequest(PanelName.MinorRequestPanel);
    if (!response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      return;
    }
    MinorRequestPanel minorRequestPanel = new MinorRequestPanel(mainFrame, this);
    StudentPanel studentPanel = new StudentPanel(mainFrame, minorRequestPanel, this);
    mainFrame.setContentPane(studentPanel);

    minorRequestPanel.update((String) response.getData("result"), (String) response.getData("targetFaculty"),
            ((ArrayList<String>) response.getData("faculties")).toArray(new String[0]));

    new Loop(1, () -> updateStudentPanel(studentPanel)).start();
  }

  public void requestMinor(MinorRequestPanel minorRequestPanel, String faculty) {
    Response response = serverController.sendMinorRequest(faculty);
    if (response.getStatus().equals(ResponseStatus.OK)) {
      minorRequestPanel.update((String) response.getData("result"), (String) response.getData("targetFaculty"),
              ((ArrayList<String>) response.getData("faculties")).toArray(new String[0]));
    }
    mainFrame.showMessage(response.getErrorMessage());
  }

  private void changeToDropoutRequestPanel() {
    DropoutRequestPanel dropoutRequestPanel = new DropoutRequestPanel(mainFrame, this);
    StudentPanel studentPanel = new StudentPanel(mainFrame, dropoutRequestPanel, this);
    mainFrame.setContentPane(studentPanel);

    new Loop(1, () -> {
      Response response = serverController.sendUpdateRequest(PanelName.DropoutRequestPanel);
      dropoutRequestPanel.update((String) response.getData("result"));

      updateStudentPanel(studentPanel);
    }).start();
  }

  public void dropoutRequest(DropoutRequestPanel dropoutRequestPanel) {
    Response response = serverController.sendDropoutRequest();
    if (response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      dropoutRequestPanel.update((String) response.getData("result"));
    }
  }

  private void changeToDormitoryRequestPanel() {
    Response response = serverController.sendUpdateRequest(PanelName.DormitoryRequestPanel);
    if (!response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      return;
    }
    DormitoryRequestPanel dormitoryRequestPanel = new DormitoryRequestPanel(mainFrame, this);
    StudentPanel studentPanel = new StudentPanel(mainFrame, dormitoryRequestPanel, this);
    mainFrame.setContentPane(studentPanel);

    dormitoryRequestPanel.update((String) response.getData("result"));

    new Loop(1, () -> updateStudentPanel(studentPanel)).start();
  }

  public void dormitoryRequest(DormitoryRequestPanel dormitoryRequestPanel) {
    Response response = serverController.sendDormitoryRequest();
    if (response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      dormitoryRequestPanel.update((String) response.getData("result"));
    }
  }

  private void changeToDefendingRequestPanel() {
    Response response = serverController.sendUpdateRequest(PanelName.DefendingRequestPanel);
    if (!response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      return;
    }
    DefendingRequestPanel defendingRequestPanel = new DefendingRequestPanel(mainFrame, this);
    StudentPanel studentPanel = new StudentPanel(mainFrame, defendingRequestPanel, this);
    mainFrame.setContentPane(studentPanel);

    defendingRequestPanel.update((String) response.getData("result"));

    new Loop(1, () -> updateStudentPanel(studentPanel)).start();
  }

  public void defendingRequest(DefendingRequestPanel defendingRequestPanel) {
    Response response = serverController.sendDefendingRequest();
    if (response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      defendingRequestPanel.update((String) response.getData("result"));
    }
  }

  private void changeToProfessorsCourseList(UserRole userRole) {
    ProfessorsCourseList professorsCourseList = new ProfessorsCourseList(mainFrame, this, userRole);
    JPanel jPanel = null;
    if ((userRole.equals(UserRole.Professor))) {
      jPanel = new ProfessorPanel(mainFrame, professorsCourseList, this);
    } else if (userRole.equals(UserRole.EduAssistant)) {
      jPanel = new EduAssistantPanel(mainFrame, professorsCourseList, this);
    }
    mainFrame.setContentPane(jPanel);

    Response response = serverController.sendUpdateRequest(PanelName.ProfessorsCourseList);
    ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
    ArrayList<String[]> strings = new ArrayList<>();
    for (ArrayList<String> arrayList1 : arrayList) {
      strings.add(arrayList1.toArray(new String[0]));
    }
    professorsCourseList.update(strings.toArray(new String[0][0]));

    JPanel finalJPanel = jPanel;
    new Loop(1, () -> {
      if (userRole.equals(UserRole.Professor)) {
        ProfessorPanel professorPanel = (ProfessorPanel) finalJPanel;
        updateProfessorPanel(professorPanel);
      } else if (userRole.equals(UserRole.EduAssistant)) {
        EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) finalJPanel;
        updateEduAssistantPanel(eduAssistantPanel);
      }
    }).start();
  }

  public void changeToProfessorTemporaryScoreList(UserRole userRole, String courseId) {
    Request request = new Request(RequestType.UPDATE);
    request.addData("courseId", courseId);
    Response response = serverController.sendUpdateRequest(PanelName.ProfessorTemporaryScoreList, request);

    ProfessorTemporaryScoreList professorTemporaryScoreList = new ProfessorTemporaryScoreList(mainFrame, this, userRole);
    ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
    ArrayList<String[]> strings = new ArrayList<>();
    for (ArrayList<String> arrayList1 : arrayList) {
      strings.add(arrayList1.toArray(new String[0]));
    }
    professorTemporaryScoreList.update(strings.toArray(new String[0][0]), (String) response.getData("courseName"),
            (String) response.getData("courseId"), (String) response.getData("faculty"),
            (String) response.getData("credit"), (String) response.getData("grade"));

    JPanel jPanel = null;
    if ((userRole.equals(UserRole.Professor))) {
      jPanel = new ProfessorPanel(mainFrame, professorTemporaryScoreList, this);
    } else if (userRole.equals(UserRole.EduAssistant)) {
      jPanel = new EduAssistantPanel(mainFrame, professorTemporaryScoreList, this);
    }
    mainFrame.setContentPane(jPanel);

    JPanel finalJPanel = jPanel;
    new Loop(1, () -> {
      if (userRole.equals(UserRole.Professor)) {
        ProfessorPanel professorPanel = (ProfessorPanel) finalJPanel;
        updateProfessorPanel(professorPanel);
      } else if (userRole.equals(UserRole.EduAssistant)) {
        EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) finalJPanel;
        updateEduAssistantPanel(eduAssistantPanel);
      }
    }).start();
  }

  private void changeToRecommendationListPanel(UserRole userRole) {
    RecommendationListPanel recommendationListPanel = new RecommendationListPanel(mainFrame, this, userRole);
    JPanel jPanel = null;
    if ((userRole.equals(UserRole.Professor))) {
      jPanel = new ProfessorPanel(mainFrame, recommendationListPanel, this);
    } else if (userRole.equals(UserRole.EduAssistant)) {
      jPanel = new EduAssistantPanel(mainFrame, recommendationListPanel, this);
    }
    mainFrame.setContentPane(jPanel);

    JPanel finalJPanel = jPanel;
    new Loop(1, () -> {
      Response response = serverController.sendUpdateRequest(PanelName.RecommendationListPanel);
      ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
      ArrayList<String[]> strings = new ArrayList<>();
      for (ArrayList<String> arrayList1 : arrayList) {
        strings.add(arrayList1.toArray(new String[0]));
      }
      recommendationListPanel.update(strings.toArray(new String[0][0]));

      if (userRole.equals(UserRole.Professor)) {
        ProfessorPanel professorPanel = (ProfessorPanel) finalJPanel;
        updateProfessorPanel(professorPanel);
      } else if (userRole.equals(UserRole.EduAssistant)) {
        EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) finalJPanel;
        updateEduAssistantPanel(eduAssistantPanel);
      }
    }).start();
  }

  private void changeToAnswerRecommendationPanel(UserRole userRole) {
    AnswerRecommendationPanel answerRecommendationPanel = new AnswerRecommendationPanel(mainFrame, this, userRole);
    JPanel jPanel = null;
    if ((userRole.equals(UserRole.Professor))) {
      jPanel = new ProfessorPanel(mainFrame, answerRecommendationPanel, this);
    } else if (userRole.equals(UserRole.EduAssistant)) {
      jPanel = new EduAssistantPanel(mainFrame, answerRecommendationPanel, this);
    }
    mainFrame.setContentPane(jPanel);

    JPanel finalJPanel = jPanel;
    new Loop(1, () -> {
      if (userRole.equals(UserRole.Professor)) {
        ProfessorPanel professorPanel = (ProfessorPanel) finalJPanel;
        updateProfessorPanel(professorPanel);
      } else if (userRole.equals(UserRole.EduAssistant)) {
        EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) finalJPanel;
        updateEduAssistantPanel(eduAssistantPanel);
      }
    }).start();
  }

  public void answerRecommendation(String requestId, boolean accepted) {
    Response response = serverController.sendAnswerRecommendationRequest(requestId, accepted);
    mainFrame.showMessage(response.getErrorMessage());
  }

  private void changeToRemoveProfessorPanel() {
    RemoveProfessorPanel removeProfessorPanel = new RemoveProfessorPanel(mainFrame, this);
    ProfessorPanel professorPanel = new ProfessorPanel(mainFrame, removeProfessorPanel, this);
    mainFrame.setContentPane(professorPanel);

    new Loop(1, () -> updateProfessorPanel(professorPanel)).start();
  }

  public void removeProfessor(String professorId) {
    Response response = serverController.sendRemoveProfessorRequest(professorId);
    mainFrame.showMessage(response.getErrorMessage());
  }

  private void changeToAddProfessorDeanPanel() {
    AddProfessorDeanPanel addProfessorDeanPanel = new AddProfessorDeanPanel(mainFrame, this);
    ProfessorPanel professorPanel = new ProfessorPanel(mainFrame, addProfessorDeanPanel, this);
    mainFrame.setContentPane(professorPanel);

    Response response = serverController.sendUpdateRequest(PanelName.AddProfessorDeanPanel);
    addProfessorDeanPanel.update(((ArrayList<String>) response.getData("positions")).toArray(new String[0]));

    new Loop(1, () -> updateProfessorPanel(professorPanel)).start();
  }

  public void addProfessor(UserRole userRole, String name, String email, String melliCode, String phoneNumber, String password,
                           String roomNumber, String degree, String position) {
    Response response = serverController.sendAddProfessorRequest(name, email, melliCode, phoneNumber,
            password, roomNumber, degree, position);
    mainFrame.showMessage(response.getErrorMessage());
    if (userRole.equals(UserRole.Dean)) {
      changePanel(PanelName.AddProfessorDeanPanel, null);
    } else if (userRole.equals(UserRole.EduAssistant)) {
      changePanel(PanelName.AddProfessorPanel, null);
    }
  }

  private void changeToChangeProfessorPanel() {
    ChangeProfessorPanel changeProfessorPanel = new ChangeProfessorPanel(mainFrame, this);
    ProfessorPanel professorPanel = new ProfessorPanel(mainFrame, changeProfessorPanel, this);
    mainFrame.setContentPane(professorPanel);

    new Loop(1, () -> updateProfessorPanel(professorPanel)).start();
  }

  public void findProfessorForChange(ChangeProfessorPanel changeProfessorPanel, String professorId) {
    Request request = new Request(RequestType.UPDATE);
    request.addData("professorId", professorId);
    Response response = serverController.sendUpdateRequest(PanelName.ChangeProfessorPanel, request);
    if (!response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      changePanel(PanelName.ChangeProfessorPanel, null);
      return;
    }
    changeProfessorPanel.update((String) response.getData("id"), (String) response.getData("name"),
            (String) response.getData("melliCode"), (String) response.getData("email"),
            (String) response.getData("phoneNumber"), (String) response.getData("roomNumber"),
            ((ArrayList<String>) response.getData("degrees")).toArray(new String[0]),
            ((ArrayList<String>) response.getData("positions")).toArray(new String[0]));
  }

  public void changeProfessor(String professorId, String name, String email, String melliCode, String phoneNumber,
                              String password, String roomNumber, String degree, String position) {
    Response response = serverController.sendChangeProfessorRequest(professorId, name, email,
            melliCode, phoneNumber, password, roomNumber, degree, position);

    mainFrame.showMessage(response.getErrorMessage());
    changePanel(PanelName.ChangeProfessorPanel, null);
  }

  public void changeToCoursesListEduPanel(String faculty, String professor, String grade) {
    CoursesListEduPanel coursesListEduPanel = new CoursesListEduPanel(mainFrame, this);
    EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, coursesListEduPanel, this);
    mainFrame.setContentPane(eduAssistantPanel);

    Request request = new Request(RequestType.UPDATE);
    request.addData("faculty", faculty);
    request.addData("professor", professor);
    request.addData("grade", grade);
    Response response = serverController.sendUpdateRequest(PanelName.CoursesListEduPanel, request);

    ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("data");
    ArrayList<String[]> strings = new ArrayList<>();
    for (ArrayList<String> arrayList1 : arrayList) {
      strings.add(arrayList1.toArray(new String[0]));
    }
    coursesListEduPanel.update((((ArrayList<String>) response.getData("faculties")).toArray(new String[0])),
            ((strings.toArray(new String[0][0]))));

    new Loop(1, () -> updateEduAssistantPanel(eduAssistantPanel)).start();
  }

  private void changeToAddCoursePanel() {
    AddCoursePanel addCoursePanel = new AddCoursePanel(mainFrame, this);
    EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, addCoursePanel, this);
    mainFrame.setContentPane(eduAssistantPanel);

    new Loop(1, () -> updateEduAssistantPanel(eduAssistantPanel)).start();
  }

  public void addCourse(String name, String grade, String credit, String examTime, String classTime, String professorId) {
    Response response = serverController.sendAddCourseRequest(name, grade, credit, examTime, classTime, professorId);
    System.out.println(response);
    mainFrame.showMessage(response.getErrorMessage());
    if (response.getStatus().equals(ResponseStatus.OK)) {
      changePanel(PanelName.AddCoursePanel, null);
    }
  }

  private void changeToRemoveCoursePanel() {
    RemoveCoursePanel removeCoursePanel = new RemoveCoursePanel(mainFrame, this);
    EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, removeCoursePanel, this);
    mainFrame.setContentPane(eduAssistantPanel);

    new Loop(1, () -> updateEduAssistantPanel(eduAssistantPanel)).start();
  }

  public void removeCourse(String courseId) {
    Response response = serverController.sendRemoveCourseRequest(courseId);
    mainFrame.showMessage(response.getErrorMessage());
  }

  private void changeToChangeCoursePanel() {
    ChangeCoursePanel changeCoursePanel = new ChangeCoursePanel(mainFrame, this);
    EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, changeCoursePanel, this);
    mainFrame.setContentPane(eduAssistantPanel);

    new Loop(1, () -> updateEduAssistantPanel(eduAssistantPanel)).start();
  }

  public void findCourseForChange(ChangeCoursePanel changeCoursePanel, String courseId) {
    Request request = new Request(RequestType.UPDATE);
    request.addData("courseId", courseId);
    Response response = serverController.sendUpdateRequest(PanelName.ChangeCoursePanel, request);
    if (!response.getStatus().equals(ResponseStatus.OK)) {
      mainFrame.showMessage(response.getErrorMessage());
      changePanel(PanelName.ChangeCoursePanel, null);
      return;
    }
    changeCoursePanel.update((String) response.getData("id"), (String) response.getData("name"),
            (String) response.getData("professorId"), (String) response.getData("credit"),
            (String) response.getData("classTime"), (String) response.getData("examYear"),
            (String) response.getData("examMonth"), (String) response.getData("examDay"),
            (String) response.getData("examHour"), (String) response.getData("examMinute"),
            ((ArrayList<String>) response.getData("grades")).toArray(new String[0]));
  }

  public void changeCourse(String courseId, String name, String professorId, String credit, String classTime, String examDate, String grade) {
    Response response = serverController.sendChangeCourseRequest(courseId, name, professorId,
            credit, classTime, examDate, grade);

    mainFrame.showMessage(response.getErrorMessage());
    changePanel(PanelName.ChangeCoursePanel, null);
  }

  private void changeToAddStudentOrProfessorPanel() {
    AddStudentOrProfessorPanel addStudentOrProfessorPanel = new AddStudentOrProfessorPanel(mainFrame, this);
    EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, addStudentOrProfessorPanel, this);
    mainFrame.setContentPane(eduAssistantPanel);

    new Loop(1, () -> updateEduAssistantPanel(eduAssistantPanel)).start();
  }

  private void changeToAddProfessorPanel() {
    AddProfessorPanel addProfessorPanel = new AddProfessorPanel(mainFrame, this);
    EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, addProfessorPanel, this);
    mainFrame.setContentPane(eduAssistantPanel);

    new Loop(1, () -> updateEduAssistantPanel(eduAssistantPanel)).start();
  }
}