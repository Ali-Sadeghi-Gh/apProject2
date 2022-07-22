package GUI.student;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import LOGIC.Controller;
import shared.model.EducationalRequest;
import shared.model.users.Student;

import javax.swing.*;

/**
 *
 * @author HP
 */
public class DropoutRequestPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Student student;

  /**
   * Creates new form DropoutRequestPanel
   */
  public DropoutRequestPanel(MainFrame mainFrame, Student student) {
    this.student = student;
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

    requestButton = new javax.swing.JButton();
    resultLabel = new javax.swing.JLabel();

    requestButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    requestButton.setText("request dropout");
    requestButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changeButtonActionPerformed(evt);
      }
    });

    resultLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
    resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    resultLabel.setText("");
    EducationalRequest educationalRequest = Controller.getInstance().findRequestByFaculty(student, student.getFacultyName(), EducationalRequest.Type.dropout);
    if (educationalRequest != null) {
      resultLabel.setText(educationalRequest.getResult());
    }

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(384, 384, 384)
                                            .addComponent(requestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(411, 411, 411)
                                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(426, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(257, 257, 257)
                            .addComponent(requestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96)
                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(192, Short.MAX_VALUE))
    );
  }// </editor-fold>

  private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (resultLabel.getText().equals("")) {
      EducationalRequest educationalRequest = Controller.getInstance().addRequest(String.valueOf(student.getId()), null,
              student.getFacultyName(), null, EducationalRequest.Type.dropout);

      JOptionPane.showMessageDialog(mainFrame, "your request submitted");
      resultLabel.setText(educationalRequest.getResult());
    }
  }


  // Variables declaration - do not modify
  private javax.swing.JButton requestButton;
  private javax.swing.JLabel resultLabel;
  // End of variables declaration
}
