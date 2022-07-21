package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import shared.model.LogIn;
import shared.model.PanelName;
import shared.model.Time;
import shared.model.University;
import shared.model.users.Professor;
import shared.model.users.Student;
import shared.model.users.User;
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
  private final int id;
  private final PrintStream printStream;
  private final String authToken;
  private final GsonBuilder gsonBuilder = new GsonBuilder();
  private final Gson gson;

  private User user;

  public ClientHandler(Server server, Socket socket, int id) throws IOException {
    this.server = server;
    this.socket = socket;
    this.id = id;
    printStream = new PrintStream(socket.getOutputStream());
    authToken = String.valueOf(new SecureRandom().nextInt());

    gson = gsonBuilder.create();
  }

  @Override
  public void run() {
    try {
      Scanner scanner = new Scanner(socket.getInputStream());
      while (true) {
        Request request = gson.fromJson(scanner.nextLine(), Request.class);
        handleRequest(request);
      }
    } catch (IOException ignore) {}
  }

  private void handleRequest(Request request) {
    switch (request.getRequestType()) {
      case LOGIN:
        handleLogin(request);
        break;
      case UPDATE:
        handleUpdate(request);
        break;
    }
  }

  private void handleUpdate(Request request) {
    PanelName panelName = Enum.valueOf(PanelName.class, (String) request.getData("panelName"));

    Response response = new Response(ResponseStatus.OK);
    switch (panelName) {
      case StudentPanel:
        response.addData("lastLogin", user.getLastLogIn());
        response.addData("email", user.getEmail());
        response.addData("name", user.getName());
        response.addData("currentTime", Time.getCurrentTime());
        break;
      case StudentMainPanel:
        Student student = (Student) user;
        response.addData("educationalStatus", student.getStatus());
        response.addData("supervisor", University.getInstance().findProfessorById(Integer.parseInt(student.getSupervisorId())).getName());
        break;
    }
    sendResponse(response);
  }

  private void handleLogin(Request request) {
    User user = LogIn.checkUser((int) Double.parseDouble(String.valueOf(request.getData("id"))), (String) request.getData("password"));

    Response response;

    if (user == null) {
      response = new Response(ResponseStatus.ERROR);
      response.setErrorMessage("wrong id or password input");
    } else {
      this.user = user;
      response = new Response(ResponseStatus.OK);
      response.addData("id", user.getId());

      PanelName panelName = null;
      if (user instanceof Student) {
        panelName = PanelName.StudentPanel;
      } else if (user instanceof Professor) {
        Professor professor = (Professor) user;
        if (professor.getPosition().equals(Professor.Position.eduAssistant)) {
          panelName = PanelName.EduAssistantPanel;
        } else {
          panelName = PanelName.ProfessorPanel;
        }
      }
      response.addData("panelName", panelName);
    }

    sendResponse(response);
  }

  public void sendResponse(Response response) {
    String responseString = gson.toJson(response);
    printStream.println(responseString);
    printStream.flush();
  }
}
