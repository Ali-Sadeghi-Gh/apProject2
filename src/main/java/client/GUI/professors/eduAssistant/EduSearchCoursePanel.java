package client.GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.GUI.MainFrame;
import client.Client;
import shared.model.PanelName;
import shared.util.Config;

import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author HP
 */
public class EduSearchCoursePanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Client client;

  /**
   * Creates new form EduSearchCoursePanel
   */
  public EduSearchCoursePanel(MainFrame mainFrame, Client client) {
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

    searchButton = new javax.swing.JButton();
    courseField = new javax.swing.JTextField();
    courseLabel = new javax.swing.JLabel();
    facultyLabel = new javax.swing.JLabel();
    creditLabel = new javax.swing.JLabel();
    gradeLabel = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    idLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    scoreTable = new javax.swing.JTable();
    professorLabel = new javax.swing.JLabel();

    searchButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    searchButton.setText(getConfig().getProperty(String.class, "searchButtonText"));
    searchButton.addActionListener(this::searchButtonActionPerformed);

    courseField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    courseLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    courseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    courseLabel.setText(getConfig().getProperty(String.class, "courseLabelText"));

    facultyLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    facultyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    creditLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    creditLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    gradeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    nameLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    idLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    scoreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
    ));
    scoreTable.setModel(new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    });
    jScrollPane1.setViewportView(scoreTable);

    professorLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    professorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGap(12, 12, 12)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(courseField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(professorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(466, 466, 466)
                                            .addComponent(creditLabel)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap())
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(62, 62, 62)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(courseField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(26, 26, 26)
                                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(59, 59, 59)
                                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(40, 40, 40)
                                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(44, 44, 44)
                                            .addComponent(professorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(creditLabel)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>

  private void showData(String[] cols, String[][] data) {
    DefaultTableModel model = (DefaultTableModel) scoreTable.getModel();
    model.setDataVector(data, cols);
  }

  private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      Integer.parseInt(courseField.getText());
    } catch (Exception e) {
      mainFrame.showMessage(getConfig().getProperty(String.class, "courseIdNumErrorMessage"));
      client.changePanel(PanelName.EDU_SEARCH_COURSE_PANEL, null);
      return;
    }

    client.searchCourseTemporary(this, courseField.getText());
    courseField.setText("");
  }

  public void update(String id, String name, String grade, String professor, String faculty, String[] cols, String[][] data) {
    idLabel.setText(String.format(getConfig().getProperty(String.class, "idLabelText1"), id));
    nameLabel.setText(String.format(getConfig().getProperty(String.class, "nameLabelText2"), name));
    gradeLabel.setText(String.format(getConfig().getProperty(String.class, "gradeLabelText"), grade));
    professorLabel.setText(String.format(getConfig().getProperty(String.class, "professorLabelText"), professor));
    facultyLabel.setText(String.format(getConfig().getProperty(String.class, "facultyLabelText"), faculty));

    showData(cols, data);
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "eduAssistantConfig"));
  }

  // Variables declaration - do not modify
  private javax.swing.JTextField courseField;
  private javax.swing.JLabel courseLabel;
  private javax.swing.JLabel creditLabel;
  private javax.swing.JLabel facultyLabel;
  private javax.swing.JLabel gradeLabel;
  private javax.swing.JLabel idLabel;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JLabel professorLabel;
  private javax.swing.JTable scoreTable;
  private javax.swing.JButton searchButton;
  // End of variables declaration
}
