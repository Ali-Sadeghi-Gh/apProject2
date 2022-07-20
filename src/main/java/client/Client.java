package client;

import GUI.LogInPanel;
import GUI.MainFrame;
import GUI.student.StudentMainPanel;
import GUI.student.StudentPanel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.users.Student;
import shared.model.users.User;
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
    mainFrame.setContentPane(new StudentPanel(mainFrame, null, new StudentMainPanel(null)));
  }
}
