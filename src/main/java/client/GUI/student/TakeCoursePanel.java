package client.GUI.student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.Client;
import shared.model.PanelName;
import shared.util.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class TakeCoursePanel extends javax.swing.JPanel {
  Client client;

  /**
   * Creates new form TakeCoursePanel
   */
  public TakeCoursePanel(Client client) {
    this.client = client;
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

    jScrollPane1 = new javax.swing.JScrollPane();
    markedButton = new javax.swing.JButton();
    facultyBox = new javax.swing.JComboBox<>();
    facultyLabel = new javax.swing.JLabel();
    sortLabel = new javax.swing.JLabel();
    sortBox = new javax.swing.JComboBox<>();
    courseTable = new javax.swing.JTable();

    courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    courseTable.setCellSelectionEnabled(true);
    courseTable.setModel(new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    });
    jScrollPane1.setViewportView(courseTable);

    courseTable.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        JTable jTable = (JTable) e.getSource();
        if (jTable.getSelectedRow() < 0) {
          return;
        }
        String courseId = (String) courseTable.getModel().getValueAt(jTable.getSelectedRow(), 0);
        if (jTable.getSelectedColumn() == 4) {
          client.takeCourse(courseId);
        } else if (jTable.getSelectedColumn() == 5) {
          client.markCourse(courseId);
        }
      }
    });

    markedButton.setText(getConfig().getProperty(String.class, "markedButtonText"));
    markedButton.addActionListener(this::markedButtonActionPerformed);

    facultyLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    facultyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    facultyLabel.setText(getConfig().getProperty(String.class, "facultyLabelText1"));

    sortLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    sortLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    sortLabel.setText(getConfig().getProperty(String.class, "sortLabelText"));

    sortBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"grade", "name", "exam time"}));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(88, 88, 88)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(49, 49, 49)
                                            .addComponent(markedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(144, 144, 144)
                                            .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(facultyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(87, 87, 87)
                                            .addComponent(sortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(107, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addComponent(markedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(61, 61, 61))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGap(1, 1, 1)
                                                            .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(facultyBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(sortLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(sortBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(37, 37, 37)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(63, Short.MAX_VALUE))
    );
  }// </editor-fold>

  private void markedButtonActionPerformed(java.awt.event.ActionEvent evt) {
    client.changePanel(PanelName.MARKED_COURSE_PANEL, null);
  }

  private void showData(String[][] data) {
    String[] cols = {"id", "name", "capacity", "students", "status", "mark"};
    DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
    model.setDataVector(data, cols);
    courseTable.setModel(model);
  }

  public String getFaculty() {
    return Objects.requireNonNull(facultyBox.getSelectedItem()).toString();
  }

  public String getSort() {
    return Objects.requireNonNull(sortBox.getSelectedItem()).toString();
  }

  public void update(String[] faculties) {
    facultyBox.setModel(new javax.swing.DefaultComboBoxModel<>(faculties));
  }

  public void update(String[][] data) {
    showData(data);
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "studentConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JComboBox<String> facultyBox;
  private javax.swing.JLabel facultyLabel;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton markedButton;
  private javax.swing.JComboBox<String> sortBox;
  private javax.swing.JLabel sortLabel;
  private javax.swing.JTable courseTable;
  // End of variables declaration
}
