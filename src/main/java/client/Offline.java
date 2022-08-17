package client;

import client.GUI.ExamListPanel;
import client.GUI.MainFrame;
import client.GUI.WeeklySchedulePanel;
import client.GUI.admin.AdminPanel;
import client.GUI.messenger.MessengerPanel;
import client.GUI.mrMohseni.MrMohseniPanel;
import client.GUI.professors.ProfessorPanel;
import client.GUI.professors.ProfessorProfilePanel;
import client.GUI.professors.eduAssistant.EduAssistantPanel;
import client.GUI.student.StudentEducationalOuterPanel;
import client.GUI.student.StudentMainPanel;
import client.GUI.student.StudentPanel;
import client.GUI.student.StudentProfilePanel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import shared.model.PanelName;
import shared.model.message.Chat;
import shared.model.users.UserRole;
import shared.response.Response;
import shared.util.Config;
import shared.util.Loop;
import shared.util.Time;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Offline {
  private static Offline instance;
  private static Client client;
  private static MainFrame mainFrame;
  private Response response;

  public void start() {
    client.setConnected(false);
    Loop.stopCurrent();
    Loop.stopOffline();

    mainFrame.showMessage(getConfig().getProperty(String.class, "offlineMode"));
    if (response == null || response.getData("userRole") == null) {
      client.loginCLI();
    } else {
      client.mainPanelCLI((String) response.getData("userRole"));
    }
  }

  public void finish() {
    client.setConnected(true);
    mainFrame.showMessage(getConfig().getProperty(String.class, "onlineMode"));
    if (response == null || response.getData("userRole") == null) {
      client.loginCLI();
    } else {
      client.setUser((String) response.getData("id"));
      client.mainPanelCLI((String) response.getData("userRole"));
      sendAdminMessage();
    }
  }

  public void setClient(Client client) {
    Offline.client = client;
  }

  public void setMainFrame(MainFrame mainFrame) {
    Offline.mainFrame = mainFrame;
  }

  public void update(Response response) {
    this.response = response;
  }

  public void changePanel(PanelName panelName, UserRole userRole) {
    switch (panelName) {
      case STUDENT_MAIN_PANEL:
        changeToStudentMainPanel();
        break;
      case PROFESSOR_PANEL:
        changeToProfessorPanel();
        break;
      case EDU_ASSISTANT_PANEL:
        changeToEduAssistantPanel();
        break;
      case ADMIN_PANEL:
        changeToAdminPanel();
        break;
      case MR_MOHSENI_PANEL:
        changeToMrMohseniPanel();
        break;
      case STUDENT_PROFILE_PANEL:
        changeToStudentProfilePanel();
        break;
      case PROFESSOR_PROFILE_PANEL:
        changeToProfessorProfilePanel(userRole);
        break;
      case STUDENT_EDUCATIONAL_OUT_PANEL:
        changeToStudentEducationalPanel();
        break;
      case WEEKLY_SCHEDULE_PANEL:
        changeToWeeklySchedulePanel(userRole);
        break;
      case EXAM_LIST_PANEL:
        changeToExamListPanel(userRole);
        break;
      case MESSENGER_PANEL:
        changeToMessengerPanel(userRole, "0");
        break;
      default:
        mainFrame.showMessage(getConfig().getProperty(String.class, "offlineAccessErrorMessage"));
    }
  }

  private void updateStudentPanel(StudentPanel studentPanel) {
    new Loop(getConfig().getProperty(Double.class, "updateLoopTime"), () ->
            studentPanel.update(String.valueOf(response.getData("id")),
                    (String) response.getData("lastLogin"), (String) response.getData("email"),
                    (String) response.getData("name"), Time.getCurrentTime())
    ).start();
  }

  private void updateProfessorPanel(ProfessorPanel professorPanel) {
    new Loop(getConfig().getProperty(Double.class, "updateLoopTime"), () ->
            professorPanel.update(String.valueOf(response.getData("id")),
                    (String) response.getData("lastLogin"), (String) response.getData("email"),
                    (String) response.getData("name"), Time.getCurrentTime())
    ).start();
  }

  private void updateEduAssistantPanel(EduAssistantPanel eduAssistantPanel) {
    new Loop(getConfig().getProperty(Double.class, "updateLoopTime"), () ->
            eduAssistantPanel.update(String.valueOf(response.getData("id")),
                    (String) response.getData("lastLogin"), (String) response.getData("email"),
                    (String) response.getData("name"), Time.getCurrentTime())
    ).start();
  }

  private void updateAdminPanel(AdminPanel adminPanel) {
    new Loop(getConfig().getProperty(Double.class, "updateLoopTime"), () ->
            adminPanel.update(String.valueOf(response.getData("id")),
                    (String) response.getData("lastLogin"), (String) response.getData("email"),
                    (String) response.getData("name"), Time.getCurrentTime())
    ).start();
  }

  private void updateMrMohseniPanel(MrMohseniPanel mrMohseniPanel) {
    new Loop(getConfig().getProperty(Double.class, "updateLoopTime"), () ->
            mrMohseniPanel.update(String.valueOf(response.getData("id")),
                    (String) response.getData("lastLogin"), (String) response.getData("email"),
                    (String) response.getData("name"), Time.getCurrentTime())
    ).start();
  }

  private void changeToStudentMainPanel() {
    StudentMainPanel studentMainPanel = new StudentMainPanel();
    StudentPanel studentPanel = new StudentPanel(mainFrame, studentMainPanel, client);
    mainFrame.setContentPane(studentPanel);

    studentMainPanel.update((String) response.getData("educationalStatus"),
            (String) response.getData("supervisor"));
    updateStudentPanel(studentPanel);
  }

  private void changeToProfessorPanel() {
    ProfessorPanel professorPanel = new ProfessorPanel(mainFrame, new JPanel(), client);
    mainFrame.setContentPane(professorPanel);
    updateProfessorPanel(professorPanel);
  }

  private void changeToEduAssistantPanel() {
    EduAssistantPanel eduAssistantPanel = new EduAssistantPanel(mainFrame, new JPanel(), client);
    mainFrame.setContentPane(eduAssistantPanel);
    updateEduAssistantPanel(eduAssistantPanel);
  }

  private void changeToAdminPanel() {
    AdminPanel adminPanel = new AdminPanel(mainFrame, new JPanel(), client);
    mainFrame.setContentPane(adminPanel);
    updateAdminPanel(adminPanel);
  }

  private void changeToMrMohseniPanel() {
    MrMohseniPanel mrMohseniPanel = new MrMohseniPanel(mainFrame, new JPanel(), client);
    mainFrame.setContentPane(mrMohseniPanel);
    updateMrMohseniPanel(mrMohseniPanel);
  }

  private void changeToStudentProfilePanel() {
    StudentProfilePanel studentProfilePanel = new StudentProfilePanel(mainFrame, client);
    StudentPanel studentPanel = new StudentPanel(mainFrame, studentProfilePanel, client);
    mainFrame.setContentPane(studentPanel);

    studentProfilePanel.update(String.valueOf(response.getData("id")),
            (String) response.getData("melliCode"), (String) response.getData("faculty"),
            (String) response.getData("phoneNumber"), (String) response.getData("enteringYear"),
            (String) response.getData("grade"), (String) response.getData("status"),
            (String) response.getData("supervisor"), Double.parseDouble(String.valueOf(response.getData("averageScore"))));

    updateStudentPanel(studentPanel);
  }

  private void changeToProfessorProfilePanel(UserRole userRole) {
    ProfessorProfilePanel professorProfilePanel = new ProfessorProfilePanel(mainFrame, client);
    JPanel jPanel = null;
    if (userRole.equals(UserRole.EDU_ASSISTANT)) {
      jPanel = new EduAssistantPanel(mainFrame, professorProfilePanel, client);
    } else if (userRole.equals(UserRole.PROFESSOR)) {
      jPanel = new ProfessorPanel(mainFrame, professorProfilePanel, client);
    }
    mainFrame.setContentPane(jPanel);

    professorProfilePanel.update(String.valueOf(response.getData("id")),
            (String) response.getData("melliCode"), (String) response.getData("faculty"),
            (String) response.getData("phoneNumber"), (String) response.getData("degree"),
            (String) response.getData("roomNumber"));

    if (userRole.equals(UserRole.EDU_ASSISTANT)) {
      EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) jPanel;
      updateEduAssistantPanel(eduAssistantPanel);
    } else if (userRole.equals(UserRole.PROFESSOR)) {
      ProfessorPanel professorPanel = (ProfessorPanel) jPanel;
      updateProfessorPanel(professorPanel);
    }
  }

  private void changeToStudentEducationalPanel() {
    StudentEducationalOuterPanel studentEducationalOuterPanel = new StudentEducationalOuterPanel(client);
    StudentPanel studentPanel = new StudentPanel(mainFrame, studentEducationalOuterPanel, client);
    mainFrame.setContentPane(studentPanel);

    ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("educationalData");
    ArrayList<String[]> strings = new ArrayList<>();
    for (ArrayList<String> arrayList1 : arrayList) {
      strings.add(arrayList1.toArray(new String[0]));
    }
    studentEducationalOuterPanel.update(String.valueOf(response.getData("credit")),
            String.valueOf(response.getData("averageScore")),
            ((strings.toArray(new String[0][0]))));

    updateStudentPanel(studentPanel);
  }

  private void changeToWeeklySchedulePanel(UserRole userRole) {
    WeeklySchedulePanel weeklySchedulePanel = new WeeklySchedulePanel(mainFrame, client);
    JPanel jPanel = null;
    if (userRole.equals(UserRole.STUDENT)) {
      jPanel = new StudentPanel(mainFrame, weeklySchedulePanel, client);
    } else if ((userRole.equals(UserRole.PROFESSOR))) {
      jPanel = new ProfessorPanel(mainFrame, weeklySchedulePanel, client);
    } else if (userRole.equals(UserRole.EDU_ASSISTANT)) {
      jPanel = new EduAssistantPanel(mainFrame, weeklySchedulePanel, client);
    }
    mainFrame.setContentPane(jPanel);

    ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("weeklyScheduleData");
    ArrayList<String[]> strings = new ArrayList<>();
    for (ArrayList<String> arrayList1 : arrayList) {
      strings.add(arrayList1.toArray(new String[0]));
    }
    weeklySchedulePanel.update(strings.toArray(new String[0][0]));

    if (userRole.equals(UserRole.STUDENT)) {
      StudentPanel studentPanel = (StudentPanel) jPanel;
      updateStudentPanel(studentPanel);
    } else if (userRole.equals(UserRole.PROFESSOR)) {
      ProfessorPanel professorPanel = (ProfessorPanel) jPanel;
      updateProfessorPanel(professorPanel);
    } else if (userRole.equals(UserRole.EDU_ASSISTANT)) {
      EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) jPanel;
      updateEduAssistantPanel(eduAssistantPanel);
    }
  }

  private void changeToExamListPanel(UserRole userRole) {
    ExamListPanel examListPanel = new ExamListPanel(mainFrame, client);
    JPanel jPanel = null;
    if (userRole.equals(UserRole.STUDENT)) {
      jPanel = new StudentPanel(mainFrame, examListPanel, client);
    } else if ((userRole.equals(UserRole.PROFESSOR))) {
      jPanel = new ProfessorPanel(mainFrame, examListPanel, client);
    } else if (userRole.equals(UserRole.EDU_ASSISTANT)) {
      jPanel = new EduAssistantPanel(mainFrame, examListPanel, client);
    }
    mainFrame.setContentPane(jPanel);

    ArrayList<ArrayList<String>> arrayList = (ArrayList<ArrayList<String>>) response.getData("examListData");
    ArrayList<String[]> strings = new ArrayList<>();
    for (ArrayList<String> arrayList1 : arrayList) {
      strings.add(arrayList1.toArray(new String[0]));
    }
    examListPanel.update(strings.toArray(new String[0][0]));

    if (userRole.equals(UserRole.STUDENT)) {
      StudentPanel studentPanel = (StudentPanel) jPanel;
      updateStudentPanel(studentPanel);
    } else if (userRole.equals(UserRole.PROFESSOR)) {
      ProfessorPanel professorPanel = (ProfessorPanel) jPanel;
      updateProfessorPanel(professorPanel);
    } else if (userRole.equals(UserRole.EDU_ASSISTANT)) {
      EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) jPanel;
      updateEduAssistantPanel(eduAssistantPanel);
    }
  }

  public void changeToMessengerPanel(UserRole userRole, String contactId) {
    MessengerPanel messengerPanel = new MessengerPanel(mainFrame, client, userRole);
    JPanel jPanel = null;
    if (userRole.equals(UserRole.STUDENT)) {
      jPanel = new StudentPanel(mainFrame, messengerPanel, client);
    } else if (userRole.equals(UserRole.PROFESSOR)) {
      jPanel = new ProfessorPanel(mainFrame, messengerPanel, client);
    } else if (userRole.equals(UserRole.EDU_ASSISTANT)) {
      jPanel = new EduAssistantPanel(mainFrame, messengerPanel, client);
    } else if (userRole.equals(UserRole.ADMIN)) {
      jPanel = new AdminPanel(mainFrame, messengerPanel, client);
    } else if (userRole.equals(UserRole.MR_MOHSENI)) {
      jPanel = new MrMohseniPanel(mainFrame, messengerPanel, client);
    }
    mainFrame.setContentPane(jPanel);

    ArrayList<Chat> chats = new Gson().fromJson(new Gson().toJson(response.getData("chats")), TypeToken.getParameterized(ArrayList.class, Chat.class).getType());
    Chat chat = null;
    for (Chat c : chats) {
      if (c.getContactId().equals(contactId)) {
        chat = c;
        break;
      }
    }
    messengerPanel.update(chats, chat, 0, 0);

    if (userRole.equals(UserRole.STUDENT)) {
      StudentPanel studentPanel = (StudentPanel) jPanel;
      updateStudentPanel(studentPanel);
    } else if (userRole.equals(UserRole.PROFESSOR)) {
      ProfessorPanel professorPanel = (ProfessorPanel) jPanel;
      updateProfessorPanel(professorPanel);
    } else if (userRole.equals(UserRole.EDU_ASSISTANT)) {
      EduAssistantPanel eduAssistantPanel = (EduAssistantPanel) jPanel;
      updateEduAssistantPanel(eduAssistantPanel);
    } else if (userRole.equals(UserRole.ADMIN)) {
      AdminPanel adminPanel = (AdminPanel) jPanel;
      updateAdminPanel(adminPanel);
    } else if (userRole.equals(UserRole.MR_MOHSENI)) {
      MrMohseniPanel mrMohseniPanel = (MrMohseniPanel) jPanel;
      updateMrMohseniPanel(mrMohseniPanel);
    }
  }

  public void saveAdminMessage(String message) {
    String id = (String) response.getData("id");
    File file = new File(String.format(getConfig().getProperty(String.class, "offlineMessagesFilePath"), id));
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    PrintStream printStream = null;
    try {
      printStream = new PrintStream(new FileOutputStream(file, true));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    if (printStream != null) {
      printStream.println(message);
      printStream.flush();
      printStream.close();
      mainFrame.showMessage(getConfig().getProperty(String.class, "saveOfflineMessagesMessage"));
    }
  }

  public void sendAdminMessage() {
    String id = (String) response.getData("id");
    File file = new File(String.format(getConfig().getProperty(String.class, "offlineMessagesFilePath"), id));
    if (file.exists()) {
      Scanner scanner = null;
      try {
        scanner = new Scanner(file);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      if (scanner != null) {
        while (scanner.hasNext()) {
          client.messengerSendText(scanner.nextLine(), "1");
        }
        scanner.close();
        PrintStream printStream;
        try {
          printStream = new PrintStream(file);
          printStream.print("");
          printStream.flush();
          printStream.close();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "clientConfig"));
  }

  public static Offline getInstance() {
    if (instance == null) {
      instance = new Offline();
    }
    return instance;
  }
}
