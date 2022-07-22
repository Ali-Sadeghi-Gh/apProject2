package GUI.student;

import client.Client;

import javax.swing.*;

public class StudentEducationalOuterPanel extends JPanel {
  private final StudentEducationalPanel studentEducationalPanel;

  public StudentEducationalOuterPanel(Client client) {
    setBounds(350, 270, 800, 700);
    studentEducationalPanel = new StudentEducationalPanel(client);
    add(studentEducationalPanel);
  }

  public void update(int credit, double averageScore, String[][] data) {
    studentEducationalPanel.update(credit, averageScore, data);
  }
}
