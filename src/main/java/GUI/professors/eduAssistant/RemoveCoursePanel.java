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
public class RemoveCoursePanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Professor professor;
  /**
   * Creates new form RemoveCoursePanel
   */
  public RemoveCoursePanel(MainFrame mainFrame, Professor professor) {
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

    backButton = new javax.swing.JButton();
    idLabel = new javax.swing.JLabel();
    idField = new javax.swing.JTextField();
    removeButton = new javax.swing.JButton();

    backButton.setText("back");
    backButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backButtonActionPerformed(evt);
      }
    });

    idLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    idLabel.setText("course id:");

    idField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    removeButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    removeButton.setText("remove");
    removeButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        removeButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(55, 55, 55)
                                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(315, 315, 315)
                                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(457, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(354, 354, 354))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(163, 163, 163)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(62, 62, 62)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(310, Short.MAX_VALUE))
    );
  }// </editor-fold>

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
//  todo  mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new CoursesListEduPanel(mainFrame, professor)));
    mainFrame.repaintFrame();
  }

  private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (idField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "enter id");
      return;
    }

    int id;
    try {
      id = Integer.parseInt(idField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "id must be a number");
      return;
    }

//    if (Controller.getInstance().removeCourse(id, professor.getFacultyName())) {
//      JOptionPane.showMessageDialog(mainFrame, "course with id: " + idField.getText() + " removed");
//   todo   mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new RemoveCoursePanel(mainFrame, professor)));
//      mainFrame.repaintFrame();
//    } else {
//      JOptionPane.showMessageDialog(mainFrame, "course not found");
//    }
  }


  // Variables declaration - do not modify
  private javax.swing.JButton backButton;
  private javax.swing.JTextField idField;
  private javax.swing.JLabel idLabel;
  private javax.swing.JButton removeButton;
  // End of variables declaration
}
