package GUI.student;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import client.Client;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class StudentTemporaryScoreList extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form StudentTemporaryScoreList
   */
  public StudentTemporaryScoreList(MainFrame mainFrame, Client client) {
    this.mainFrame = mainFrame;
    this.client = client;
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

    jScrollPane1 = new javax.swing.JScrollPane();
    courseTable = new javax.swing.JTable();
    submitButton = new javax.swing.JButton();

    courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    jScrollPane1.setViewportView(courseTable);
    courseTable.setModel(new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        if (column == 4) {
          return true;
        }
        return false;
      }
    });

    submitButton.setText("submit");
    submitButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addGap(34, 34, 34)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(81, 81, 81))
    );
  }// </editor-fold>

  private void showData(String[][] data) {
    DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
    String[] cols = {"id", "name", "professor", "grade", "objection", "answer", "score"};
    model.setDataVector(data, cols);
  }

  private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    for (int i = 0; i < courseTable.getModel().getRowCount(); i++) {
      client.addTemporaryScore(courseTable.getModel().getValueAt(i, 0).toString(),
              courseTable.getModel().getValueAt(i, 4)==null ? "" : courseTable.getModel().getValueAt(i, 4).toString(),
              null, null);
    }
    mainFrame.repaintFrame();
  }

  public void update(String[][] data) {
    showData(data);
  }

  // Variables declaration - do not modify
  private javax.swing.JTable courseTable;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton submitButton;
  // End of variables declaration
}
