package GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import LOGIC.Controller;
import shared.model.users.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class EduSearchProfessorPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Professor professor;

  /**
   * Creates new form EduSearchProfessorPanel
   */
  public EduSearchProfessorPanel(MainFrame mainFrame, Professor professor) {
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

    searchButton = new javax.swing.JButton();
    professorField = new javax.swing.JTextField();
    professorLabel = new javax.swing.JLabel();
    facultyLabel = new javax.swing.JLabel();
    creditLabel = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    idLabel = new javax.swing.JLabel();
    degreeLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    scoreTable = new javax.swing.JTable();

    searchButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    searchButton.setText("search");
    searchButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        searchButtonActionPerformed(evt);
      }
    });

    professorField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    professorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    professorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    professorLabel.setText("professor id:");

    facultyLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    facultyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    creditLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    creditLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    idLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    degreeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    degreeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    scoreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    jScrollPane1.setViewportView(scoreTable);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(professorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(professorField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(degreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(294, 294, 294)
                                            .addComponent(creditLabel))
                                    .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(22, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(professorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(professorField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(degreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(creditLabel)
                            .addContainerGap(18, Short.MAX_VALUE))
    );
  }// </editor-fold>

  public void showData(Professor professor) {
    idLabel.setText("id: " + professor.getId());
    nameLabel.setText("name: " + (professor.getName()==null ? "-" : professor.getName()));
    facultyLabel.setText("faculty: " + (professor.getFacultyName()==null ? "-" : professor.getFacultyName()));
    degreeLabel.setText("degree: " + (professor.getDegree()==null ? "-" : professor.getDegree()));

    String[] cols = {"course id", "course name", "student id", "student name", "objection", "answer", "score"};
    String[][] data = Controller.getInstance().getAllScoresDataByProfessor(professor);

    DefaultTableModel model = (DefaultTableModel) scoreTable.getModel();
    model.setDataVector(data, cols);
  }

  private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      Integer.parseInt(professorField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "professor id must be a number");
      return;
    }
    Professor searchProfessor = Controller.getInstance().findProfessorById(Integer.parseInt(professorField.getText()));
    professorField.setText("");

    if (searchProfessor == null) {
      JOptionPane.showMessageDialog(mainFrame, "professor not found");
    } else {
      showData(searchProfessor);
    }
  }

  // Variables declaration - do not modify
  private javax.swing.JLabel creditLabel;
  private javax.swing.JLabel degreeLabel;
  private javax.swing.JLabel facultyLabel;
  private javax.swing.JLabel idLabel;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField professorField;
  private javax.swing.JLabel professorLabel;
  private javax.swing.JTable scoreTable;
  private javax.swing.JButton searchButton;
  // End of variables declaration
}
