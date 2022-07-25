package GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.*;
import client.Client;
import shared.model.PanelName;
import shared.model.users.UserRole;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 * @author HP
 */
public class EduAssistantPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form EduAssistantPanel
   */
  public EduAssistantPanel(MainFrame mainFrame, JPanel panel, Client client) {
    this.client = client;
    this.add(panel);
    this.mainFrame = mainFrame;
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">
  private void initComponents() {

    educationalServicesButton = new javax.swing.JButton();
    nameLabel = new javax.swing.JLabel();
    registrationMattersPanel = new javax.swing.JPanel();
    coursesListButton = new javax.swing.JButton();
    professorsListButton = new javax.swing.JButton();
    addStudentButton = new javax.swing.JButton();
    mainPageButton = new javax.swing.JButton();
    profileButton = new javax.swing.JButton();
    recordAffairsButton = new javax.swing.JButton();
    timeLabel = new javax.swing.JLabel();
    currentTimeLabel = new javax.swing.JLabel();
    logoutButton = new javax.swing.JButton();
    educationalServicesPanel = new javax.swing.JPanel();
    weeklyScheduleButton = new javax.swing.JButton();
    examListButton = new javax.swing.JButton();
    requestButton = new javax.swing.JButton();
    emailLabel = new javax.swing.JLabel();
    registrationMattersButton = new javax.swing.JButton();
    recordAffairsPanel = new javax.swing.JPanel();
    educationalStatusButton = new javax.swing.JButton();
    temporaryScoreButton = new javax.swing.JButton();
    imgLabel = new javax.swing.JLabel();


    educationalServicesButton.setText("educational services");
    educationalServicesButton.addActionListener(this::educationalServicesButtonActionPerformed);

    nameLabel.setBackground(new java.awt.Color(200, 200, 200));
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
    nameLabel.setOpaque(true);

    registrationMattersPanel.setBackground(new java.awt.Color(100, 100, 240));
    registrationMattersPanel.setVisible(false);

    coursesListButton.setText("list of courses");
    coursesListButton.addActionListener(this::coursesListButtonActionPerformed);

    professorsListButton.setText("list of professors");
    professorsListButton.addActionListener(this::professorsListButtonActionPerformed);

    addStudentButton.setText("add user");
    addStudentButton.addActionListener(this::addStudentButtonActionPerformed);

    javax.swing.GroupLayout registrationMattersPanelLayout = new javax.swing.GroupLayout(registrationMattersPanel);
    registrationMattersPanel.setLayout(registrationMattersPanelLayout);
    registrationMattersPanelLayout.setHorizontalGroup(
            registrationMattersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrationMattersPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(registrationMattersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coursesListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(professorsListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
    );
    registrationMattersPanelLayout.setVerticalGroup(
            registrationMattersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrationMattersPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(coursesListButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(professorsListButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addStudentButton)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    imgLabel.setText("ax");

    mainPageButton.setText("main page");
    mainPageButton.addActionListener(this::mainPageButtonActionPerformed);

    profileButton.setText("profile");
    profileButton.addActionListener(this::profileButtonActionPerformed);

    recordAffairsButton.setText("record affairs");
    recordAffairsButton.addActionListener(this::recordAffairsButtonActionPerformed);

    timeLabel.setBackground(new java.awt.Color(200, 200, 200));
    timeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
    timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    timeLabel.setOpaque(true);

    currentTimeLabel.setBackground(new java.awt.Color(200, 200, 200));
    currentTimeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 17)); // NOI18N
    currentTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    currentTimeLabel.setOpaque(true);

    logoutButton.setText("log out");
    logoutButton.addActionListener(this::logoutButtonActionPerformed);

    educationalServicesPanel.setBackground(new java.awt.Color(100, 100, 240));
    educationalServicesPanel.setVisible(false);

    weeklyScheduleButton.setText("weekly schedule");
    weeklyScheduleButton.addActionListener(this::weeklyScheduleButtonActionPerformed);

    examListButton.setText("list of exams");
    examListButton.addActionListener(this::examListButtonActionPerformed);

    requestButton.setText("requests");
    requestButton.addActionListener(this::requestButtonActionPerformed);

    javax.swing.GroupLayout educationalServicesPanelLayout = new javax.swing.GroupLayout(educationalServicesPanel);
    educationalServicesPanel.setLayout(educationalServicesPanelLayout);
    educationalServicesPanelLayout.setHorizontalGroup(
            educationalServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, educationalServicesPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(educationalServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(requestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(examListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(weeklyScheduleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                            .addContainerGap())
    );
    educationalServicesPanelLayout.setVerticalGroup(
            educationalServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(educationalServicesPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(weeklyScheduleButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(examListButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(requestButton)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    emailLabel.setBackground(new java.awt.Color(200, 200, 200));
    emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    emailLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
    emailLabel.setOpaque(true);

    registrationMattersButton.setText("registration matters");
    registrationMattersButton.addActionListener(this::registrationMattersButtonActionPerformed);

    recordAffairsPanel.setBackground(new java.awt.Color(100, 100, 240));
    recordAffairsPanel.setVisible(false);

    educationalStatusButton.setText("educational status");
    educationalStatusButton.addActionListener(this::educationalStatusButtonActionPerformed);

    temporaryScoreButton.setText("temporary scores");
    temporaryScoreButton.addActionListener(this::temporaryScoreButtonActionPerformed);

    javax.swing.GroupLayout recordAffairsPanelLayout = new javax.swing.GroupLayout(recordAffairsPanel);
    recordAffairsPanel.setLayout(recordAffairsPanelLayout);
    recordAffairsPanelLayout.setHorizontalGroup(
            recordAffairsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recordAffairsPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(recordAffairsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(educationalStatusButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(temporaryScoreButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
    );
    recordAffairsPanelLayout.setVerticalGroup(
            recordAffairsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recordAffairsPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(educationalStatusButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(temporaryScoreButton)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(mainPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registrationMattersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registrationMattersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(educationalServicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(educationalServicesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(recordAffairsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(recordAffairsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)
                            .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(currentTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imgLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mainPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(recordAffairsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registrationMattersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(educationalServicesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(educationalServicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(recordAffairsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registrationMattersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addContainerGap(91, Short.MAX_VALUE)
                                            .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(63, 63, 63))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(40, 40, 40)
                                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(currentTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(611, 611, 611))
    );
  }// </editor-fold>

  private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.logout();
  }

  private void mainPageButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.EduAssistantPanel, null);
  }

  private void registrationMattersButtonActionPerformed(java.awt.event.ActionEvent evt) {
    registrationMattersPanel.setVisible(!registrationMattersPanel.isVisible());
    educationalServicesPanel.setVisible(false);
    recordAffairsPanel.setVisible(false);
  }

  private void educationalServicesButtonActionPerformed(java.awt.event.ActionEvent evt) {
    registrationMattersPanel.setVisible(false);
    educationalServicesPanel.setVisible(!educationalServicesPanel.isVisible());
    recordAffairsPanel.setVisible(false);
  }

  private void recordAffairsButtonActionPerformed(java.awt.event.ActionEvent evt) {
    registrationMattersPanel.setVisible(false);
    educationalServicesPanel.setVisible(false);
    recordAffairsPanel.setVisible(!recordAffairsPanel.isVisible());
  }

  private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.ProfessorProfilePanel, UserRole.EduAssistant);
  }

  private void coursesListButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changeToCoursesListEduPanel("all", "", "all");
  }

  private void professorsListButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changeToProfessorsListPanel(UserRole.EduAssistant, "all", "", "all");
  }

  private void educationalStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {
//    mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new EduEducationalPanel(mainFrame, professor, new JPanel())));
//    mainFrame.repaintFrame();
  }

  public void temporaryScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {
//    mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new EduTemporaryScorePanel(mainFrame, professor)));
//    mainFrame.repaintFrame();
  }

  private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
//    mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new AddStudentOrProfessorPanel(mainFrame, professor)));
//    mainFrame.repaintFrame();
  }

  private void weeklyScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.WeeklySchedulePanel, UserRole.EduAssistant);
  }

  private void examListButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.ExamListPanel, UserRole.EduAssistant);
  }

  private void requestButtonActionPerformed(java.awt.event.ActionEvent evt) {
//    mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new EduRequestPanel(mainFrame, professor)));
//    mainFrame.repaintFrame();
  }

  public void update(int id, String lastLogin, String email, String name, String currentTime) {
    File file = new File("./src/main/resources/pics/" + id + ".png");
    imgLabel.setIcon(new ImageIcon("./src/main/resources/pics/" + (file.exists() ? id : "default") + ".png"));

    nameLabel.setText("name: " + ((name==null || name.equals("")) ? "-" : name));
    timeLabel.setText("last login: " + ((lastLogin==null || lastLogin.equals("")) ? "-" : lastLogin));
    emailLabel.setText("email: " + ((email==null || email.equals("")) ? "-" : email));
    currentTimeLabel.setText("current time: " + currentTime);
  }

  // Variables declaration - do not modify
  private javax.swing.JButton educationalServicesButton;
  private javax.swing.JPanel educationalServicesPanel;
  private javax.swing.JLabel emailLabel;
  private javax.swing.JLabel imgLabel;
  private javax.swing.JButton addStudentButton;
  private javax.swing.JButton requestButton;
  private javax.swing.JButton educationalStatusButton;
  private javax.swing.JButton temporaryScoreButton;
  private javax.swing.JButton coursesListButton;
  private javax.swing.JButton professorsListButton;
  private javax.swing.JButton weeklyScheduleButton;
  private javax.swing.JButton examListButton;
  private javax.swing.JButton logoutButton;
  private javax.swing.JButton mainPageButton;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JButton profileButton;
  private javax.swing.JButton recordAffairsButton;
  private javax.swing.JPanel recordAffairsPanel;
  private javax.swing.JButton registrationMattersButton;
  private javax.swing.JPanel registrationMattersPanel;
  private javax.swing.JLabel timeLabel;
  private javax.swing.JLabel currentTimeLabel;
  // End of variables declaration
}
