package client.GUI.student;

import client.Client;
import shared.util.Config;

import javax.swing.*;

public class StudentEducationalOuterPanel extends JPanel {
  private final StudentEducationalPanel studentEducationalPanel;

  public StudentEducationalOuterPanel(Client client) {
    setBounds(getConfig().getProperty(Integer.class, "panelX"), getConfig().getProperty(Integer.class, "panelY"),
            getConfig().getProperty(Integer.class, "panelWidth"), getConfig().getProperty(Integer.class, "panelHeight"));
    studentEducationalPanel = new StudentEducationalPanel(client);
    add(studentEducationalPanel);
  }

  public void update(String credit, String averageScore, String[][] data) {
    studentEducationalPanel.update(credit, averageScore, data);
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "studentConfig"));
  }
}
