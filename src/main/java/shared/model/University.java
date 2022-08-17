package shared.model;

import java.util.ArrayList;
import java.util.List;

import shared.model.users.Admin;
import shared.model.users.MrMohseni;
import shared.model.users.Professor;
import shared.model.users.Student;

public class University {
  private static University instance;
  private List<Faculty> faculties = new ArrayList<>();
  private List<Student> students = new ArrayList<>();
  private List<Professor> professors = new ArrayList<>();
  private List<Course> courses = new ArrayList<>();
  private List<EducationalRequest> educationalRequests = new ArrayList<>();
  private List<Score> scores = new ArrayList<>();
  private List<TemporaryScore> temporaryScores = new ArrayList<>();
  private Admin admin;
  private MrMohseni mrMohseni;
  private int studentId;
  private int professorId;
  private int courseId;
  private int requestId;
  private String defendingTurn;

  private University() {}

  public List<Faculty> getFaculties() {
    return faculties;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public List<Professor> getProfessors() {
    return professors;
  }

  public void addProfessor(Professor professor) {
    professors.add(professor);
  }

  public void removeProfessor(Professor professor) {
    professors.remove(professor);
  }

  public Admin getAdmin() {
    return admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public MrMohseni getMrMohseni() {
    return mrMohseni;
  }

  public void setMrMohseni(MrMohseni mrMohseni) {
    this.mrMohseni = mrMohseni;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void addCourse(Course course) {
    courses.add(course);
  }

  public void removeCourse(Course course) {
    courses.remove(course);
  }

  public List<EducationalRequest> getRequests() {
    return educationalRequests;
  }

  public void addRequest(EducationalRequest educationalRequest) {
    educationalRequests.add(educationalRequest);
  }

  public List<Score> getScores() {
    return scores;
  }

  public void addScore(Score score) {
    scores.add(score);
  }

  public List<TemporaryScore> getTemporaryScores() {
    return temporaryScores;
  }

  public void addTemporaryScores(TemporaryScore temporaryScore) {
    temporaryScores.add(temporaryScore);
  }

  public void removeTemporaryScore(TemporaryScore temporaryScore) {
    temporaryScores.remove(temporaryScore);
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getProfessorId() {
    return professorId;
  }

  public void setProfessorId(int professorId) {
    this.professorId = professorId;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public int getRequestId() {
    return requestId;
  }

  public void setRequestId(int requestId) {
    this.requestId = requestId;
  }

  public String getDefendingTurn() {
    return defendingTurn;
  }

  public void setDefendingTurn(String defendingTurn) {
    this.defendingTurn = defendingTurn;
  }

  public static University getInstance() {
    if (instance == null) {
      instance = new University();
    }
    return instance;
  }

  public static void setInstance(University university) {
    instance = university;
  }
}