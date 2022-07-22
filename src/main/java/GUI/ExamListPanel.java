package GUI;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.Client;
import shared.model.users.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ExamListPanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;
  User user;
  /**
   * Creates new form ExamListPanel
   */
  public ExamListPanel(MainFrame mainFrame, User user) {
    this.mainFrame = mainFrame;
    this.user = user;
    setBounds(200, 270, 1100, 700);initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    examTable = new javax.swing.JTable();

    examTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    jScrollPane1.setViewportView(examTable);
    showData();

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                            .addContainerGap())
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                            .addContainerGap())
    );
  }// </editor-fold>

  private void showData() {
    DefaultTableModel model = (DefaultTableModel) examTable.getModel();
    String[] cols = {"id", "name", "credit", "professor", "faculty", "grade", "date of exam"};
//    String[][] data = Controller.getInstance().getExamListData(user);

//    if (data.length == 0) {
//      JOptionPane.showMessageDialog(mainFrame, "you have no course");
//    }
//    model.setDataVector(data, cols);
  }

  // Variables declaration - do not modify
  private javax.swing.JTable examTable;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration
}
