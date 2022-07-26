package client.GUI.student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.Client;
import shared.util.Config;

import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author HP
 */
public class StudentEducationalPanel extends javax.swing.JPanel {
  Client client;

  /**
   * Creates new form StudentEducationalStatus
   */
  public StudentEducationalPanel(Client client) {
    this.client = client;

    setBounds(getConfig().getProperty(Integer.class, "StudentEducationalPanelX"), getConfig().getProperty(Integer.class, "StudentEducationalPanelY"),
            getConfig().getProperty(Integer.class, "StudentEducationalPanelWidth"), getConfig().getProperty(Integer.class, "StudentEducationalPanelHeight"));
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
    coursesTable = new javax.swing.JTable();
    passCreditLabel = new javax.swing.JLabel();
    averageScoreLabel = new javax.swing.JLabel();

    coursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    coursesTable.setModel(new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    });
    jScrollPane1.setViewportView(coursesTable);

    passCreditLabel.setBackground(new java.awt.Color(200, 200, 200));
    passCreditLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    passCreditLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    passCreditLabel.setOpaque(true);

    averageScoreLabel.setBackground(new java.awt.Color(200, 200, 200));
    averageScoreLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    averageScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    averageScoreLabel.setOpaque(true);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(averageScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passCreditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(37, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(167, 167, 167)
                                            .addComponent(passCreditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(77, 77, 77)
                                            .addComponent(averageScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(98, Short.MAX_VALUE))
    );
  }// </editor-fold>

  public void showData(String[][] data) {
    DefaultTableModel model = (DefaultTableModel) coursesTable.getModel();
    String[] cols = {"id", "course name", "credit", "score"};
    model.setDataVector(data, cols);
  }

  public void update(String credit, String averageScore, String[][] data) {
    passCreditLabel.setText(String.format(getConfig().getProperty(String.class, "passCreditLabelText"), credit));
    averageScoreLabel.setText(String.format(getConfig().getProperty(String.class, "averageScoreLabelText"), averageScore));
    showData(data);
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "studentConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JTable coursesTable;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel passCreditLabel;
  private javax.swing.JLabel averageScoreLabel;
  // End of variables declaration
}
