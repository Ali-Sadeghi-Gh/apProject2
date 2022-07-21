package client;

import GUI.LogInPanel;
import GUI.MainFrame;
import GUI.professors.ProfessorPanel;
import GUI.professors.eduAssistant.EduAssistantPanel;
import GUI.student.StudentMainPanel;
import GUI.student.StudentPanel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.PanelName;
import shared.response.Response;
import shared.response.ResponseStatus;

import javax.swing.*;

public class Client {
  private MainFrame mainFrame;
  private ServerController serverController;
  private final Gson gson = new GsonBuilder().create();
  private int port;

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
    if (String.valueOf(response.getData("panelName")).equals(PanelName.StudentPanel.toString())) {
      StudentMainPanel studentMainPanel = new StudentMainPanel();
      StudentPanel studentPanel = new StudentPanel(mainFrame, studentMainPanel, this, (int) Double.parseDouble(String.valueOf(response.getData("id"))));
      mainFrame.setContentPane(studentPanel);

      new Loop(1, () -> {
        Response r = serverController.sendUpdateRequest(PanelName.StudentMainPanel);
        studentMainPanel.update((String) r.getData("educationalStatus"),
                (String) r.getData("supervisor"));

        Response r2 = serverController.sendUpdateRequest(PanelName.StudentPanel);
        studentPanel.update((String) r2.getData("lastLogin"), (String) r2.getData("email"),
                (String) r2.getData("name"), (String) r2.getData("currentTime"));
      }).start();

    } else if (String.valueOf(response.getData("panelName")).equals(PanelName.EduAssistantPanel.toString())) {
      EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, new JPanel(), (int) Double.parseDouble(String.valueOf(response.getData("id"))));
      mainFrame.setContentPane(eduAssistantPanel);

      new Loop(1, () -> {
        Response r = serverController.sendUpdateRequest(PanelName.EduAssistantPanel);
        eduAssistantPanel.update((String) r.getData("name"), (String) r.getData("lastLogin"),
                (String) r.getData("email"), (String) r.getData("currentTime"));
      }).start();

    } else if (String.valueOf(response.getData("panelName")).equals(PanelName.ProfessorPanel.toString())) {
      ProfessorPanel professorPanel = new ProfessorPanel(mainFrame, new JPanel(), (int) Double.parseDouble(String.valueOf(response.getData("id"))));
      mainFrame.setContentPane(professorPanel);

      new Loop(1, () -> {
        Response r = serverController.sendUpdateRequest(PanelName.ProfessorPanel);
        professorPanel.update((String) r.getData("name"), (String) r.getData("lastLogin"),
                (String) r.getData("email"), (String) r.getData("currentTime"));
      }).start();
    }
  }
}
