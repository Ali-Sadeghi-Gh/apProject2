package shared.model;

import shared.model.users.Student;

import java.util.ArrayList;


public class Course {
  private String name;
  private int id;
  private String facultyName;
  private Student.Grade grade;
  private int credit;
  private String examTime;
  private String classTime;
  private boolean finalSubmit;
  private ArrayList<String> TAIds;
  private ArrayList<String> corequisites;
  private ArrayList<String> prerequisites;
  private int capacity;

  public Course(String name, String facultyName, Student.Grade grade, int credit, String examTime, String classTime, int capacity) {
    this.name = name;
    this.facultyName = facultyName;
    this.grade = grade;
    this.credit = credit;
    this.examTime = examTime;
    this.classTime = classTime;
    this.capacity = capacity;
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

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public boolean isFinalSubmit() {
    return finalSubmit;
  }

  public void setFinalSubmit(boolean finalSubmit) {
    this.finalSubmit = finalSubmit;
  }

  public ArrayList<String> getTAIds() {
    if (TAIds == null) {
      TAIds = new ArrayList<>();
    }
    return TAIds;
  }

  public void addTAId(String TAId) {
    if (TAIds == null) {
      TAIds = new ArrayList<>();
    }
    TAIds.add(TAId);
  }

  public ArrayList<String> getCorequisites() {
    if (corequisites == null) {
      corequisites = new ArrayList<>();
    }
    return corequisites;
  }

  public void addCorequisite(String corequisite) {
    if (corequisites == null) {
      corequisites = new ArrayList<>();
    }
    corequisites.add(corequisite);
  }

  public ArrayList<String> getPrerequisites() {
    if (prerequisites == null) {
      prerequisites = new ArrayList<>();
    }
    return prerequisites;
  }

  public void addPrerequisite(String prerequisite) {
    if (prerequisites == null) {
      prerequisites = new ArrayList<>();
    }
    prerequisites.add(prerequisite);
  }

  public int getId() {
    return id;
  }
}
