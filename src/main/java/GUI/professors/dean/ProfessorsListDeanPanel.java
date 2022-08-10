package GUI.professors.dean;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import client.Client;
import shared.model.PanelName;
import shared.model.users.Professor;
import shared.model.users.UserRole;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class ProfessorsListDeanPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form ProfessorsListDeanPanel
   */
  public ProfessorsListDeanPanel(MainFrame mainFrame, Client client) {
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

    jScrollPane1 = new javax.swing.JScrollPane();
    professorsTable = new javax.swing.JTable();
    facultyLabel = new javax.swing.JLabel();
    facultyBox = new javax.swing.JComboBox<>();
    nameLabel = new javax.swing.JLabel();
    nameField = new javax.swing.JTextField();
    degreeLabel = new javax.swing.JLabel();
    degreeBox = new javax.swing.JComboBox<>();
    searchButton = new javax.swing.JButton();
    removeProfessorButton = new javax.swing.JButton();
    addProfessorButton = new javax.swing.JButton();
    changeProfessorButton = new javax.swing.JButton();


    professorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    professorsTable.setCellSelectionEnabled(true);
    jScrollPane1.setViewportView(professorsTable);

    facultyLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    facultyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    facultyLabel.setText("faculty:");

    facultyBox.setMaximumRowCount(10);

    nameLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setText("name:");

    nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);


    degreeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    degreeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    degreeLabel.setText("degree:");

    degreeBox.setMaximumRowCount(10);
    degreeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", Professor.Degree.assistant.name(), Professor.Degree.associate.name(), Professor.Degree.full.name() }));


    searchButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    searchButton.setText("search");
    searchButton.addActionListener(this::searchButtonActionPerformed);

    removeProfessorButton.setText("remove professor");
    removeProfessorButton.addActionListener(this::removeProfessorButtonActionPerformed);

    addProfessorButton.setText("add new professor");
    addProfessorButton.addActionListener(this::addProfessorButtonActionPerformed);

    changeProfessorButton.setText("change professor");
    changeProfessorButton.addActionListener(this::changeProfessorButtonActionPerformed);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGap(194, 194, 194)
                                                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(0, 0, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                    .addComponent(facultyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                    .addComponent(degreeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addGroup(layout.createSequentialGroup()
                                                                                            .addGap(44, 44, 44)
                                                                                            .addComponent(degreeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addComponent(facultyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                                                            .addGap(44, 44, 44)
                                                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(54, 54, 54)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(removeProfessorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(addProfessorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(changeProfessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(30, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(addProfessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(changeProfessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(removeProfessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(facultyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(degreeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(degreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(27, 27, 27)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(169, 169, 169))
    );
  }// </editor-fold>

  private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changeToProfessorsListPanel(UserRole.Professor, Objects.requireNonNull(facultyBox.getSelectedItem()).toString(), nameField.getText(), Objects.requireNonNull(degreeBox.getSelectedItem()).toString());
  }

  private void removeProfessorButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.REMOVE_PROFESSOR_PANEL, null);
  }

  private void addProfessorButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.ADD_PROFESSOR_DEAN_PANEL, null);
  }

  private void changeProfessorButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.CHANGE_PROFESSOR_PANEL, null);
  }

  public void showData(String[][] data) {
    DefaultTableModel model = (DefaultTableModel) professorsTable.getModel();
    String[] cols = {"id", "name", "faculty", "email", "degree"};
    model.setDataVector(data, cols);
  }

  public void update(String[] faculties, String[][] data) {
    facultyBox.setModel(new javax.swing.DefaultComboBoxModel<>(faculties));
    showData(data);
  }

  // Variables declaration - do not modify
  private javax.swing.JButton addProfessorButton;
  private javax.swing.JButton changeProfessorButton;
  private javax.swing.JLabel degreeLabel;
  private javax.swing.JComboBox<String> facultyBox;
  private javax.swing.JComboBox<String> degreeBox;
  private javax.swing.JLabel facultyLabel;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable professorsTable;
  private javax.swing.JTextField nameField;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JButton removeProfessorButton;
  private javax.swing.JButton searchButton;
  // End of variables declaration
}
