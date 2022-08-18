package shared.model.users;

import shared.model.University;

import java.util.ArrayList;
import java.util.Date;

public class Student extends User{
  private String supervisorId;
  private String enteringYear;
  private EducationalStatus status;
  private int id;
  private Grade grade = Grade.underGraduate;
  private String defendingTurn;
  private String dormitoryRequest;
  private String minor;
  private ArrayList<String> TACourses;
  private Date startTakeCourseTime;
  private Date endTakeCourseTime;

  public Student(String name, String email, String melliCode, String facultyName, String phoneNumber, String password, String lastLogIn, String supervisorId, String enteringYear, EducationalStatus status, Grade grade) {
    super(name, email, melliCode, facultyName, phoneNumber, password, lastLogIn);
    this.supervisorId = supervisorId;
    this.enteringYear = enteringYear;
    this.status = status;
    this.grade = grade;

    id = University.getInstance().getStudentId() + 1;
    University.getInstance().setStudentId(id);
  }

  public String getSupervisorId() {
    return supervisorId;
  }

  public void setSupervisorId(String supervisorId) {
    this.supervisorId = supervisorId;
  }

  public String getEnteringYear() {
    return enteringYear;
  }

  public void setEnteringYear(String enteringYear) {
    this.enteringYear = enteringYear;
  }

  public EducationalStatus getStatus() {
    return status;
  }

  public void setStatus(EducationalStatus status) {
    this.status = status;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }

  public String getDefendingTurn() {
    return defendingTurn;
  }

  public void setDefendingTurn(String defendingTurn) {
    this.defendingTurn = defendingTurn;
  }

  public String getDormitoryRequest() {
    return dormitoryRequest;
  }

  public void setDormitoryRequest(String dormitoryRequest) {
    this.dormitoryRequest = dormitoryRequest;
  }

  public String getMinor() {
    return minor;
  }

  public void setMinor(String minor) {
    this.minor = minor;
  }

  public ArrayList<String> getTACourses() {
    if (TACourses == null) {
      TACourses = new ArrayList<>();
    }
    return TACourses;
  }

  public void addTACourses(String courseId) {
    TACourses.add(courseId);
  }

  public Date getStartTakeCourseTime() {
    return startTakeCourseTime;
  }

  public void setStartTakeCourseTime(Date startTakeCourseTime) {
    this.startTakeCourseTime = startTakeCourseTime;
  }

  public Date getEndTakeCourseTime() {
    return endTakeCourseTime;
  }

  public void setEndTakeCourseTime(Date endTakeCourseTime) {
    this.endTakeCourseTime = endTakeCourseTime;
  }

  public int getId() {
    return id;
  }

  public enum EducationalStatus {
    studying,
    graduated,
    dropout
  }

  public enum Grade {
    underGraduate,
    masters,
    phd
  }
}
