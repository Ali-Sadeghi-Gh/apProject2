package GUI.professors.dean;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import client.Client;
import shared.model.PanelName;
import shared.model.users.UserRole;

import java.awt.*;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class ChangeProfessorPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form ChangeProfessorPanel
   */
  public ChangeProfessorPanel(MainFrame mainFrame, Client client) {
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

    nameLabel = new javax.swing.JLabel();
    melliCodeLabel = new javax.swing.JLabel();
    positionLabel = new javax.swing.JLabel();
    backButton = new javax.swing.JButton();
    positionBox = new javax.swing.JComboBox<>();
    emailField = new javax.swing.JTextField();
    emailLabel = new javax.swing.JLabel();
    changeButton = new javax.swing.JButton();
    phoneField = new javax.swing.JTextField();
    nameField = new javax.swing.JTextField();
    phoneLabel = new javax.swing.JLabel();
    passwordField = new javax.swing.JTextField();
    roomNumberField = new javax.swing.JTextField();
    passwordLabel = new javax.swing.JLabel();
    roomNumberLabel = new javax.swing.JLabel();
    melliCodeField = new javax.swing.JTextField();
    degreeLabel = new javax.swing.JLabel();
    degreeBox = new javax.swing.JComboBox<>();
    idField = new javax.swing.JTextField();
    idLabel = new javax.swing.JLabel();
    findButton = new javax.swing.JButton();

    nameLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setText("name:");

    melliCodeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    melliCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    melliCodeLabel.setText("code melli:");

    positionLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    positionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    positionLabel.setText("position:");

    backButton.setText("back");
    backButton.addActionListener(this::backButtonActionPerformed);

    positionBox.setMaximumRowCount(10);
    positionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"none"}));

    emailField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    emailLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    emailLabel.setText("email:");

    changeButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
    changeButton.setText("change");
    changeButton.addActionListener(this::changeButtonActionPerformed);

    phoneField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    phoneLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    phoneLabel.setText("phone number:");

    passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    roomNumberField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    passwordLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    passwordLabel.setText("password:");

    roomNumberLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    roomNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    roomNumberLabel.setText("room number");

    melliCodeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    degreeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    degreeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    degreeLabel.setText("degree:");

    degreeBox.setMaximumRowCount(10);
    degreeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"none"}));

    idField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    idLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    idLabel.setText("id:");

    findButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    findButton.setText("find");
    findButton.addActionListener(this::findButtonActionPerformed);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(127, 127, 127)
                                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(18, 18, 18)
                                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(444, 444, 444))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGap(55, 55, 55)
                                                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(melliCodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                            .addGap(57, 57, 57)
                                                            .addComponent(melliCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGap(57, 57, 57)
                                                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGap(55, 55, 55)
                                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(129, 129, 129)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(positionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGap(30, 30, 30)
                                                            .addComponent(positionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(degreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(roomNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addGap(30, 30, 30)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(degreeBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(roomNumberField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(56, 56, 56))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(124, 124, 124))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(295, 295, 295))))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(roomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(degreeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(degreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(melliCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(melliCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(47, 47, 47)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(positionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(44, 44, 44)
                            .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36))
    );
  }// </editor-fold>

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changeToProfessorsListPanel(UserRole.Professor, "all", "", "all");
  }

  private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      Integer.parseInt(idField.getText());
    } catch (Exception e) {
      mainFrame.showMessage("professor id must be a number");
      client.changePanel(PanelName.CHANGE_PROFESSOR_PANEL, null);
      return;
    }

    client.findProfessorForChange(this, idField.getText());
  }

  private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (idField.getText().equals("")) {
      mainFrame.showMessage("choose a professor");
      return;
    }
    try {
      Integer.parseInt(idField.getText());
    } catch (Exception e) {
      mainFrame.showMessage("professor id must be a number");
      return;
    }
    if (nameField.getText().equals("")) {
      mainFrame.showMessage("name can't be empty");
      return;
    }
    if (melliCodeField.getText().equals("")) {
      mainFrame.showMessage("code melli can't be empty");
      return;
    }
    if (roomNumberField.getText().equals("")) {
      mainFrame.showMessage("room number can't be empty");
      return;
    }

    try {
      Integer.parseInt(melliCodeField.getText());
    } catch (Exception e) {
      mainFrame.showMessage("code melli must be a number");
      return;
    }
    try {
      Integer.parseInt(roomNumberField.getText());
    } catch (Exception e) {
      mainFrame.showMessage("year of entry must be a number");
      return;
    }

    client.changeProfessor(idField.getText(), nameField.getText(), emailField.getText(), melliCodeField.getText(),
            phoneField.getText(), passwordField.getText(), roomNumberField.getText(),
            Objects.requireNonNull(degreeBox.getSelectedItem()).toString(), Objects.requireNonNull(positionBox.getSelectedItem()).toString());
  }

  public void update(String id, String name, String melliCode, String email, String phoneNumber, String roomNumber,
                     String[] degrees, String[] positions) {
    idField.setText(id);
    nameField.setText(name);
    passwordField.setText("");
    melliCodeField.setText(melliCode);
    emailField.setText(email);
    phoneField.setText(phoneNumber);
    roomNumberField.setText(roomNumber);
    degreeBox.setModel(new javax.swing.DefaultComboBoxModel<>(degrees));
    positionBox.setModel(new javax.swing.DefaultComboBoxModel<>(positions));
  }

  // Variables declaration - do not modify
  private javax.swing.JButton backButton;
  private javax.swing.JButton changeButton;
  private javax.swing.JComboBox<String> degreeBox;
  private javax.swing.JLabel degreeLabel;
  private javax.swing.JTextField emailField;
  private javax.swing.JLabel emailLabel;
  private javax.swing.JButton findButton;
  private javax.swing.JLabel idLabel;
  private javax.swing.JTextField melliCodeField;
  private javax.swing.JLabel melliCodeLabel;
  private javax.swing.JTextField nameField;
  private javax.swing.JTextField idField;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField passwordField;
  private javax.swing.JLabel passwordLabel;
  private javax.swing.JTextField phoneField;
  private javax.swing.JLabel phoneLabel;
  private javax.swing.JComboBox<String> positionBox;
  private javax.swing.JLabel positionLabel;
  private javax.swing.JTextField roomNumberField;
  private javax.swing.JLabel roomNumberLabel;
  // End of variables declaration
}
