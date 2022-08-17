package shared.util;

import shared.model.University;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import shared.model.users.MrMohseni;
import shared.model.users.Professor;
import shared.model.users.Student;
import shared.model.users.User;

public class LogIn {
  static Logger logger = LogManager.getLogger(LogIn.class);

  public static User checkUser(int id, String password) {
    for (Student student : University.getInstance().getStudents()) {
      if (student.getId() == id && student.getPassword() == password.hashCode()) {
        logger.info(String.format(getConfig().getProperty(String.class, "studentLoginLog"), id));
        return student;
      }
    }
    for (Professor professor : University.getInstance().getProfessors()) {
      if (professor.getId() == id && professor.getPassword() == password.hashCode()) {
        logger.info(String.format(getConfig().getProperty(String.class, "professorLoginLog"), id));
        return professor;
      }
    }
    if (University.getInstance().getAdmin().getId() == id && University.getInstance().getAdmin().getPassword() == password.hashCode()) {
      logger.info(getConfig().getProperty(String.class, "adminLoginLog"));
      return University.getInstance().getAdmin();
    }
    if (University.getInstance().getMrMohseni().getId() == id && University.getInstance().getMrMohseni().getPassword() == password.hashCode()) {
      logger.info(getConfig().getProperty(String.class, "mrMohseniLoginLog"));
      return University.getInstance().getMrMohseni();
    }
    return null;
  }

  private static Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "sharedConfig"));
  }
}
