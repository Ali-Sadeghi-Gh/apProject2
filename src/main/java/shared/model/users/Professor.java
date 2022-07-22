package shared.model.users;

import shared.model.University;

public class Professor extends User {
  private Degree degree;
  private String roomNumber;
  private Position position = Position.professor;
  private int id;

  public Professor(String name, String email, String melliCode, String facultyName, String phoneNumber, String password, String lastLogIn, String roomNumber, Degree degree, Position position) {
    super(name, email, melliCode, facultyName, phoneNumber, password, lastLogIn);
    this.degree = degree;
    this.roomNumber = roomNumber;
    this.position = position;

    id = University.getInstance().getProfessorId() + 1;
    University.getInstance().setProfessorId(id);
  }

  public Degree getDegree() {
    return degree;
  }

  public void setDegree(Degree degree) {
    this.degree = degree;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public int getId() {
    return id;
  }

  public enum Degree {
    assistant,
    associate,
    full
  }

  public enum Position {
    professor,
    eduAssistant,
    dean
  }
}
