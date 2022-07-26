package client.GUI.student;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import shared.util.Config;

import java.awt.*;

/**
 * @author HP
 */
public class StudentMainPanel extends javax.swing.JPanel {
  /**
   * Creates new form StudentMainPanel
   */
  public StudentMainPanel() {
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

    supervisorLabel = new javax.swing.JLabel();
    statusLabel = new javax.swing.JLabel();
    registrationTimeLabel = new javax.swing.JLabel();
    registrationPermitLabel = new javax.swing.JLabel();

    supervisorLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    supervisorLabel.setBackground(new java.awt.Color(200, 200, 200));
    supervisorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    supervisorLabel.setOpaque(true);

    statusLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    statusLabel.setBackground(new java.awt.Color(200, 200, 200));
    statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    statusLabel.setOpaque(true);

    registrationTimeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    registrationTimeLabel.setBackground(new java.awt.Color(200, 200, 200));
    registrationTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    registrationTimeLabel.setOpaque(true);

    registrationPermitLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    registrationPermitLabel.setBackground(new java.awt.Color(200, 200, 200));
    registrationPermitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    registrationPermitLabel.setOpaque(true);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(171, 171, 171)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(supervisorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(registrationPermitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(registrationTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(361, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(supervisorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(registrationPermitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addComponent(registrationTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(128, Short.MAX_VALUE))
    );
  }// </editor-fold>

  public void update(String educationalStatus, String supervisor, String registration, String registrationTime) {
    supervisorLabel.setText(String.format(getConfig().getProperty(String.class, "supervisorLabelText"), (supervisor == null || supervisor.equals("")) ? "-" : supervisor));
    statusLabel.setText(String.format(getConfig().getProperty(String.class, "eduStatusLabelText"), educationalStatus == null ? "-" : educationalStatus));
    registrationPermitLabel.setText(registration);
    registrationTimeLabel.setText(String.format(getConfig().getProperty(String.class, "registrationTimeLabelText"), registrationTime));
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "studentConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JLabel registrationPermitLabel;
  private javax.swing.JLabel registrationTimeLabel;
  private javax.swing.JLabel statusLabel;
  private javax.swing.JLabel supervisorLabel;
  // End of variables declaration
}
