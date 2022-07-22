package GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import shared.model.users.Professor;

import javax.swing.*;

/**
 *
 * @author HP
 */
public class AddProfessorPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Professor professor;
  /**
   * Creates new form AddProfessor
   */
  public AddProfessorPanel(MainFrame mainFrame, Professor professor) {
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

    emailField = new javax.swing.JTextField();
    emailLabel = new javax.swing.JLabel();
    addButton = new javax.swing.JButton();
    backButton = new javax.swing.JButton();
    phoneField = new javax.swing.JTextField();
    phoneLabel = new javax.swing.JLabel();
    roomNumberField = new javax.swing.JTextField();
    roomNumberLabel = new javax.swing.JLabel();
    degreeLabel = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    nameField = new javax.swing.JTextField();
    passwordField = new javax.swing.JTextField();
    passwordLabel = new javax.swing.JLabel();
    melliCodeField = new javax.swing.JTextField();
    degreeBox = new javax.swing.JComboBox<>();
    melliCodeLabel = new javax.swing.JLabel();

    emailField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    emailLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    emailLabel.setText("email:");

    addButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    addButton.setText("add");
    addButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addButtonActionPerformed(evt);
      }
    });

    phoneField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    phoneLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    phoneLabel.setText("phone number:");

    roomNumberField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    roomNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    roomNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    roomNumberLabel.setText("room number");

    degreeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    degreeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    degreeLabel.setText("degree:");

    nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setText("name:");

    nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    passwordLabel.setText("password:");

    melliCodeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    degreeBox.setMaximumRowCount(10);
    degreeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {Professor.Degree.assistant.name(), Professor.Degree.associate.name(), Professor.Degree.full.name()}));

    melliCodeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    melliCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    melliCodeLabel.setText("code melli:");

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
                            .addGap(220, 220, 220)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(melliCodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(57, 57, 57)
                                            .addComponent(melliCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(57, 57, 57)
                                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(175, 175, 175)
                                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(55, 55, 55)
                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(129, 129, 129)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(roomNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(degreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(30, 30, 30)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(degreeBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(roomNumberField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(132, 132, 132))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(73, 73, 73)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(roomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(roomNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(81, 81, 81)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(melliCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(melliCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(degreeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(degreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(136, 136, 136))
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
    if (roomNumberField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "room number can't be empty");
      return;
    }

    try {
      Integer.parseInt(melliCodeField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "code melli must be a number");
      return;
    }
    try {
      Integer.parseInt(roomNumberField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "year of entry must be a number");
      return;
    }

//    int id = Controller.getInstance().addProfessor(nameField.getText(), emailField.getText(), melliCodeField.getText(),
//            professor.getFacultyName(), phoneField.getText(), passwordField.getText(), roomNumberField.getText(),
//            degreeBox.getSelectedItem().toString(), Professor.Position.professor.name());
//    JOptionPane.showMessageDialog(mainFrame, "professor with id " + id + " added");

//  todo  mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new AddProfessorPanel(mainFrame, professor)));
    mainFrame.repaintFrame();
  }

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
// todo   mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new AddStudentOrProfessorPanel(mainFrame, professor)));
    mainFrame.repaintFrame();
  }


  // Variables declaration - do not modify
  private javax.swing.JButton addButton;
  private javax.swing.JButton backButton;
  private javax.swing.JComboBox<String> degreeBox;
  private javax.swing.JLabel degreeLabel;
  private javax.swing.JTextField emailField;
  private javax.swing.JLabel emailLabel;
  private javax.swing.JTextField melliCodeField;
  private javax.swing.JLabel melliCodeLabel;
  private javax.swing.JTextField nameField;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField passwordField;
  private javax.swing.JLabel passwordLabel;
  private javax.swing.JTextField phoneField;
  private javax.swing.JLabel phoneLabel;
  private javax.swing.JTextField roomNumberField;
  private javax.swing.JLabel roomNumberLabel;
  // End of variables declaration
}
