package GUI.professors;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import client.Client;
import shared.model.PanelName;
import shared.model.users.UserRole;

import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author HP
 */
public class RecommendationListPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;
  UserRole userRole;

  /**
   * Creates new form RecommendationListPanel
   */
  public RecommendationListPanel(MainFrame mainFrame, Client client, UserRole userRole) {
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

    backButton = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    requestTable = new javax.swing.JTable();
    answerButton = new javax.swing.JButton();

    backButton.setText("back");
    if (!userRole.equals(UserRole.EduAssistant)) {
      backButton.setVisible(false);
    }
    backButton.addActionListener(this::backButtonActionPerformed);

    requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    requestTable.setCellSelectionEnabled(true);
    jScrollPane1.setViewportView(requestTable);

    answerButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16)); // NOI18N
    answerButton.setText("answer request");
    answerButton.addActionListener(this::answerButtonActionPerformed);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(44, 44, 44)
                                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(answerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(35, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(100, 100, 100)
                            .addComponent(answerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(45, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29))
    );
  }// </editor-fold>

  private void answerButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.AnswerRecommendationPanel, userRole);
  }

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
//  todo  mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new EduRequestPanel(mainFrame, professor)));
  }

  private void showData(String[][] data) {
    DefaultTableModel model = (DefaultTableModel) requestTable.getModel();
    String[] cols = {"request id", "student id", "name", "faculty", "grade", "average score", "passed credits"};
    model.setDataVector(data, cols);
  }

  public void update(String[][] data) {
    showData(data);
  }

  // Variables declaration - do not modify
  private javax.swing.JButton answerButton;
  private javax.swing.JButton backButton;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable requestTable;
  // End of variables declaration
}
