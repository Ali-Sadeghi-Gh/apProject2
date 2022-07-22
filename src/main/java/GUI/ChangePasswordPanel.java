package GUI;

import GUI.professors.ProfessorPanel;
import LOGIC.Controller;
import client.Client;
import shared.model.users.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class ChangePasswordPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;
  User user;

  /**
   * Creates new form changePasswordPanel
   */
  public ChangePasswordPanel(MainFrame mainFrame, User user) {
    this.mainFrame = mainFrame;
    this.user = user;

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

    alertLabel = new JLabel();
    currentPassLabel = new JLabel();
    newPassLabel = new JLabel();
    verifyPassLabel = new JLabel();
    changeButton = new JButton();
    currentPassField = new JPasswordField();
    newPassField = new JPasswordField();
    verifyPassField = new JPasswordField();
    currentPassCheck = new JCheckBox();
    newPassCheck = new JCheckBox();
    verifyPassCheck = new JCheckBox();

    alertLabel.setFont(new Font("Tahoma", 0, 36)); // NOI18N
    alertLabel.setForeground(new Color(255, 0, 0));
    alertLabel.setHorizontalAlignment(SwingConstants.CENTER);
    alertLabel.setText("*You mast change your password");

    currentPassLabel.setFont(new Font("Tahoma", 0, 18)); // NOI18N
    currentPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
    currentPassLabel.setText("current password:");

    newPassLabel.setFont(new Font("Tahoma", 0, 18)); // NOI18N
    newPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
    newPassLabel.setText("new password:");

    verifyPassLabel.setFont(new Font("Tahoma", 0, 18)); // NOI18N
    verifyPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
    verifyPassLabel.setText("verify password:");

    changeButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
    changeButton.setText("change");
    changeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        changeButtonActionPerformed(evt);
      }
    });

    currentPassField.setFont(new Font("Tahoma", 0, 18)); // NOI18N
    currentPassField.setHorizontalAlignment(JTextField.CENTER);
    currentPassField.setEchoChar('*');

    newPassField.setFont(new Font("Tahoma", 0, 18)); // NOI18N
    newPassField.setHorizontalAlignment(JTextField.CENTER);
    newPassField.setEchoChar('*');

    verifyPassField.setFont(new Font("Tahoma", 0, 18)); // NOI18N
    verifyPassField.setHorizontalAlignment(JTextField.CENTER);
    verifyPassField.setEchoChar('*');

    currentPassCheck.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentPassCheckActionPerformed(evt);
      }
    });

    newPassCheck.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        newPassCheckActionPerformed(evt);
      }
    });

    verifyPassCheck.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        verifyPassCheckActionPerformed(evt);
      }
    });

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(718, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(alertLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(changeButton, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(27, 27, 27)))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(88, 88, 88)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(verifyPassLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(newPassLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(currentPassLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                            .addGap(53, 53, 53)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(currentPassField)
                                                    .addComponent(newPassField)
                                                    .addComponent(verifyPassField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(currentPassCheck)
                                                    .addComponent(newPassCheck)
                                                    .addComponent(verifyPassCheck))))
                            .addGap(633, 633, 633))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(alertLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                            .addGap(135, 135, 135)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(currentPassLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(currentPassField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(currentPassCheck))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(newPassLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(newPassField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(newPassCheck))
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(verifyPassLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(verifyPassField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(verifyPassCheck))
                            .addGap(74, 74, 74)
                            .addComponent(changeButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(279, Short.MAX_VALUE))
    );
  }// </editor-fold>

  private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (currentPassField.getText().hashCode() != user.getPassword()) {
      JOptionPane.showMessageDialog(mainFrame, "incorrect password input");
      mainFrame.setContentPane(new ChangePasswordPanel(mainFrame, user));
      mainFrame.repaintFrame();
      return;
    }

    if (newPassField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "new password can't be empty");
      mainFrame.setContentPane(new ChangePasswordPanel(mainFrame, user));
      mainFrame.repaintFrame();
      return;
    }

    if (!newPassField.getText().equals(verifyPassField.getText())) {
      JOptionPane.showMessageDialog(mainFrame, "new password doesn't match");
      mainFrame.setContentPane(new ChangePasswordPanel(mainFrame, user));
      mainFrame.repaintFrame();
      return;
    }

    if (currentPassField.getText().equals(newPassField.getText())) {
      JOptionPane.showMessageDialog(mainFrame, "new password must differ from old one");
      mainFrame.setContentPane(new ChangePasswordPanel(mainFrame, user));
      mainFrame.repaintFrame();
      return;
    }


    Controller.getInstance().changePassword(newPassField.getText(), user);
    Controller.getInstance().setUserLoginTime(user);

    if (user instanceof Student) {
//todo      mainFrame.setContentPane(new StudentPanel(mainFrame, (Student) user, new StudentMainPanel((Student) user)));
      mainFrame.repaintFrame();
      return;
    }

    Professor professor = (Professor) user;
    if (professor.getPosition() == Professor.Position.eduAssistant) {
//   todo   mainFrame.setContentPane(new EduAssistantPanel(mainFrame, (Professor) user, new JPanel()));
      mainFrame.repaintFrame();
      return;
    }

    mainFrame.setContentPane(new ProfessorPanel(mainFrame, new JPanel(), client));
    mainFrame.repaintFrame();
  }

  private void currentPassCheckActionPerformed(java.awt.event.ActionEvent evt) {
    if (currentPassCheck.isSelected()) {
      currentPassField.setEchoChar((char) 0);
    } else {
      currentPassField.setEchoChar('*');
    }
  }

  private void newPassCheckActionPerformed(java.awt.event.ActionEvent evt) {
    if (newPassCheck.isSelected()) {
      newPassField.setEchoChar((char) 0);
    } else {
      newPassField.setEchoChar('*');
    }
  }

  private void verifyPassCheckActionPerformed(java.awt.event.ActionEvent evt) {
    if (verifyPassCheck.isSelected()) {
      verifyPassField.setEchoChar((char) 0);
    } else {
      verifyPassField.setEchoChar('*');
    }
  }


  // Variables declaration - do not modify
  private javax.swing.JLabel alertLabel;
  private javax.swing.JButton changeButton;
  private javax.swing.JCheckBox currentPassCheck;
  private javax.swing.JPasswordField currentPassField;
  private javax.swing.JLabel currentPassLabel;
  private javax.swing.JCheckBox newPassCheck;
  private javax.swing.JPasswordField newPassField;
  private javax.swing.JLabel newPassLabel;
  private javax.swing.JCheckBox verifyPassCheck;
  private javax.swing.JPasswordField verifyPassField;
  private javax.swing.JLabel verifyPassLabel;
  // End of variables declaration
}
