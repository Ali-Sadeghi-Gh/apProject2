package client;

import GUI.*;
import GUI.professors.ProfessorPanel;
import GUI.professors.ProfessorProfilePanel;
import GUI.professors.dean.ProfessorsListDeanPanel;
import GUI.professors.eduAssistant.EduAssistantPanel;
import GUI.student.*;
import shared.model.PanelName;
import shared.model.users.UserRole;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

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
    mainFrame.setContentPane(new LogInPanel(this, mainFrame));
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
    Loop.stopCurrent();
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

    new Loop(1, () -> {
      updateProfessorPanel(professorPanel);
    }).start();
  }

  private void changeToEduAssistantPanel() {
    EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, new JPanel(), this);
    mainFrame.setContentPane(eduAssistantPanel);

    new Loop(1, () -> {
      updateEduAssistantPanel(eduAssistantPanel);
    }).start();
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
    } else if (userRole.equals(UserRole.Professor)){
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
      } else if (userRole.equals(UserRole.Professor)){
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
    coursesListPanel.update((((ArrayList<String>) response.getData("faculties")).toArray(new String[0])),
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
        Response response1 = serverController.sendUpdateRequest(PanelName.ProfessorListDeanPanel, request);

        ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response1.getData("data");
        ArrayList<String[]> strings = new ArrayList<>();
        for (ArrayList<String> arrayList1 : arrayList) {
          strings.add(arrayList1.toArray(new String[0]));
        }
        professorsListDeanPanel.update((((ArrayList<String>) response1.getData("faculties")).toArray(new String[0])),
                ((strings.toArray(new String[0][0]))));

        new Loop(1, () -> {
          updateProfessorPanel(professorPanel);
        }).start();
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
    Response response = serverController.sendUpdateRequest(PanelName.ProfessorListPanel, request);

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

    new Loop(1, () -> {
      updateStudentPanel(studentPanel);
    }).start();
  }

  public void addTemporaryScore(String courseId, String objection, String answer, String score) {
    Response response = serverController.sendAddTemporaryScoreRequest(courseId, objection, answer, score);
    if (response.getStatus().equals(ResponseStatus.OK)) {
      changePanel(PanelName.StudentTemporaryScoreList, null);
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
}
