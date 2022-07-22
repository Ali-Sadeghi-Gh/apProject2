package client;

import GUI.LogInPanel;
import GUI.MainFrame;
import GUI.professors.ProfessorPanel;
import GUI.professors.eduAssistant.EduAssistantPanel;
import GUI.student.StudentMainPanel;
import GUI.student.StudentPanel;
import GUI.student.StudentProfilePanel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.PanelName;
import shared.model.users.UserRole;
import shared.response.Response;
import shared.response.ResponseStatus;

import javax.swing.*;

public class Client {
  private final MainFrame mainFrame;
  private ServerController serverController;
  private final int port;

  public Client(int port) {
    this.port = port;
    mainFrame = new MainFrame();
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
      changePanel(PanelName.StudentMainPanel);
    } else if (String.valueOf(response.getData("userRole")).equals(UserRole.EduAssistant.toString())) {
      EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, new JPanel(), this);
      mainFrame.setContentPane(eduAssistantPanel);

      new Loop(1, () -> {
        Response response1 = serverController.sendUpdateRequest(PanelName.EduAssistantPanel);
        eduAssistantPanel.update((int) Double.parseDouble(String.valueOf(response1.getData("id"))),
                (String) response1.getData("name"), (String) response1.getData("lastLogin"),
                (String) response1.getData("email"), (String) response1.getData("currentTime"));
      }).start();

    } else if (String.valueOf(response.getData("userRole")).equals(UserRole.Professor.toString())) {
      ProfessorPanel professorPanel = new ProfessorPanel(mainFrame, new JPanel(), this);
      mainFrame.setContentPane(professorPanel);

      new Loop(1, () -> {
        Response response1 = serverController.sendUpdateRequest(PanelName.ProfessorPanel);
        professorPanel.update((int) Double.parseDouble(String.valueOf(response1.getData("id"))),
                (String) response1.getData("name"), (String) response1.getData("lastLogin"),
                (String) response1.getData("email"), (String) response1.getData("currentTime"));
      }).start();
    }
  }

  public void logout() {
    Loop.stopCurrent();
    loginCLI();
  }

  public void changePanel(PanelName panelName) {
    Loop.stopCurrent();
    switch (panelName) {
      case StudentMainPanel:
        changeToStudentMainPanel();
        break;
      case StudentProfilePanel:
        changeToStudentProfilePanel();
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

      Response response2 = serverController.sendUpdateRequest(PanelName.StudentPanel);
      studentPanel.update((int) Double.parseDouble(String.valueOf(response2.getData("id"))),
              (String) response2.getData("lastLogin"), (String) response2.getData("email"),
              (String) response2.getData("name"), (String) response2.getData("currentTime"));
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

      Response response1 = serverController.sendUpdateRequest(PanelName.StudentPanel);
      studentPanel.update((int) Double.parseDouble(String.valueOf(response1.getData("id"))),
              (String) response1.getData("lastLogin"), (String) response1.getData("email"),
              (String) response1.getData("name"), (String) response1.getData("currentTime"));
    }).start();
  }
}
