package shared.model;

import shared.model.users.Student;


public class Course {
  private String name;
  private int id;
  private String facultyName;
  private Student.Grade grade;
  private int credit;
  private String examTime;
  private String classTime;
  private boolean finalSubmit;

  public Course(String name, String facultyName, Student.Grade grade, int credit, String examTime, String classTime) {
    this.name = name;
    this.facultyName = facultyName;
    this.grade = grade;
    this.credit = credit;
    this.examTime = examTime;
    this.classTime = classTime;
    finalSubmit = false;

    id = University.getInstance().getCourseId() + 1;
    University.getInstance().setCourseId(id);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExamTime() {
    return examTime;
  }

  public void setExamTime(String examTime) {
    this.examTime = examTime;
  }

  public String getClassTime() {
    return classTime;
  }

  public void setClassTime(String classTime) {
    this.classTime = classTime;
  }

  public String getFacultyName() {
    return facultyName;
  }

  public void setFacultyName(String facultyName) {
    this.facultyName = facultyName;
  }

  public Student.Grade getGrade() {
    return grade;
  }

  public void setGrade(Student.Grade grade) {
    this.grade = grade;
  }

  public int getCredit() {
    return credit;
  }

  public void setCredit(int credit) {
    this.credit = credit;
  }

  public boolean isFinalSubmit() {
    return finalSubmit;
  }

  public void setFinalSubmit(boolean finalSubmit) {
    this.finalSubmit = finalSubmit;
  }

  public int getId() {
    return id;
  }
}
