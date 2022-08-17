package client.GUI.professors.dean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.GUI.MainFrame;
import client.Client;
import shared.model.users.UserRole;
import shared.util.Config;

import java.awt.*;

/**
 *
 * @author HP
 */
public class RemoveProfessorPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form RemoveProfessorPanel
   */
  public RemoveProfessorPanel(MainFrame mainFrame, Client client) {
    this.client = client;
    this.mainFrame = mainFrame;
    setBounds(getConfig().getProperty(Integer.class, "panelX"), getConfig().getProperty(Integer.class, "panelY"),
            getConfig().getProperty(Integer.class, "panelWidth"), getConfig().getProperty(Integer.class, "panelHeight"));
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

    backButton.setText(getConfig().getProperty(String.class, "backButtonText"));
    backButton.addActionListener(this::backButtonActionPerformed);

    idLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    idLabel.setText(getConfig().getProperty(String.class, "professorIdLabelText"));

    idField.setHorizontalAlignment(javax.swing.JTextField.CENTER);


    removeButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    removeButton.setText(getConfig().getProperty(String.class, "removeButtonText"));
    removeButton.addActionListener(this::removeButtonActionPerformed);

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
    client.changeToProfessorsListPanel(UserRole.PROFESSOR, getConfig().getProperty(String.class, "comboBoxDefault"),
            "", getConfig().getProperty(String.class, "comboBoxDefault"));
  }

  private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (idField.getText().equals("")) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "idErrorMessage"));
      return;
    }

    try {
      Integer.parseInt(idField.getText());
    } catch (Exception e) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "idNumErrorMessage"));
      return;
    }

    client.removeProfessor(idField.getText());
    idField.setText("");
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "deanConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JButton removeButton;
  private javax.swing.JButton backButton;
  private javax.swing.JTextField idField;
  private javax.swing.JLabel idLabel;
  // End of variables declaration
}
