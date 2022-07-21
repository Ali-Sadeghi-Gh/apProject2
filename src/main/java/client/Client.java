package client;

import GUI.LogInPanel;
import GUI.MainFrame;
import GUI.professors.eduAssistant.EduAssistantPanel;
import GUI.student.StudentMainPanel;
import GUI.student.StudentPanel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.PanelName;
import shared.response.Response;
import shared.response.ResponseStatus;

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
      StudentPanel studentPanel = new StudentPanel(mainFrame, studentMainPanel, (int) Double.parseDouble(String.valueOf(response.getData("id"))));
      mainFrame.setContentPane(studentPanel);

      new Loop(1, () -> {
        Response response1 = serverController.sendUpdateRequest(PanelName.StudentMainPanel);
        studentMainPanel.update((String) response1.getData("educationalStatus"),
                (String) response1.getData("supervisor"));

        Response response2 = serverController.sendUpdateRequest(PanelName.StudentPanel);
        studentPanel.update((String) response2.getData("lastLogin"), (String) response2.getData("email"),
                (String) response2.getData("name"), (String) response2.getData("currentTime"));
      }).start();
    } else if (String.valueOf(response.getData("panelName")).equals(PanelName.EduAssistantPanel.toString())) {

    }
  }
}
