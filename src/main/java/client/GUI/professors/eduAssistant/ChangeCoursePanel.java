package client.GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.GUI.MainFrame;
import client.Client;
import shared.model.PanelName;
import shared.util.Config;
import shared.util.Time;

import java.awt.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class ChangeCoursePanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form ChangeCoursePanel
   */
  public ChangeCoursePanel(MainFrame mainFrame, Client client) {
    this.client = client;
    this.mainFrame = mainFrame;
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

    jLabel2 = new javax.swing.JLabel();
    examYearField = new javax.swing.JTextField();
    examDayField = new javax.swing.JTextField();
    gradeLabel = new javax.swing.JLabel();
    examTimeLabel = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    examDateLabel = new javax.swing.JLabel();
    examHourField = new javax.swing.JTextField();
    nameField = new javax.swing.JTextField();
    backButton = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    professorField = new javax.swing.JTextField();
    classTimeField = new javax.swing.JTextField();
    examMinuteField = new javax.swing.JTextField();
    creditField = new javax.swing.JTextField();
    classTimeLabel = new javax.swing.JLabel();
    professorLabel = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    creditLabel = new javax.swing.JLabel();
    changeButton = new javax.swing.JButton();
    examMonthField = new javax.swing.JTextField();
    gradeBox = new javax.swing.JComboBox<>();
    idField = new javax.swing.JTextField();
    idLabel = new javax.swing.JLabel();
    findButton = new javax.swing.JButton();

    jLabel2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    jLabel2.setText("/");

    examYearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examMonthField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examDayField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examHourField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examMinuteField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    gradeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gradeLabel.setText(getConfig().getProperty(String.class, "gradeLabelText1"));

    examTimeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    examTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    examTimeLabel.setText(getConfig().getProperty(String.class, "examTimeLabelText"));

    nameLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setText(getConfig().getProperty(String.class, "nameLabelText3"));

    examDateLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    examDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    examDateLabel.setText(getConfig().getProperty(String.class, "examDateLabelText"));

    nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    backButton.setText(getConfig().getProperty(String.class, "backButtonText"));
    backButton.addActionListener(this::backButtonActionPerformed);

    jLabel3.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    jLabel3.setText(":");

    professorField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    classTimeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    creditField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    classTimeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    classTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    classTimeLabel.setText(getConfig().getProperty(String.class, "classTimeLabelText"));

    professorLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    professorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    professorLabel.setText(getConfig().getProperty(String.class, "professorLabelText2"));

    jLabel1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    jLabel1.setText("/");

    creditLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    creditLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    creditLabel.setText(getConfig().getProperty(String.class, "creditLabelText"));

    changeButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
    changeButton.setText(getConfig().getProperty(String.class, "changeButtonText"));
    changeButton.addActionListener(this::changeButtonActionPerformed);

    gradeBox.setMaximumRowCount(10);
    gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"none"}));

    idField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    idLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    idLabel.setText(getConfig().getProperty(String.class, "idLabelText"));

    findButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    findButton.setText(getConfig().getProperty(String.class, "findButtonText"));
    findButton.addActionListener(this::findButtonActionPerformed);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(214, 214, 214)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(professorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(gradeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(creditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(creditField)
                                    .addComponent(gradeBox, 0, 171, Short.MAX_VALUE)
                                    .addComponent(professorField, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                            .addGap(62, 62, 62)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(classTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(classTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(examDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(examTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addGap(44, 44, 44)
                                                                            .addComponent(examYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(jLabel1)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(examMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(jLabel2)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(examDayField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addGap(53, 53, 53)
                                                                            .addComponent(examHourField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(jLabel3)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(examMinuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGap(127, 127, 127))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(169, 169, 169))))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(444, 444, 444))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(336, 336, 336))))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(classTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(classTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(examDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examDayField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(professorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(professorField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(examTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examHourField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examMinuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(creditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(creditField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(gradeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(96, 96, 96))
    );
  }// </editor-fold>

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changeToCoursesListEduPanel(getConfig().getProperty(String.class, "comboBoxDefault"),
            "", getConfig().getProperty(String.class, "comboBoxDefault"));
  }

  private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      Integer.parseInt(idField.getText());
    } catch (Exception e) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "courseIdNumErrorMessage"));
      client.changePanel(PanelName.CHANGE_COURSE_PANEL, null);
      return;
    }

    client.findCourseForChange(this, idField.getText());
  }

  private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (idField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "chooseCourseErrorMessage"));
      return;
    }
    try {
      Integer.parseInt(idField.getText());
    } catch (Exception e) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "courseIdNumErrorMessage"));
      return;
    }
    if (nameField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "emptyNameErrorMessage"));
      return;
    }
    if (professorField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "emptyProfessorIdErrorMessage"));
      return;
    }
    if (creditField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "emptyCreditErrorMessage"));
      return;
    }
    if (classTimeField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "emptyClassTimeErrorMessage"));
      return;
    }
    if (examYearField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "emptyExamTimeErrorMessage"));
      return;
    }
    if (examMonthField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "emptyExamTimeErrorMessage"));
      return;
    }
    if (examDayField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "emptyExamTimeErrorMessage"));
      return;
    }
    if (examHourField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "emptyExamTimeErrorMessage"));
      return;
    }
    if (examMinuteField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "emptyExamTimeErrorMessage"));
      return;
    }

    try {
      Integer.parseInt(professorField.getText());
    } catch (Exception e) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "professorIdNumErrorMessage"));
      return;
    }
    try {
      Integer.parseInt(creditField.getText());
    } catch (Exception e) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "creditNumErrorMessage"));
      return;
    }
    try {
      Integer.parseInt(examYearField.getText());
      Integer.parseInt(examMonthField.getText());
      Integer.parseInt(examDayField.getText());
      Integer.parseInt(examHourField.getText());
      Integer.parseInt(examMinuteField.getText());
    } catch (Exception e) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "examTimeNumErrorMessage"));
      return;
    }
    if (Integer.parseInt(examMonthField.getText())<0 || Integer.parseInt(examMonthField.getText())>12) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "invalidExamTimeErrorMessage"));
      return;
    }
    if (Integer.parseInt(examDayField.getText())<0 || Integer.parseInt(examDayField.getText())>31) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "invalidExamTimeErrorMessage"));
      return;
    }
    if (Integer.parseInt(examHourField.getText())<0 || Integer.parseInt(examHourField.getText())>23) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "invalidExamTimeErrorMessage"));
      return;
    }
    if (Integer.parseInt(examMinuteField.getText())<0 || Integer.parseInt(examMinuteField.getText())>59) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "invalidExamTimeErrorMessage"));
      return;
    }
    Date examDate;
    try {
      examDate = Time.convertStringToDateExam(examYearField.getText() + "/" + examMonthField.getText() + "/" +
              examDayField.getText() + " " + examHourField.getText() + ":" + examMinuteField.getText());
    } catch (Exception e) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "invalidExamTimeErrorMessage"));
      return;
    }

    client.changeCourse(idField.getText(), nameField.getText(), professorField.getText(), creditField.getText(),
            classTimeField.getText(), Time.convertDateToStringExam(examDate), Objects.requireNonNull(gradeBox.getSelectedItem()).toString());
  }

  public void update(String id, String name, String professorId, String credit, String classTime, String examYear,
                     String examMonth, String examDay, String examHour, String examMinute, String[] grades) {
    idField.setText(id);
    nameField.setText(name);
    professorField.setText(professorId);
    creditField.setText(credit);
    classTimeField.setText(classTime);
    examYearField.setText(examYear);
    examMonthField.setText(examMonth);
    examDayField.setText(examDay);
    examHourField.setText(examHour);
    examMinuteField.setText(examMinute);
    gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(grades));
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "eduAssistantConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JButton backButton;
  private javax.swing.JButton changeButton;
  private javax.swing.JTextField classTimeField;
  private javax.swing.JLabel classTimeLabel;
  private javax.swing.JTextField creditField;
  private javax.swing.JLabel creditLabel;
  private javax.swing.JLabel examDateLabel;
  private javax.swing.JTextField examDayField;
  private javax.swing.JTextField examHourField;
  private javax.swing.JTextField examMinuteField;
  private javax.swing.JTextField examMonthField;
  private javax.swing.JLabel examTimeLabel;
  private javax.swing.JTextField examYearField;
  private javax.swing.JButton findButton;
  private javax.swing.JComboBox<String> gradeBox;
  private javax.swing.JLabel gradeLabel;
  private javax.swing.JLabel idLabel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField nameField;
  private javax.swing.JTextField idField;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField professorField;
  private javax.swing.JLabel professorLabel;
  // End of variables declaration
}