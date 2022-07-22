package GUI.professors.eduAssistant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.MainFrame;
import shared.model.*;
import shared.model.users.Professor;
import shared.model.users.Student;

import javax.swing.*;
import java.util.Date;

/**
 *
 * @author HP
 */
public class ChangeCoursePanel extends javax.swing.JPanel {
  MainFrame mainFrame;
  Professor professor;
  Course changingCourse = null;

  /**
   * Creates new form ChangeCoursePanel
   */
  public ChangeCoursePanel(MainFrame mainFrame, Professor professor) {
    this.professor = professor;
    this.mainFrame = mainFrame;
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

    jLabel2 = new javax.swing.JLabel();
    examYearField = new javax.swing.JTextField();
    examDayField = new javax.swing.JTextField();
    gradeLabel = new javax.swing.JLabel();
    examTimeLabel = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    examDateLabel = new javax.swing.JLabel();
    examHourField = new javax.swing.JTextField();
    nameField = new javax.swing.JTextField();
    backButton = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    professorField = new javax.swing.JTextField();
    classTimeField = new javax.swing.JTextField();
    examMinuteField = new javax.swing.JTextField();
    creditField = new javax.swing.JTextField();
    classTimeLabel = new javax.swing.JLabel();
    professorLabel = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    creditLabel = new javax.swing.JLabel();
    changeButton = new javax.swing.JButton();
    examMonthField = new javax.swing.JTextField();
    gradeBox = new javax.swing.JComboBox<>();
    idField = new javax.swing.JTextField();
    idLabel = new javax.swing.JLabel();
    findButton = new javax.swing.JButton();

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("/");

    examYearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examMonthField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examDayField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examHourField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    examMinuteField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    gradeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gradeLabel.setText("grade:");

    examTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    examTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    examTimeLabel.setText("exam time:");

    nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setText("name:");

    examDateLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    examDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    examDateLabel.setText("exam date:");

    nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    backButton.setText("back");
    backButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backButtonActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel3.setText(":");

    professorField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    classTimeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    creditField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    classTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    classTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    classTimeLabel.setText("class time:");

    professorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    professorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    professorLabel.setText("professor id:");

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel1.setText("/");

    creditLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    creditLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    creditLabel.setText("credit:");

    changeButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    changeButton.setText("change");
    changeButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changeButtonActionPerformed(evt);
      }
    });

    gradeBox.setMaximumRowCount(10);
    gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"none"}));

    idField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    idLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    idLabel.setText("id:");

    findButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    findButton.setText("find");
    findButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(214, 214, 214)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(professorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(gradeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(creditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(creditField)
                                    .addComponent(gradeBox, 0, 171, Short.MAX_VALUE)
                                    .addComponent(professorField, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                            .addGap(62, 62, 62)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(classTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(classTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(examDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(examTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addGap(44, 44, 44)
                                                                            .addComponent(examYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(jLabel1)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(examMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(jLabel2)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(examDayField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGroup(layout.createSequentialGroup()
                                                                            .addGap(53, 53, 53)
                                                                            .addComponent(examHourField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(jLabel3)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(examMinuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGap(127, 127, 127))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(169, 169, 169))))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(444, 444, 444))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(336, 336, 336))))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(classTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(classTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(examDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examDayField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(professorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(professorField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(examTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examHourField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examMinuteField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(creditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(creditField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(gradeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(96, 96, 96))
    );
  }// </editor-fold>

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
//  todo  mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new CoursesListEduPanel(mainFrame,professor)));
    mainFrame.repaintFrame();
  }

  private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (nameField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "name can't be empty");
      return;
    }
    if (professorField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "professor id can't be empty");
      return;
    }
    if (creditField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "credit can't be empty");
      return;
    }
    if (classTimeField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "class time can't be empty");
      return;
    }
    if (examYearField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "exam year can't be empty");
      return;
    }
    if (examMonthField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "exam month can't be empty");
      return;
    }
    if (examDayField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "exam day can't be empty");
      return;
    }
    if (examHourField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "exam hour can't be empty");
      return;
    }
    if (examMinuteField.getText().equals("")) {
      JOptionPane.showMessageDialog(mainFrame, "exam minute can't be empty");
      return;
    }

    try {
      Integer.parseInt(professorField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "professor id must be a number");
      return;
    }
//    if (Controller.getInstance().findProfessorById(Integer.parseInt(professorField.getText())) == null) {
//      JOptionPane.showMessageDialog(mainFrame, "professor not found");
//      return;
//    }
    try {
      Integer.parseInt(creditField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "credit must be a number");
      return;
    }
    try {
      Integer.parseInt(examYearField.getText());
      Integer.parseInt(examMonthField.getText());
      Integer.parseInt(examDayField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "exam date must be a number");
      return;
    }
    try {
      Integer.parseInt(examHourField.getText());
      Integer.parseInt(examMinuteField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "exam time must be a number");
      return;
    }
    if (Integer.parseInt(examMonthField.getText())<0 || Integer.parseInt(examMonthField.getText())>12) {
      JOptionPane.showMessageDialog(mainFrame, "invalid exam month");
      return;
    }
    if (Integer.parseInt(examDayField.getText())<0 || Integer.parseInt(examDayField.getText())>31) {
      JOptionPane.showMessageDialog(mainFrame, "invalid exam day");
      return;
    }
    if (Integer.parseInt(examHourField.getText())<0 || Integer.parseInt(examHourField.getText())>23) {
      JOptionPane.showMessageDialog(mainFrame, "invalid exam hour");
      return;
    }
    if (Integer.parseInt(examMinuteField.getText())<0 || Integer.parseInt(examMinuteField.getText())>59) {
      JOptionPane.showMessageDialog(mainFrame, "invalid exam minute");
      return;
    }
    Date examDate;
    try {
      examDate = Time.convertStringToDateExam(examYearField.getText() + "/" + examMonthField.getText() + "/" +
              examDayField.getText() + " " + examHourField.getText() + ":" + examMinuteField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "invalid exam Date or time");
      return;
    }

//    Controller.getInstance().changeCourse(changingCourse, nameField.getText(), gradeBox.getSelectedItem().toString(),
//            creditField.getText(), Time.convertDateToStringExam(examDate), classTimeField.getText(), professorField.getText());

    JOptionPane.showMessageDialog(mainFrame, "course's information changed");
// todo   mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new ChangeCoursePanel(mainFrame, professor)));
    mainFrame.repaintFrame();
  }

  private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      Integer.parseInt(idField.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainFrame, "course id must be a number");
//   todo   mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new ChangeCoursePanel(mainFrame, professor)));
      mainFrame.repaintFrame();
      return;
    }
//    changingCourse = Controller.getInstance().findCourse(Integer.parseInt(idField.getText()));

    idField.setText("");
    if (changingCourse == null || !changingCourse.getFacultyName().equals(professor.getFacultyName())) {
//   todo   mainFrame.setContentPane(new EduAssistantPanel(mainFrame, professor, new ChangeCoursePanel(mainFrame, professor)));
      mainFrame.repaintFrame();
      JOptionPane.showMessageDialog(mainFrame, "course not found");
      return;
    }

    nameField.setText(changingCourse.getName()==null ? "" : changingCourse.getName());
//    professorField.setText(Controller.getInstance().findProfessorByCourse(changingCourse.getId())==null ?
//            "" : String.valueOf(Controller.getInstance().findProfessorByCourse(changingCourse.getId()).getId()));
    creditField.setText(String.valueOf(changingCourse.getCredit()));
    classTimeField.setText(changingCourse.getClassTime()==null ? "" : changingCourse.getClassTime());

    if (changingCourse.getExamTime() != null) {
      String[] exam = changingCourse.getExamTime().split(" ");
      String[] examDate = exam[0].split("/");
      String[] examTime = exam[1].split(":");
      examYearField.setText(examDate[0]);
      examMonthField.setText(examDate[1]);
      examDayField.setText(examDate[2]);
      examHourField.setText(examTime[0]);
      examMinuteField.setText(examTime[1]);
    } else {
      examYearField.setText("");
      examMonthField.setText("");
      examDayField.setText("");
      examHourField.setText("");
      examMinuteField.setText("");
    }

    if (changingCourse.getGrade() == null || changingCourse.getGrade().equals(Student.Grade.underGraduate)) {
      gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {Student.Grade.underGraduate.name(), Student.Grade.masters.name(), Student.Grade.phd.name()}));
    } else if (changingCourse.getGrade().equals(Student.Grade.masters)) {
      gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {Student.Grade.masters.name(), Student.Grade.phd.name(), Student.Grade.underGraduate.name()}));
    } else {
      gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {Student.Grade.phd.name(), Student.Grade.underGraduate.name(), Student.Grade.masters.name()}));
    }
  }


  // Variables declaration - do not modify
  private javax.swing.JButton backButton;
  private javax.swing.JButton changeButton;
  private javax.swing.JTextField classTimeField;
  private javax.swing.JLabel classTimeLabel;
  private javax.swing.JTextField creditField;
  private javax.swing.JLabel creditLabel;
  private javax.swing.JLabel examDateLabel;
  private javax.swing.JTextField examDayField;
  private javax.swing.JTextField examHourField;
  private javax.swing.JTextField examMinuteField;
  private javax.swing.JTextField examMonthField;
  private javax.swing.JLabel examTimeLabel;
  private javax.swing.JTextField examYearField;
  private javax.swing.JButton findButton;
  private javax.swing.JComboBox<String> gradeBox;
  private javax.swing.JLabel gradeLabel;
  private javax.swing.JLabel idLabel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField nameField;
  private javax.swing.JTextField idField;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField professorField;
  private javax.swing.JLabel professorLabel;
  // End of variables declaration
}
