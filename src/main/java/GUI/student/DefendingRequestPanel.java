package GUI.student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import LOGIC.Controller;
import shared.model.users.Student;

import javax.swing.*;

/**
 *
 * @author HP
 */
public class DefendingRequestPanel extends javax.swing.JPanel {
  Student student;
  /**
   * Creates new form defendingPanel
   */
  public DefendingRequestPanel(Student student) {
    this.student = student;
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

    resultLabel = new javax.swing.JLabel();
    requestButton = new javax.swing.JButton();

    resultLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
    resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    resultLabel.setText(student.getDefendingTurn()==null ? "" : "your defending turn is " + student.getDefendingTurn());

    requestButton.setText("request defending turn");
    requestButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        requestButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(220, 220, 220)
                                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(400, 400, 400)
                                            .addComponent(requestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(246, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(292, Short.MAX_VALUE)
                            .addComponent(requestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(197, 197, 197))
    );
  }// </editor-fold>

  private void requestButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (student.getDefendingTurn() == null) {
      student.setDefendingTurn(Controller.getInstance().getDefendingTurn(student));
      resultLabel.setText("your defending turn is " + student.getDefendingTurn());
    }
  }


  // Variables declaration - do not modify
  private javax.swing.JButton requestButton;
  private javax.swing.JLabel resultLabel;
  // End of variables declaration
}
