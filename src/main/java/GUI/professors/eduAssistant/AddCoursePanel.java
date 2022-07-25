package GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import client.Client;
import shared.model.Time;
import shared.model.users.Student;

import java.awt.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class AddCoursePanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form AddCoursePanel
   */
  public AddCoursePanel(MainFrame mainFrame, Client client) {
    this.client = client;
    this.mainFrame = mainFrame;
    setBounds(200, 270, 1100, 700);
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

    gradeLabel = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    nameField = new javax.swing.JTextField();
    professorField = new javax.swing.JTextField();
    creditField = new javax.swing.JTextField();
    professorLabel = new javax.swing.JLabel();
    creditLabel = new javax.swing.JLabel();
    addButton = new javax.swing.JButton();
    gradeBox = new javax.swing.JComboBox<>();
    examYearField = new javax.swing.JTextField();
    examDateLabel = new javax.swing.JLabel();
    backButton = new javax.swing.JButton();
    classTimeField = new javax.swing.JTextField();
    classTimeLabel = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    examMonthField = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    examDayField = new javax.swing.JTextField();
    examTimeLabel = new javax.swing.JLabel();
    examHourField = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    examMinuteField = new javax.swing.JTextField();

    gradeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gradeLabel.setText("grade:");

    nameLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setText("name:");

    nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    professorField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    creditField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    professorLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    professorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    professorLabel.setText("professor id:");

    creditLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    creditLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    creditLabel.setText("credit:");

    addButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
    addButton.setText("add");
    addButton.addActionListener(this::addButtonActionPerformed);

    gradeBox.setMaximumRowCount(10);
    gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {Student.Grade.underGraduate.name(), Student.Grade.masters.name(), Student.Grade.phd.name()}));

    examYearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examMonthField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examDayField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examHourField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examMinuteField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    examDateLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    examDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    examDateLabel.setText("exam date:");

    backButton.setText("back");
    backButton.addActionListener(this::backButtonActionPerformed);

    classTimeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    classTimeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    classTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    classTimeLabel.setText("class time");

    jLabel1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    jLabel1.setText("/");

    jLabel2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    jLabel2.setText("/");

    examTimeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    examTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    examTimeLabel.setText("exam time:");

    jLabel3.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    jLabel3.setText(":");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(professorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                            .addComponent(gradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(creditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(creditField, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                            .addComponent(gradeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(professorField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(56, 56, 56)
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
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(169, 169, 169))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(34, 34, 34)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                                            .addGap(82, 82, 82))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(81, 81, 81)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(classTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(classTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(professorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(professorField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(78, 78, 78)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(creditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(creditField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(76, 76, 76))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(examDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(examYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(examMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(examDayField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(75, 75, 75)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(examTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(examHourField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(examMinuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gradeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96))
    );
  }// </editor-fold>

  private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (nameField.getText().equals("")) {
      mainFrame.showMessage("name can't be empty");
      return;
    }
    if (professorField.getText().equals("")) {
      mainFrame.showMessage("professor id can't be empty");
      return;
    }
    if (creditField.getText().equals("")) {
      mainFrame.showMessage("credit can't be empty");
      return;
    }
    if (classTimeField.getText().equals("")) {
      mainFrame.showMessage("class time can't be empty");
      return;
    }
    if (examYearField.getText().equals("")) {
      mainFrame.showMessage("exam year can't be empty");
      return;
    }
    if (examMonthField.getText().equals("")) {
      mainFrame.showMessage("exam month can't be empty");
      return;
    }
    if (examDayField.getText().equals("")) {
      mainFrame.showMessage("exam day can't be empty");
      return;
    }
    if (examHourField.getText().equals("")) {
      mainFrame.showMessage("exam hour can't be empty");
      return;
    }
    if (examMinuteField.getText().equals("")) {
      mainFrame.showMessage("exam minute can't be empty");
      return;
    }

    try {
      Integer.parseInt(professorField.getText());
    } catch (Exception e) {
      mainFrame.showMessage("professor id must be a number");
      return;
    }

    try {
      Integer.parseInt(creditField.getText());
    } catch (Exception e) {
      mainFrame.showMessage("credit must be a number");
      return;
    }
    try {
      Integer.parseInt(examYearField.getText());
      Integer.parseInt(examMonthField.getText());
      Integer.parseInt(examDayField.getText());
    } catch (Exception e) {
      mainFrame.showMessage("exam date must be a number");
      return;
    }
    try {
      Integer.parseInt(examHourField.getText());
      Integer.parseInt(examMinuteField.getText());
    } catch (Exception e) {
      mainFrame.showMessage("exam time must be a number");
      return;
    }
    if (Integer.parseInt(examMonthField.getText())<0 || Integer.parseInt(examMonthField.getText())>12) {
      mainFrame.showMessage("invalid exam month");
      return;
    }
    if (Integer.parseInt(examDayField.getText())<0 || Integer.parseInt(examDayField.getText())>31) {
      mainFrame.showMessage("invalid exam day");
      return;
    }
    if (Integer.parseInt(examHourField.getText())<0 || Integer.parseInt(examHourField.getText())>23) {
      mainFrame.showMessage("invalid exam hour");
      return;
    }
    if (Integer.parseInt(examMinuteField.getText())<0 || Integer.parseInt(examMinuteField.getText())>59) {
      mainFrame.showMessage("invalid exam minute");
      return;
    }
    Date examDate;
    try {
      examDate = Time.convertStringToDateExam(examYearField.getText() + "/" + examMonthField.getText() + "/" +
              examDayField.getText() + " " + examHourField.getText() + ":" + examMinuteField.getText());
    } catch (Exception e) {
      mainFrame.showMessage("invalid exam Date or time");
      return;
    }

    client.addCourse(nameField.getText(), Objects.requireNonNull(gradeBox.getSelectedItem()).toString(),
            creditField.getText(), Time.convertDateToStringExam(examDate), classTimeField.getText(), professorField.getText());
  }

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changeToCoursesListEduPanel("all", "", "all");
  }

  // Variables declaration - do not modify
  private javax.swing.JButton addButton;
  private javax.swing.JButton backButton;
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
  private javax.swing.JComboBox<String> gradeBox;
  private javax.swing.JLabel gradeLabel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField nameField;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField professorField;
  private javax.swing.JLabel professorLabel;
  // End of variables declaration
}
