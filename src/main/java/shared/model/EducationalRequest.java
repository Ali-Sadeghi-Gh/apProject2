package shared.model;

public class EducationalRequest {
  private String studentId;
  private String professorId;
  private String faculty;
  private String targetFaculty;
  private boolean finished;
  private String professor1Result;
  private String professor2Result;
  private String result;
  private Type type;
  private int id;

  public EducationalRequest(String studentId, String professorId, String faculty, String targetFaculty, Type type) {
    this.studentId = studentId;
    this.professorId = professorId;
    this.faculty = faculty;
    this.targetFaculty = targetFaculty;
    this.type = type;
    this.finished = false;

    id = University.getInstance().getRequestId() + 1;
    University.getInstance().setRequestId(id);
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getProfessorId() {
    return professorId;
  }

  public void setProfessorId(String professorId) {
    this.professorId = professorId;
  }

  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }

  public String getTargetFaculty() {
    return targetFaculty;
  }

  public void setTargetFaculty(String targetFaculty) {
    this.targetFaculty = targetFaculty;
  }

  public boolean isFinished() {
    return finished;
  }

  public void setFinished(boolean finished) {
    this.finished = finished;
  }

  public String getFacultyResult() {
    return professor1Result;
  }

  public void setFacultyResult(String professor1Result) {
    this.professor1Result = professor1Result;
  }

  public String getTargetFacultyResult() {
    return professor2Result;
  }

  public void setTargetFacultyResult(String professor2Result) {
    this.professor2Result = professor2Result;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public enum Type {
    recommendation,
    minor,
    dropout
  }
}
