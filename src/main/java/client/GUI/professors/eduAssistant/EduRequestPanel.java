package client.GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.GUI.MainFrame;
import client.Client;
import shared.model.PanelName;
import shared.model.users.UserRole;
import shared.util.Config;

import java.awt.*;

/**
 *
 * @author HP
 */
public class EduRequestPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form EduRequestPanel
   */
  public EduRequestPanel(MainFrame mainFrame, Client client) {
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

    recommendationButton = new javax.swing.JButton();
    dropoutButton = new javax.swing.JButton();
    minorButton = new javax.swing.JButton();

    recommendationButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    recommendationButton.setText(getConfig().getProperty(String.class, "recommendationButtonText"));
    recommendationButton.addActionListener(this::recommendationButtonActionPerformed);

    dropoutButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    dropoutButton.setText(getConfig().getProperty(String.class, "dropoutButtonText"));
    dropoutButton.addActionListener(this::dropoutButtonActionPerformed);

    minorButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    minorButton.setText(getConfig().getProperty(String.class, "minorButtonText"));
    minorButton.addActionListener(this::minorButtonActionPerformed);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(recommendationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                            .addComponent(dropoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(minorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(82, 82, 82))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(280, 280, 280)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(recommendationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dropoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(335, Short.MAX_VALUE))
    );
  }// </editor-fold>

  private void recommendationButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.RECOMMENDATION_LIST_PANEL, UserRole.EDU_ASSISTANT);
  }

  private void dropoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.DROPOUT_LIST_PANEL, null);
  }

  private void minorButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.MINOR_LIST_PANEL, null);
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "eduAssistantConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JButton minorButton;
  private javax.swing.JButton recommendationButton;
  private javax.swing.JButton dropoutButton;
  // End of variables declaration
}