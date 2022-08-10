package GUI.messenger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import client.Client;
import shared.model.message.Chat;
import shared.model.message.Messenger;

import java.awt.*;

/**
 *
 * @author HP
 */
public class MessengerPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form MessengerPanel
   */
  public MessengerPanel(MainFrame mainFrame, Client client) {
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

    createChatButton = new javax.swing.JButton();
    chatsPane = new javax.swing.JScrollPane();
    messagesPane = new javax.swing.JScrollPane();
    textField = new javax.swing.JTextField();
    contactNameLabel = new javax.swing.JLabel();
    sendTextButton = new javax.swing.JButton();
    sendFileButton = new javax.swing.JButton();

    createChatButton.setText("create a chat");
    createChatButton.addActionListener(this::createChatButtonActionPerformed);

    contactNameLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N

    sendTextButton.setText("send text");
    sendTextButton.addActionListener(this::sendTextButtonActionPerformed);

    sendFileButton.setText("send file");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(78, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(messagesPane)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(sendFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(sendTextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(contactNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(27, 27, 27)
                            .addComponent(chatsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(createChatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(createChatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(contactNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(1, 1, 1)
                                            .addComponent(messagesPane, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textField)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(sendTextButton)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(sendFileButton))))
                                    .addComponent(chatsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54))
    );
  }// </editor-fold>

  private void createChatButtonActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void sendTextButtonActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  public void update(Messenger messenger, Chat chat) {

  }


  // Variables declaration - do not modify
  private javax.swing.JScrollPane chatsPane;
  private javax.swing.JLabel contactNameLabel;
  private javax.swing.JButton createChatButton;
  private javax.swing.JScrollPane messagesPane;
  private javax.swing.JButton sendFileButton;
  private javax.swing.JButton sendTextButton;
  private javax.swing.JTextField textField;
  // End of variables declaration
}
