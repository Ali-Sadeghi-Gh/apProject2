package GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import shared.model.EducationalRequest;
import shared.model.users.Professor;

import javax.swing.*;

/**
 *
 * @author HP
 */
public class AnswerDropoutPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Professor professor;

  /**
   * Creates new form AnswerDropoutPanel
   */
  public AnswerDropoutPanel(MainFrame mainFrame, Professor professor) {
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

    rejectButton = new javax.swing.JButton();
    requestLabel = new javax.swing.JLabel();
    idField = new javax.swing.JTextField();
    acceptButton = new javax.swing.JButton();
    backButton = new javax.swing.JButton();

    rejectButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
    rejectButton.setText("reject");
    rejectButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rejectButtonActionPerformed(evt);
      }
    });

    requestLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    requestLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    requestLabel.setText("request id:");

    idField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    idField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    acceptButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
    acceptButton.setText("accept");
    acceptButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        acceptButtonActionPerformed(evt);
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGap(305, 305, 305)
                                                            .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addComponent(rejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(265, 265, 265)
                                            .addComponent(requestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(30, 30, 30)
                                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(385, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(requestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(239, 239, 239))
    );
  }// </editor-fold>

  private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {
    answerRequest(false);
  }

  private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {
    answerRequest(true);
  }

  private void answerRequest(boolean accepted) {
    try {
      Integer.parseInt(idField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "request id must be a number");
      return;
    }

//    EducationalRequest educationalRequest = Controller.getInstance().findRequestById(Integer.parseInt(idField.getText()));
//    if (educationalRequest != null && educationalRequest.getType().equals(EducationalRequest.Type.dropout) && educationalRequest.getFaculty()
//            .equals(professor.getFacultyName()) && !educationalRequest.isFinished()) {
//      Controller.getInstance().answerDropout(educationalRequest, accepted);
//      JOptionPane.showMessageDialog(mainFrame, "answer submitted");
//      idField.setText("");
//    } else {
//      JOptionPane.showMessageDialog(mainFrame, "request not found");
//    }
  }

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
//  todo  mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new DropoutListPanel(mainFrame, professor)));
    mainFrame.repaintFrame();
  }


  // Variables declaration - do not modify
  private javax.swing.JButton acceptButton;
  private javax.swing.JButton backButton;
  private javax.swing.JTextField idField;
  private javax.swing.JButton rejectButton;
  private javax.swing.JLabel requestLabel;
  // End of variables declaration
}
