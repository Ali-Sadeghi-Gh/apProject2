package client.GUI.student;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.GUI.MainFrame;
import client.Client;
import shared.util.Config;

import java.awt.*;

/**
 *
 * @author HP
 */
public class DormitoryRequestPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form DormitoryPanel
   */
  public DormitoryRequestPanel(MainFrame mainFrame, Client client) {
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

    requestButton = new javax.swing.JButton();
    resultLabel = new javax.swing.JLabel();

    requestButton.setText(getConfig().getProperty(String.class, "dormitoryRequestButtonText"));
    requestButton.addActionListener(this::requestButtonActionPerformed);

    resultLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(225, 225, 225)
                                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(412, 412, 412)
                                            .addComponent(requestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(241, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(275, Short.MAX_VALUE)
                            .addComponent(requestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(228, 228, 228))
    );
  }// </editor-fold>

  private void requestButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (resultLabel.getText().equals("")) {
      client.dormitoryRequest(this);
    } else {
      mainFrame.showMessage(getConfig().getProperty(String.class, "oneRequestErrorMessage"));
    }
  }

  public void update(String result) {
    resultLabel.setText(result.equals("") ? "" : String.format(getConfig().getProperty(String.class, "dormitoryResultPattern"), result));
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "studentConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JButton requestButton;
  private javax.swing.JLabel resultLabel;
  // End of variables declaration
}