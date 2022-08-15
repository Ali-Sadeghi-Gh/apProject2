package client.GUI.student;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.GUI.MainFrame;
import client.Client;
import shared.util.Config;

import java.awt.*;

/**
 * @author HP
 */
public class StudentProfilePanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form profile
   */
  public StudentProfilePanel(MainFrame mainFrame, Client client) {
    this.mainFrame = mainFrame;
    this.client = client;

    setBounds(getConfig().getProperty(Integer.class, "panelX"), getConfig().getProperty(Integer.class, "panelY"),
            getConfig().getProperty(Integer.class, "panelWidth"), getConfig().getProperty(Integer.class, "panelHeight"));
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

    melliCodeLabel = new javax.swing.JLabel();
    phoneChangeLabel = new javax.swing.JLabel();
    phoneChangeField = new javax.swing.JTextField();
    phoneChangeButton = new javax.swing.JButton();
    emailChangeField = new javax.swing.JTextField();
    emailChangeButton = new javax.swing.JButton();
    emailChangeLabel = new javax.swing.JLabel();
    idLabel = new javax.swing.JLabel();
    facultyLabel = new javax.swing.JLabel();
    phoneLabel = new javax.swing.JLabel();
    enteringYearLabel = new javax.swing.JLabel();
    gradeLabel = new javax.swing.JLabel();
    statusLabel = new javax.swing.JLabel();
    supervisorLabel = new javax.swing.JLabel();
    averageScoreLabel = new javax.swing.JLabel();

    melliCodeLabel.setBackground(new java.awt.Color(200, 200, 200));
    melliCodeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    melliCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    melliCodeLabel.setOpaque(true);

    phoneChangeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    phoneChangeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 17)); // NOI18N
    phoneChangeLabel.setText(getConfig().getProperty(String.class, "phoneChangeLabelText"));

    phoneChangeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    phoneChangeButton.setText(getConfig().getProperty(String.class, "phoneChangeButtonText"));
    phoneChangeButton.addActionListener(this::phoneChangeButtonActionPerformed);

    emailChangeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    emailChangeButton.setText(getConfig().getProperty(String.class, "emailChangeButtonText"));
    emailChangeButton.addActionListener(this::emailChangeButtonActionPerformed);

    emailChangeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    emailChangeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    emailChangeLabel.setText(getConfig().getProperty(String.class, "emailChangeLabelText"));

    idLabel.setBackground(new java.awt.Color(200, 200, 200));
    idLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    idLabel.setOpaque(true);

    facultyLabel.setBackground(new java.awt.Color(200, 200, 200));
    facultyLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    facultyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    facultyLabel.setOpaque(true);

    phoneLabel.setBackground(new java.awt.Color(200, 200, 200));
    phoneLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    phoneLabel.setOpaque(true);

    enteringYearLabel.setBackground(new java.awt.Color(200, 200, 200));
    enteringYearLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    enteringYearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    enteringYearLabel.setOpaque(true);

    gradeLabel.setBackground(new java.awt.Color(200, 200, 200));
    gradeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gradeLabel.setOpaque(true);

    statusLabel.setBackground(new java.awt.Color(200, 200, 200));
    statusLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    statusLabel.setOpaque(true);

    supervisorLabel.setBackground(new java.awt.Color(200, 200, 200));
    supervisorLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    supervisorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    supervisorLabel.setOpaque(true);

    averageScoreLabel.setBackground(new java.awt.Color(200, 200, 200));
    averageScoreLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    averageScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    averageScoreLabel.setOpaque(true);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(melliCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(phoneChangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(phoneChangeField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(phoneChangeButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                                            .addComponent(emailChangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(emailChangeField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(enteringYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(supervisorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(averageScoreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emailChangeButton)
                            .addGap(84, 84, 84))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(72, 72, 72)
                                            .addComponent(melliCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(48, 48, 48)
                                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(56, 56, 56)
                                            .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(59, 59, 59)
                                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(59, 59, 59))
                                    .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(supervisorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(48, 48, 48)
                                            .addComponent(enteringYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(44, 44, 44)
                                            .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(55, 55, 55)
                                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(averageScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(phoneChangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneChangeField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneChangeButton)
                                    .addComponent(emailChangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailChangeField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailChangeButton))
                            .addContainerGap(80, Short.MAX_VALUE))
    );
  }// </editor-fold>

  private void phoneChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePhoneNumber(phoneChangeField.getText());
    phoneChangeField.setText("");
  }

  private void emailChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changeEmail(emailChangeField.getText());
    emailChangeField.setText("");
  }

  public void update(String id, String melliCode, String faculty, String phoneNumber, String enteringYear, String grade, String status, String supervisor, double averageScore) {
    idLabel.setText(String.format(getConfig().getProperty(String.class, "idLabelText"), id));
    melliCodeLabel.setText(String.format(getConfig().getProperty(String.class, "melliCodeLabelText"), (melliCode == null || melliCode.equals("")) ? "-" : melliCode));
    facultyLabel.setText(String.format(getConfig().getProperty(String.class, "facultyLabelText"), (faculty == null || faculty.equals("")) ? "-" : faculty));
    phoneLabel.setText(String.format(getConfig().getProperty(String.class, "phoneLabelText"), (phoneNumber == null || phoneNumber.equals("")) ? "-" : phoneNumber));
    enteringYearLabel.setText(String.format(getConfig().getProperty(String.class, "enteringYearLabelText"), (enteringYear == null || enteringYear.equals("")) ? "-" : enteringYear));
    gradeLabel.setText(String.format(getConfig().getProperty(String.class, "gradeLabelText"), grade == null ? "-" : grade));
    statusLabel.setText(String.format(getConfig().getProperty(String.class, "statusLabelText"), status == null ? "-" : status));
    supervisorLabel.setText(String.format(getConfig().getProperty(String.class, "supervisorLabelText"), (supervisor == null || supervisor.equals("")) ? "-" : supervisor));
    averageScoreLabel.setText(String.format(getConfig().getProperty(String.class, "averageScoreLabelText"), averageScore));
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "studentConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JLabel averageScoreLabel;
  private javax.swing.JButton emailChangeButton;
  private javax.swing.JTextField emailChangeField;
  private javax.swing.JLabel emailChangeLabel;
  private javax.swing.JLabel enteringYearLabel;
  private javax.swing.JLabel facultyLabel;
  private javax.swing.JLabel gradeLabel;
  private javax.swing.JLabel idLabel;
  private javax.swing.JLabel melliCodeLabel;
  private javax.swing.JButton phoneChangeButton;
  private javax.swing.JTextField phoneChangeField;
  private javax.swing.JLabel phoneChangeLabel;
  private javax.swing.JLabel phoneLabel;
  private javax.swing.JLabel statusLabel;
  private javax.swing.JLabel supervisorLabel;
  // End of variables declaration
}
