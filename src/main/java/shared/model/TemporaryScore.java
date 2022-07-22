package shared.model;

public class TemporaryScore {
  private int studentId;
  private int courseId;
  private double score;
  private String objection;
  private String answer;

  public TemporaryScore(int studentId, int courseId) {
    this.studentId = studentId;
    this.courseId = courseId;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public String getObjection() {
    return objection;
  }

  public void setObjection(String objection) {
    this.objection = objection;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
