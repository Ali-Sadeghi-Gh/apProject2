package GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import client.Client;

import java.awt.*;

/**
 *
 * @author HP
 */
public class AddStudentOrProfessorPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;
  /**
   * Creates new form AddStudentOrProfessorPanel
   */
  public AddStudentOrProfessorPanel(MainFrame mainFrame, Client client) {
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

    addStudentButton = new javax.swing.JButton();
    addProfessorButton = new javax.swing.JButton();

    addStudentButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    addStudentButton.setText("add student");
    addStudentButton.addActionListener(this::addStudentButtonActionPerformed);

    addProfessorButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    addProfessorButton.setText("add professor");
    addProfessorButton.addActionListener(this::addProfessorButtonActionPerformed);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(168, 168, 168)
                            .addComponent(addStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(146, 146, 146)
                            .addComponent(addProfessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(208, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(276, 276, 276)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addProfessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(339, Short.MAX_VALUE))
    );
  }// </editor-fold>

  private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
// todo   mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new AddStudentPanel(mainFrame, professor)));
    mainFrame.repaintFrame();
  }

  private void addProfessorButtonActionPerformed(java.awt.event.ActionEvent evt) {
//  todo  mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new AddProfessorPanel(mainFrame, professor)));
    mainFrame.repaintFrame();
  }


  // Variables declaration - do not modify
  private javax.swing.JButton addProfessorButton;
  private javax.swing.JButton addStudentButton;
  // End of variables declaration
}
