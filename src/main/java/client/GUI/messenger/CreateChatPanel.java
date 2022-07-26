package client.GUI.messenger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.Client;
import client.GUI.MainFrame;
import shared.model.PanelName;
import shared.model.users.UserRole;
import shared.util.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class CreateChatPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;
  UserRole userRole;

  /**
   * Creates new form CreateChatPanel
   */
  public CreateChatPanel(MainFrame mainFrame, Client client, UserRole userRole) {
    this.client = client;
    this.mainFrame = mainFrame;
    this.userRole = userRole;
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
    chatsButton = new javax.swing.JButton();
    addContactLabel = new javax.swing.JLabel();
    contactsLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    contactIdLabel = new javax.swing.JLabel();
    contactIdField = new javax.swing.JTextField();
    addContactButton = new javax.swing.JButton();
    sendToAllBox = new javax.swing.JCheckBox();
    textField = new javax.swing.JTextField();
    sendTextButton = new javax.swing.JButton();
    sendFileButton = new javax.swing.JButton();
    contactsTable = new javax.swing.JTable();

    contactsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    contactsTable.setCellSelectionEnabled(true);
    contactsTable.setModel(new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    });
    jScrollPane1.setViewportView(contactsTable);

    textField.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N

    chatsButton.setText(getConfig().getProperty(String.class, "chatsButtonText"));
    chatsButton.addActionListener(this::chatsButtonActionPerformed);

    addContactLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 22)); // NOI18N
    addContactLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    addContactLabel.setText(getConfig().getProperty(String.class, "addContactLabelText"));

    contactsLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 22)); // NOI18N
    contactsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    contactsLabel.setText(getConfig().getProperty(String.class, "contactsLabelText"));

    contactIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    contactIdLabel.setText(getConfig().getProperty(String.class, "contactIdLabelText"));

    contactIdField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    addContactButton.setText(getConfig().getProperty(String.class, "addContactButtonText"));
    addContactButton.addActionListener(this::addContactButtonActionPerformed);

    sendToAllBox.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20)); // NOI18N
    sendToAllBox.setText(getConfig().getProperty(String.class, "sendToAllBoxText"));

    sendTextButton.setText(getConfig().getProperty(String.class, "sendTextButtonText"));
    sendTextButton.addActionListener(this::sendTextButtonActionPerformed);

    sendFileButton.setText(getConfig().getProperty(String.class, "sendFileButtonText"));
    sendFileButton.addActionListener(this::sendFileButtonActionPerformed);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGap(0, 0, Short.MAX_VALUE)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addGap(71, 71, 71)
                                                                            .addComponent(addContactLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(addContactButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                    .addComponent(contactIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addGap(43, 43, 43)
                                                                                    .addComponent(contactIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addGap(37, 37, 37))))
                                                            .addGap(100, 100, 100))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(sendFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(sendTextButton))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(sendToAllBox, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(contactsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(132, 132, 132))
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(chatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(875, 875, 875)))
                            .addGap(47, 47, 47))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(chatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(contactsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(addContactLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(contactIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(contactIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(addContactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(220, 220, 220)
                                            .addComponent(sendToAllBox, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textField)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(sendTextButton)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(sendFileButton))))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(42, Short.MAX_VALUE))
    );
  }// </editor-fold>

  private void sendTextButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (textField.getText().equals("")) {
      return;
    }
    ArrayList<String> contacts = new ArrayList<>();
    if (sendToAllBox.isSelected()) {
      for (int i = 0; i < contactsTable.getRowCount(); i++) {
        contacts.add((String) contactsTable.getValueAt(i, 0));
      }
    } else {
      for (int i = 0; i < contactsTable.getRowCount(); i++) {
        if (contactsTable.getValueAt(i, 3) != null && (Boolean) contactsTable.getValueAt(i, 3)) {
          contacts.add((String) contactsTable.getValueAt(i, 0));
        }
      }
    }
    client.messengerSendText(textField.getText(), contacts);
    textField.setText("");
  }

  private void sendFileButtonActionPerformed(java.awt.event.ActionEvent evt) {
    JFileChooser fileChooser = new JFileChooser(getConfig().getProperty(String.class, "fileChooserOpenDefaultDir"));
    int response = fileChooser.showOpenDialog(null);
    if (response == JFileChooser.APPROVE_OPTION) {
      File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
      String fileName = file.getName();
      FileInputStream fileInputStream = null;
      try {
        fileInputStream = new FileInputStream(file);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      byte[] bytes = new byte[(int) file.length()];
      try {
        int result;
        do {
          assert fileInputStream != null;
          result = fileInputStream.read(bytes);
        } while (result != -1);
        fileInputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      ArrayList<String> contacts = new ArrayList<>();
      if (sendToAllBox.isSelected()) {
        for (int i = 0; i < contactsTable.getRowCount(); i++) {
          contacts.add((String) contactsTable.getValueAt(i, 0));
        }
      } else {
        for (int i = 0; i < contactsTable.getRowCount(); i++) {
          if (contactsTable.getValueAt(i, 3) != null && (Boolean) contactsTable.getValueAt(i, 3)) {
            contacts.add((String) contactsTable.getValueAt(i, 0));
          }
        }
      }
      client.messengerSendFile(bytes, fileName, contacts);
    }
  }

  private void chatsButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.MESSENGER_PANEL, userRole);
  }

  private void addContactButtonActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      Integer.parseInt(contactIdField.getText());
    } catch (Exception e) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "contactIdNumErrorMessage"));
      contactIdField.setText("");
      return;
    }
    client.addContact(contactIdField.getText());
    contactIdField.setText("");
  }

  public void showData(Object[][] data) {
    String[] cols = {"id", "name", "faculty", "send message"};
    DefaultTableModel model = new DefaultTableModel(new String[]{}, data.length) {
      @Override public Class getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
          return Boolean.class;
        }
        return String.class;
      }
    };
    model.setDataVector(data, cols);
    contactsTable.setModel(model);
  }

  public Boolean[] getSendMessageBooleans() {
    Boolean[] sendMessageBooleans = new Boolean[contactsTable.getRowCount()];
    for (int i = 0; i < contactsTable.getRowCount(); i++) {
      sendMessageBooleans[i] = (Boolean) contactsTable.getValueAt(i, 3);
    }
    return sendMessageBooleans;
  }

  public void update(Object[][] data) {
    showData(data);
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "messengerConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JButton addContactButton;
  private javax.swing.JLabel addContactLabel;
  private javax.swing.JButton chatsButton;
  private javax.swing.JTextField contactIdField;
  private javax.swing.JLabel contactIdLabel;
  private javax.swing.JLabel contactsLabel;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton sendFileButton;
  private javax.swing.JButton sendTextButton;
  private javax.swing.JCheckBox sendToAllBox;
  private javax.swing.JTextField textField;
  private javax.swing.JTable contactsTable;
  // End of variables declaration
}
