package shared.model;

import shared.model.users.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogIn {
  static Logger logger = LogManager.getLogger(LogIn.class);

  public static User checkUser(int id, String password) {
    for (Student student : University.getInstance().getStudents()) {
      if (student.getId() == id && student.getPassword() == password.hashCode()) {
        logger.info("student " + id + " logged in");
        return student;
      }
    }
    for (Professor professor : University.getInstance().getProfessors()) {
      if (professor.getId() == id && professor.getPassword() == password.hashCode()) {
        logger.info("professor " + id + " logged in");
        return professor;
      }
    }
    return null;
  }
}
