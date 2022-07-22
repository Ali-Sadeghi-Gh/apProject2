package GUI.student;

import shared.model.users.Student;

import javax.swing.*;

public class StudentEducationalOuterPanel extends JPanel {
  public StudentEducationalOuterPanel(Student student) {
    setBounds(350, 270, 800, 700);
    add(new StudentEducationalPanel(student));
  }
}
