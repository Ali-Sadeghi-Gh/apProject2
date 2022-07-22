package shared.model;

import java.util.ArrayList;
import java.util.List;
import shared.model.users.*;

public class University {
  private static University instance;
  private List<Faculty> faculties = new ArrayList<>();
  private List<Student> students = new ArrayList<>();
  private List<Professor> professors = new ArrayList<>();
  private List<Course> courses = new ArrayList<>();
  private List<EducationalRequest> educationalRequests = new ArrayList<>();
  private List<Score> scores = new ArrayList<>();
  private List<TemporaryScore> temporaryScores = new ArrayList<>();
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

  //////////////////////////////////////////////////////////////////

  public Professor findProfessorById(int id) {
    for (Professor professor : University.getInstance().getProfessors()) {
      if (id == professor.getId()) {
        return professor;
      }
    }
    return null;
  }

  public double getAverageScoreByStudent(Student student) {
    double sumScore = 0;
    if (!findScoreByStudent(student).isEmpty()) {
      for (Score score : findScoreByStudent(student)) {
        if (convertScoreToData(score) != null) {
          sumScore += Integer.parseInt(convertScoreToData(score)[2]) * Double.parseDouble(convertScoreToData(score)[3]);
        }
      }
      int averageScore = 0;
      if (getPassCredit(student) != 0) {
        averageScore = (int) ((sumScore / getAllCredit(student)) * 100 + 0.5);
      }
      return (double) averageScore / 100;
    }
    return 0;
  }

  public List<Score> findScoreByStudent(Student student) {
    List<Score> scores = new ArrayList<>();
    for (Score score : University.getInstance().getScores()) {
      if (score.getStudentId() == student.getId()) {
        scores.add(score);
      }
    }
    return scores;
  }

  public String[] convertScoreToData(Score score) {
    String[] data = addCourseDataToScoreData(score.getCourseId());
    if (data != null) {
      data[3] = String.valueOf(score.getScore());
    }
    return data;
  }

  public int getAllCredit(Student student) {
    int credit = 0;
    for (Score score : findScoreByStudent(student)) {
      credit += Integer.parseInt(convertScoreToData(score)[2]);
    }
    return credit;
  }

  public int getPassCredit(Student student) {
    int passCredit = 0;
    for (Score score : findScoreByStudent(student)) {
      if (convertScoreToData(score) != null && score.getScore() >= 10) {
        passCredit += Integer.parseInt(convertScoreToData(score)[2]);
      }
    }
    return passCredit;
  }

  public String[] addCourseDataToScoreData(int courseId) {
    Course course = findCourse(courseId);
    if (course != null) {
      return new String[]{String.valueOf(course.getId()), course.getName(), String.valueOf(course.getCredit()), "N/A"};
    }
    return null;
  }

  public Course findCourse(int id) {
    for (Course course : University.getInstance().getCourses()) {
      if (course.getId() == id) {
        return course;
      }
    }
    return null;
  }
}