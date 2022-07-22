package GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import LOGIC.Controller;
import shared.model.users.Professor;
import shared.model.users.Student;

import javax.swing.*;

/**
 *
 * @author HP
 */
public class AddStudentPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Professor professor;

  /**
   * Creates new form AddStudentPanel
   */
  public AddStudentPanel(MainFrame mainFrame, Professor professor) {
    this.professor = professor;
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

    nameLabel = new javax.swing.JLabel();
    nameField = new javax.swing.JTextField();
    passwordField = new javax.swing.JTextField();
    passwordLabel = new javax.swing.JLabel();
    melliCodeField = new javax.swing.JTextField();
    melliCodeLabel = new javax.swing.JLabel();
    emailField = new javax.swing.JTextField();
    emailLabel = new javax.swing.JLabel();
    phoneField = new javax.swing.JTextField();
    phoneLabel = new javax.swing.JLabel();
    supervisorField = new javax.swing.JTextField();
    supervisorLabel = new javax.swing.JLabel();
    enteringYearField = new javax.swing.JTextField();
    enteringYearLabel = new javax.swing.JLabel();
    statusLabel = new javax.swing.JLabel();
    statusBox = new javax.swing.JComboBox<>();
    gradeLabel = new javax.swing.JLabel();
    gradeBox = new javax.swing.JComboBox<>();
    addButton = new javax.swing.JButton();
    backButton = new javax.swing.JButton();

    nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setText("name:");

    nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    passwordLabel.setText("password:");

    melliCodeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    melliCodeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    melliCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    melliCodeLabel.setText("code melli:");

    emailField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    emailLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    emailLabel.setText("email:");

    phoneField.setHorizontalAlignment(javax.swing.JTextField.CENTER);


    phoneLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    phoneLabel.setText("phone number:");

    supervisorField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    supervisorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    supervisorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    supervisorLabel.setText("supervisor:");

    enteringYearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    enteringYearLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    enteringYearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    enteringYearLabel.setText("year of entry:");

    statusLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    statusLabel.setText("status:");

    statusBox.setMaximumRowCount(10);
    statusBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {Student.EducationalStatus.studying.name(), Student.EducationalStatus.graduated.name(), Student.EducationalStatus.dropout.name()}));


    gradeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gradeLabel.setText("grade:");

    gradeBox.setMaximumRowCount(10);
    gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {Student.Grade.underGraduate.name(), Student.Grade.masters.name(), Student.Grade.phd.name()}));

    addButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    addButton.setText("add");
    addButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addButtonActionPerformed(evt);
      }
    });

    backButton.setText("back");
    backButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(185, 185, 185)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                            .addGap(333, 333, 333))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGap(58, 58, 58)
                                                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addComponent(melliCodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                                            .addGap(57, 57, 57))
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(melliCodeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(phoneField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGap(129, 129, 129)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(supervisorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(enteringYearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addGap(30, 30, 30)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(enteringYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addComponent(supervisorField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(gradeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(108, 108, 108))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(94, 94, 94)
                                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(supervisorField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(supervisorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(69, 69, 69)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(enteringYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(enteringYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(60, 60, 60)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(melliCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(melliCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(52, 52, 52)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(gradeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(50, 50, 50)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(69, 69, 69))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(83, 83, 83))
    );
  }// </editor-fold>

  private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (nameField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "name can't be empty");
      return;
    }
    if (passwordField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "password can't be empty");
      return;
    }
    if (melliCodeField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "code melli can't be empty");
      return;
    }
    if (supervisorField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "supervisor id can't be empty");
      return;
    }

    try {
      Integer.parseInt(melliCodeField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "code melli must be a number");
      return;
    }
    try {
      Integer.parseInt(supervisorField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "supervisor id must be a number");
      return;
    }
    try {
      Integer.parseInt(enteringYearField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "year of entry must be a number");
      return;
    }

    Professor supervisor = Controller.getInstance().findProfessorById(Integer.parseInt(supervisorField.getText()));
    if (supervisor == null) {
      JOptionPane.showMessageDialog(mainFrame, "invalid supervisor id");
      return;
    }

    int id = Controller.getInstance().addStudent(nameField.getText(), emailField.getText(), melliCodeField.getText(),
            professor.getFacultyName(), phoneField.getText(), passwordField.getText(), String.valueOf(supervisor.getId()), enteringYearField.getText(),
            statusBox.getSelectedItem().toString(), gradeBox.getSelectedItem().toString());
    JOptionPane.showMessageDialog(mainFrame, "student with id " + id + " added");

//  todo  mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new AddStudentPanel(mainFrame, professor)));
    mainFrame.repaintFrame();
  }

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
// todo   mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new AddStudentOrProfessorPanel(mainFrame, professor)));
    mainFrame.repaintFrame();
  }


  // Variables declaration - do not modify
  private javax.swing.JButton addButton;
  private javax.swing.JButton backButton;
  private javax.swing.JTextField emailField;
  private javax.swing.JLabel emailLabel;
  private javax.swing.JTextField enteringYearField;
  private javax.swing.JLabel enteringYearLabel;
  private javax.swing.JComboBox<String> gradeBox;
  private javax.swing.JLabel gradeLabel;
  private javax.swing.JTextField melliCodeField;
  private javax.swing.JLabel melliCodeLabel;
  private javax.swing.JTextField nameField;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField passwordField;
  private javax.swing.JLabel passwordLabel;
  private javax.swing.JTextField phoneField;
  private javax.swing.JLabel phoneLabel;
  private javax.swing.JComboBox<String> statusBox;
  private javax.swing.JLabel statusLabel;
  private javax.swing.JTextField supervisorField;
  private javax.swing.JLabel supervisorLabel;
  // End of variables declaration
}
