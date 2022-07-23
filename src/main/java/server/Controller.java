package server;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import shared.model.*;
import shared.model.users.*;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Controller {
  static Controller instance = new Controller();
  static Logger logger = LogManager.getLogger(Controller.class);
  static Data data = new Data();

  public static Controller getInstance() {
    return instance;
  }

  public User logIn(int id, String password) {
    return LogIn.checkUser(id, password);
  }

  public void setUserLoginTime(User user) {
    user.setLastLogIn(Time.getCurrentTime());
  }

  public void changePhoneNumber(String phoneNumber, User user) {
    user.setPhoneNumber(phoneNumber);
    logger.info("user " + user.getId() + " changed phone number to " + phoneNumber);
  }

  public void changeEmail(String email, User user) {
    user.setEmail(email);
    logger.info("user " + user.getId() + " changed email to " + email);
  }

  public void changePassword(String password, User user) {
    user.setPassword(password);
    logger.info("user " + user.getId() + " changed password to " + password.hashCode());
  }

  /////////////////////////////////////getTableData///////////////////////////////////////

  public String[][] getExamListData(User user) {
    List<String[]> data = new ArrayList<>();
    for (String string : user.getCourses()) {
      Course course = findCourse(Integer.parseInt(string));
      data.add(new String[]{String.valueOf(course.getId()), course.getName()==null ? "" : course.getName(),
              String.valueOf(course.getCredit()), findProfessorByCourse(course.getId()) == null ? "" : findProfessorByCourse(course.getId()).getName(),
              course.getFacultyName()==null ? "" : course.getFacultyName(), (course.getGrade() == null) ? "" :
              course.getGrade().name(), course.getExamTime()==null ? "" : course.getExamTime()});
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return Time.sortExamTime(dataArray);
  }

  public String[][] getScheduleData(User user) {
    List<String[]> data = new ArrayList<>();
    for (String string : user.getCourses()) {
      Course course = findCourse(Integer.parseInt(string));
      data.add(new String[]{String.valueOf(course.getId()), course.getName()==null ? "" : course.getName(),
              String.valueOf(course.getCredit()), findProfessorByCourse(course.getId()) == null ? "" :
              findProfessorByCourse(course.getId()).getName(), course.getFacultyName(), (course.getGrade() == null) ?
              "" : course.getGrade().name(), course.getClassTime()});
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getCoursesData(String faculty, String professor, String grade) {
    List<Course> courses = University.getInstance().getCourses();
    List<String[]> data = new ArrayList<>();
    for (int i = 0; i < courses.size(); i++) {
      Course course = courses.get(i);
      if ((faculty.equals("all") || faculty.equals(course.getFacultyName())) && (professor.equals("") ||
              (findProfessorByCourse(course.getId())!=null && professor.equals(findProfessorByCourse(course.getId()).getName())))
              && (grade.equals("all") || (course.getGrade() != null && grade.equals(course.getGrade().name())))) {
        data.add(new String[]{String.valueOf(course.getId()), course.getName(), String.valueOf(course.getCredit()),
                findProfessorByCourse(course.getId()) == null ? "" : findProfessorByCourse(course.getId()).getName(),
                course.getFacultyName(), (course.getGrade() == null) ? "" : course.getGrade().name(), course.getClassTime()});
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getCoursesDataByProfessor(Professor professor) {
    List<Course> courses = University.getInstance().getCourses();
    List<String[]> data = new ArrayList<>();
    for (int i = 0; i < courses.size(); i++) {
      Course course = courses.get(i);
      if (findProfessorByCourse(course.getId()) != null && professor.getName().equals(findProfessorByCourse(course.getId()).getName())
              && !course.isFinalSubmit()) {
        data.add(new String[]{String.valueOf(course.getId()), course.getName(), String.valueOf(course.getCredit()),
                course.getFacultyName(), (course.getGrade() == null) ? "" : course.getGrade().name()});
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getProfessorsData(String faculty, String name, String degree) {
    List<Professor> professors = University.getInstance().getProfessors();
    List<String[]> data = new ArrayList<>();
    for (int i = 0; i < professors.size(); i++) {
      Professor professor = professors.get(i);
      if ((faculty.equals("all") || faculty.equals(professor.getFacultyName())) && (name.equals("") || name.equals(professor.getName()))
              && (degree.equals("all") || (professor.getDegree() != null && degree.equals(professor.getDegree().name())))) {
        data.add(new String[]{String.valueOf(professor.getId()), professor.getName(), professor.getFacultyName(), professor.getEmail(),
                professor.getDegree() == null ? "" : professor.getDegree().name()});
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getScoresData(Student student) {
    List<String[]> data = new ArrayList<>();
    for (Score score : findScoreByStudent(student)) {
      data.add(convertScoreToData(score));
    }
    if (student.getCourses() != null) {
      for (int i = 0; i < student.getCourses().size(); i++) {
        data.add(addCourseDataToScoreData(Integer.parseInt(student.getCourses().get(i))));
      }
    }

    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[] convertScoreToData(Score score) {
    String[] data = addCourseDataToScoreData(score.getCourseId());
    if (data != null) {
      data[3] = String.valueOf(score.getScore());
    }
    return data;
  }

  public String[] addCourseDataToScoreData(int courseId) {
    Course course = findCourse(courseId);
    if (course != null) {
      return new String[]{String.valueOf(course.getId()), course.getName(), String.valueOf(course.getCredit()), "N/A"};
    }
    return null;
  }

  public String[] getFacultiesName() {
    String[] names = new String[University.getInstance().getFaculties().size()+1];
    names[0] = "all";
    for (int i = 0; i < University.getInstance().getFaculties().size(); i++) {
      names[i+1] = University.getInstance().getFaculties().get(i).getName();
    }
    return names;
  }

  public String[][] getRecommendationData(Professor professor, EducationalRequest.Type type) {
    List<String[]> data = new ArrayList<>();
    for (EducationalRequest request : University.getInstance().getRequests()) {
      if (request.getProfessorId()!=null && request.getProfessorId().equals(String.valueOf(professor.getId())) &&
              request.getType().equals(type) && !request.isFinished()) {
        Student student = findStudentById(Integer.parseInt(request.getStudentId()));
        data.add(new String[]{String.valueOf(request.getId()), String.valueOf(student.getId()), student.getName(),
                student.getFacultyName(), student.getGrade().name(), String.valueOf(getAverageScoreByStudent(student)), String.valueOf(getPassCredit(student))});
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getDropoutData(String facultyName, EducationalRequest.Type type) {
    List<String[]> data = new ArrayList<>();
    for (EducationalRequest request : University.getInstance().getRequests()) {
      if ((request.getFaculty()!=null && request.getFaculty().equals(facultyName) || request.getTargetFaculty()!=null &&
              request.getTargetFaculty().equals(facultyName)) && request.getType().equals(type) && !request.isFinished()) {
        Student student = findStudentById(Integer.parseInt(request.getStudentId()));
        data.add(new String[]{String.valueOf(request.getId()), String.valueOf(student.getId()), student.getName(),
                student.getGrade().name(), String.valueOf(getAverageScoreByStudent(student)),
                String.valueOf(getPassCredit(student))});
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getMinorData(String facultyName, EducationalRequest.Type type) {
    List<String[]> data = new ArrayList<>();
    for (EducationalRequest request : University.getInstance().getRequests()) {
      if ((request.getFaculty()!=null && request.getFaculty().equals(facultyName) || request.getTargetFaculty()!=null &&
              request.getTargetFaculty().equals(facultyName)) && request.getType().equals(type) && !request.isFinished()) {
        Student student = findStudentById(Integer.parseInt(request.getStudentId()));
        data.add(new String[]{String.valueOf(request.getId()), String.valueOf(student.getId()), student.getName(),
                request.getFaculty(), request.getTargetFaculty(), student.getGrade().name(),
                String.valueOf(getAverageScoreByStudent(student)), String.valueOf(getPassCredit(student))});
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getStudentsDataByCourse(Course course) {
    List<Student> students = University.getInstance().getStudents();
    List<String[]> data = new ArrayList<>();
    for (Student student : students) {
      if (student.getCourses() != null && student.getCourses().contains(String.valueOf(course.getId()))) {
        data.add(new String[]{String.valueOf(student.getId()), student.getName() == null ? "" : student.getName(),
                student.getFacultyName() == null ? "" : student.getFacultyName(), student.getGrade() == null ? "" :
                student.getGrade().name()});
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getStudentsScoreDataByCourse(Course course) {
    List<Student> students = University.getInstance().getStudents();
    List<String[]> data = new ArrayList<>();
    for (Student student : students) {
      Score score = findScore(course, student);
      if (score != null) {
        data.add(new String[]{String.valueOf(student.getId()), student.getName() == null ? "" : student.getName(),
                student.getFacultyName() == null ? "" : student.getFacultyName(), student.getGrade() == null ? "" :
                student.getGrade().name(), String.valueOf(score.getScore())});
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getStudentsTemporaryScoreDataByCourse(Course course) {
    List<Student> students = University.getInstance().getStudents();
    List<String[]> data = new ArrayList<>();
    for (Student student : students) {
      if (student.getCourses() != null && student.getCourses().contains(String.valueOf(course.getId()))) {
        TemporaryScore temporaryScore = findTemporaryScore(course, student);
        if (temporaryScore == null) {
          data.add(new String[]{String.valueOf(student.getId()), student.getName() == null ? "" : student.getName(),
                  student.getFacultyName() == null ? "" : student.getFacultyName(), student.getGrade() == null ? "" :
                  student.getGrade().name()});
        } else {
          data.add(new String[]{String.valueOf(student.getId()), student.getName() == null ? "" : student.getName(),
                  student.getFacultyName() == null ? "" : student.getFacultyName(), student.getGrade() == null ? "" :
                  student.getGrade().name(), temporaryScore.getObjection() == null ? "" : temporaryScore.getObjection(),
                  temporaryScore.getAnswer() == null ? "" : temporaryScore.getAnswer(), String.valueOf(temporaryScore.getScore())});
        }
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getAllScoresDataByProfessor(Professor professor) {
    List<String[]> data = new ArrayList<>();
    for (String string : professor.getCourses()) {
      Course course = findCourse(Integer.parseInt(string));
      if (findScoreByCourse(course).length != 0) {
        for (Score score : University.getInstance().getScores()) {
          if (score.getCourseId() == course.getId()) {
            Student student = findStudentById(score.getStudentId());
            data.add(new String[]{String.valueOf(course.getId()), course.getName()==null ? "" : course.getName(),
                    String.valueOf(student.getId()), student.getName()==null ? "" : student.getName(), "-", "-",
                    String.valueOf(score.getScore())});
          }
        }
      } else if (findTemporaryScoreByCourse(course).length != 0) {
        for (TemporaryScore temporaryScore : University.getInstance().getTemporaryScores()) {
          if (temporaryScore.getCourseId() == course.getId()) {
            Student student = findStudentById(temporaryScore.getStudentId());
            data.add(new String[]{String.valueOf(course.getId()), course.getName()==null ? "" : course.getName(),
                    String.valueOf(student.getId()), student.getName()==null ? "" : student.getName(),
                    temporaryScore.getObjection(), temporaryScore.getAnswer(), String.valueOf(temporaryScore.getScore())});
          }
        }
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  public String[][] getCourseTemporaryScoreDataByStudent(Student student) {
    List<String[]> data = new ArrayList<>();
    for (TemporaryScore temporaryScore : University.getInstance().getTemporaryScores()) {
      if (temporaryScore.getStudentId() == student.getId()) {
        Course course = findCourse(temporaryScore.getCourseId());
        Professor professor = findProfessorByCourse(course.getId());
        data.add(new String[]{String.valueOf(course.getId()), course.getName()==null ? "" : course.getName(),
                professor==null ? "" : professor.getName(), course.getGrade()==null ? "" : course.getGrade().name(),
                temporaryScore.getObjection(), temporaryScore.getAnswer(), String.valueOf(temporaryScore.getScore())});
      }
    }
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      dataArray[i] = data.get(i);
    }
    return dataArray;
  }

  ////////////////////////////////score////////////////////////////////////

  public double getAverageScoreByCourse(Course course) {
    double sumScore = 0;
    if (findScoreByCourse(course).length != 0) {
      for (Score score : findScoreByCourse(course)) {
        sumScore += score.getScore();
      }
      int averageScore = 0;
      if (getStudentsCount(course) != 0) {
        averageScore = (int) ((sumScore / getStudentsCount(course)) * 100 + 0.5);
      }
      return (double) averageScore / 100;
    }
    return 0;
  }

  public double getPassAverageScoreByCourse(Course course) {
    double sumScore = 0;
    if (findScoreByCourse(course).length != 0) {
      for (Score score : findScoreByCourse(course)) {
        if (score.getScore() >= 10) {
          sumScore += score.getScore();
        }
      }
      int averageScore = 0;
      if (getStudentsCount(course) != 0) {
        averageScore = (int) ((sumScore / getPassStudentsCount(course)) * 100 + 0.5);
      }
      return (double) averageScore / 100;
    }
    return 0;
  }

  public int getStudentsCount(Course course) {
    int counter = 0;
    for (Score score : University.getInstance().getScores()) {
      if (score.getCourseId() == course.getId()) {
        counter++;
      }
    }
    return counter;
  }

  public int getPassStudentsCount(Course course) {
    int counter = 0;
    for (Score score : University.getInstance().getScores()) {
      if (score.getCourseId() == course.getId() && score.getScore() >= 10) {
        counter++;
      }
    }
    return counter;
  }

  public int getFailStudentsCount(Course course) {
    int counter = 0;
    for (Score score : University.getInstance().getScores()) {
      if (score.getCourseId() == course.getId() && score.getScore() < 10) {
        counter++;
      }
    }
    return counter;
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

  public void setFinalScores(Course course) {
    TemporaryScore[] temporaryScores = findTemporaryScoreByCourse(course);
    for (TemporaryScore temporaryScore : temporaryScores) {
      University.getInstance().addScore(new Score(temporaryScore.getStudentId(), temporaryScore.getCourseId(), temporaryScore.getScore()));
      findStudentById(temporaryScore.getStudentId()).removeCourse(String.valueOf(temporaryScore.getCourseId()));
      University.getInstance().removeTemporaryScore(temporaryScore);
    }
    course.setFinalSubmit(true);
    logger.info("scores of course with id " + course.getId() + " finalize");
  }

  /////////////////////////////////////find sth///////////////////////////////////////

  public Course findCourse(int id) {
    for (Course course : University.getInstance().getCourses()) {
      if (course.getId() == id) {
        return course;
      }
    }
    return null;
  }

  public Professor findProfessorById(int id) {
    for (Professor professor : University.getInstance().getProfessors()) {
      if (id == professor.getId()) {
        return professor;
      }
    }
    return null;
  }

  public Professor findProfessorByCourse(int courseId) {
    for (Professor professor : University.getInstance().getProfessors()) {
      if (professor.getCourses().contains(String.valueOf(courseId))) {
        return professor;
      }
    }
    return null;
  }

  public Professor findEduAssistantByFaculty(String facultyName) {
    for (Professor professor : University.getInstance().getProfessors()) {
      if (professor.getPosition().equals(Professor.Position.eduAssistant) && facultyName.equals(professor.getFacultyName())) {
        return professor;
      }
    }
    return null;
  }

  public Student findStudentByName(String name) {
    for (Student student : University.getInstance().getStudents()) {
      if (name.equals(student.getName())) {
        return student;
      }
    }
    return null;
  }

  public Student findStudentById(int id) {
    for (Student student : University.getInstance().getStudents()) {
      if (student.getId() == id) {
        return student;
      }
    }
    return null;
  }

  public EducationalRequest findRequestByProfessor(Student student, Professor professor, EducationalRequest.Type type) {
    for (EducationalRequest request : University.getInstance().getRequests()) {
      if (request.getStudentId().equals(String.valueOf(student.getId())) && request.getProfessorId().equals(String.valueOf(professor.getId()))
              &&request.getType().equals(type)) {
        return request;
      }
    }
    return null;
  }

  public EducationalRequest findRequestByFaculty(Student student, String facultyName, EducationalRequest.Type type) {
    for (EducationalRequest request : University.getInstance().getRequests()) {
      if (request.getStudentId().equals(String.valueOf(student.getId())) && request.getFaculty()!=null &&
              request.getFaculty().equals(facultyName)
              && request.getType().equals(type)) {
        return request;
      }
    }
    return null;
  }

  public EducationalRequest findRequestById(int id) {
    for (EducationalRequest request : University.getInstance().getRequests()) {
      if (request.getId() == id) {
        return request;
      }
    }
    return null;
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

  public TemporaryScore findTemporaryScore(Course course, Student student) {
    for (TemporaryScore temporaryScore : University.getInstance().getTemporaryScores()) {
      if (temporaryScore.getStudentId() == student.getId() && temporaryScore.getCourseId() == course.getId()) {
        return temporaryScore;
      }
    }
    return null;
  }

  public Score findScore(Course course, Student student) {
    for (Score score : University.getInstance().getScores()) {
      if (score.getStudentId() == student.getId() && score.getCourseId() == course.getId()) {
        return score;
      }
    }
    return null;
  }

  public TemporaryScore[] findTemporaryScoreByCourse(Course course) {
    List<TemporaryScore> temporaryScores = new ArrayList<>();
    for (TemporaryScore temporaryScore : University.getInstance().getTemporaryScores()) {
      if (temporaryScore.getCourseId() == course.getId()) {
        temporaryScores.add(temporaryScore);
      }
    }
    TemporaryScore[] temporaryScoreArray = new TemporaryScore[temporaryScores.size()];
    for (int i = 0; i < temporaryScores.size(); i++) {
      temporaryScoreArray[i] = temporaryScores.get(i);
    }
    return temporaryScoreArray;
  }

  public Score[] findScoreByCourse(Course course) {
    List<Score> scores = new ArrayList<>();
    for (Score score : University.getInstance().getScores()) {
      if (score.getCourseId() == course.getId()) {
        scores.add(score);
      }
    }
    Score[] scoreArray = new Score[scores.size()];
    for (int i = 0; i < scores.size(); i++) {
      scoreArray[i] = scores.get(i);
    }
    return scoreArray;
  }

  ///////////////////////////////////add change remove//////////////////////////////

  public int addStudent(String name, String email, String melliCode, String facultyName, String phoneNumber, String password,
                        String supervisorId, String enteringYear, String status, String grade) {
    Student student = new Student(name, email, melliCode, facultyName, phoneNumber, password,
            null, supervisorId, enteringYear, Student.EducationalStatus.valueOf(status), Student.Grade.valueOf(grade));
    University.getInstance().addStudent(student);

    logger.info("student with id " + student.getId() + " added");
    return student.getId();
  }

  public int addCourse(String name, String facultyName, String grade, String  credit, String examTime, String classTime, String professorId) {
    Course course = new Course(name, facultyName, Student.Grade.valueOf(grade), Integer.parseInt(credit), examTime, classTime);
    University.getInstance().addCourse(course);
    findProfessorById(Integer.parseInt(professorId)).addCourse(String.valueOf(course.getId()));

    logger.info("course with id " + course.getId() + " added");
    return course.getId();
  }

  public void changeCourse(Course course, String name, String grade, String credit, String examTime, String classTime, String professorId) {
    course.setName(name);
    course.setGrade(Student.Grade.valueOf(grade));
    course.setCredit(Integer.parseInt(credit));
    course.setExamTime(examTime);
    course.setClassTime(classTime);
    if (findProfessorByCourse(course.getId()) != null) {
      findProfessorByCourse(course.getId()).removeCourse(String.valueOf(course.getId()));
    }
    findProfessorById(Integer.parseInt(professorId)).addCourse(String.valueOf(course.getId()));
    logger.info("course with id " + course.getId() + " changed");
  }

  public boolean removeCourse(int id, String facultyName) {
    Course course = findCourse(id);
    if (course != null && course.getFacultyName().equals(facultyName)) {
      University.getInstance().removeCourse(course);
      for (Professor professor : University.getInstance().getProfessors()) {
        professor.removeCourse(String.valueOf(course.getId()));
      }
      for (Student student : University.getInstance().getStudents()) {
        student.removeCourse(String.valueOf(course.getId()));
      }
      logger.info("course with id " + course.getId() + " removed");
      return true;
    }
    return false;
  }

  public int addProfessor(String name, String email, String melliCode, String facultyName, String phoneNumber, String password,
                          String roomNumber,String degree, String position) {
    Professor professor = new Professor(name, email, melliCode, facultyName, phoneNumber, password,
            null, roomNumber, Professor.Degree.valueOf(degree), Professor.Position.valueOf(position));
    University.getInstance().addProfessor(professor);

    logger.info("professor with id " + professor.getId() + " added");
    return professor.getId();
  }

  public void changeProfessor(Professor professor, String name, String email, String melliCode, String phoneNumber, String password,
                              String roomNumber,String degree, String position) {
    professor.setName(name);
    professor.setEmail(email);
    professor.setMelliCode(melliCode);
    professor.setPhoneNumber(phoneNumber);
    if (!password.equals("")) {
      professor.setPassword(password);
    }
    professor.setRoomNumber(roomNumber);
    professor.setDegree(Professor.Degree.valueOf(degree));
    professor.setPosition(Professor.Position.valueOf(position));
    logger.info("professor with id " + professor.getId() + " changed");
  }

  public boolean removeProfessor(int id, String facultyName) {
    Professor professor = findProfessorById(id);
    if (professor != null && professor.getFacultyName().equals(facultyName)) {
      University.getInstance().removeProfessor(professor);
      for (Student student : University.getInstance().getStudents()) {
        if (student.getSupervisorId()!=null && student.getSupervisorId().equals(String.valueOf(id))) {
          student.setSupervisorId(null);
        }
      }
      logger.info("professor with id " + professor.getId() + " removed");
      return true;
    }
    return false;
  }

  public EducationalRequest addRequest(String studentId, String professorId, String faculty1, String faculty2, EducationalRequest.Type type) {
    EducationalRequest request = new EducationalRequest(studentId, professorId, faculty1, faculty2, type);
    University.getInstance().addRequest(request);
    request.setResult("submitted");
    logger.info(type + " request with id " + request.getId() + " added");
    return request;
  }

  public void  addTemporaryScore(String studentId, String courseId, String objection, String answer, String score) {
    TemporaryScore temporaryScore = findTemporaryScore(findCourse(Integer.parseInt(courseId)), findStudentById(Integer.parseInt(studentId)));
    if (temporaryScore == null) {
      temporaryScore = new TemporaryScore(Integer.parseInt(studentId), Integer.parseInt(courseId));
      University.getInstance().addTemporaryScores(temporaryScore);
    }

    if (objection != null) {
      temporaryScore.setObjection(objection);
    }
    if (answer != null) {
      temporaryScore.setAnswer(answer);
    }
    if (score != null) {
      int intScore = (int) (Double.parseDouble(score) * 4 + 0.5);
      double newScore = intScore / 4d;
      temporaryScore.setScore(newScore);
    }
  }

  /////////////////////////////////////requests/////////////////////////////////////

  public String getEnrollmentString(Student student) {
    File file = new File("./src/main/resources/enrollmentCertificate.txt");
    try {
      Scanner scanner = new Scanner(file);
      String str = "";
      while (scanner.hasNext()) {
        str += scanner.nextLine();
      }
      logger.info("student whit id " + student.getId() + " request enrollment certificate");
      return String.format(str, student.getName(), student.getId(), student.getFacultyName(), Time.getExpiration());
    } catch (FileNotFoundException e) {
      logger.error("enrollmentCertificate file not found");
      return "";
    }
  }

  public String getDefendingTurn(Student student) {
    try {
      University.getInstance().setDefendingTurn(Time.convertDateToStringExam(new Date(Time
              .convertStringToDateExam(University.getInstance().getDefendingTurn()).getTime() + 1000L * 3600 * 24 * 7)));
      logger.info("student with id " + student.getId() + " request defending turn");
    } catch (Exception e) {
      logger.error("parse error in getDefendingTurn");
    }
    return University.getInstance().getDefendingTurn();
  }

  public String getDormitoryRequest(Student student) {
    logger.info("student with id " + student.getId() + " request dormitory");
    Random random = new Random();
    if (random.nextInt(2) == 0) {
      return "rejected";
    } else {
      return "accepted";
    }
  }

  public void answerRecommendation(EducationalRequest request, boolean accepted) {
    Professor professor = findProfessorById(Integer.parseInt(request.getProfessorId()));
    if (accepted) {
      Student student = findStudentById(Integer.parseInt(request.getStudentId()));
      String courses = "";
      String scores = "";
      for (Score score : findScoreByStudent(student)) {
        if (score.getScore()>=10) {
          courses = courses + ", " + findCourse(score.getCourseId()).getName();
          scores = scores + ", " + score.getScore();
        }
      }
      if (!courses.equals("")) {
        courses = courses.substring(2);
      }
      if (!scores.equals("")) {
        scores = scores.substring(2);
      }

      File file = new File("./src/main/resources/recommendation.txt");
      try {
        Scanner scanner = new Scanner(file);
        String str = "";
        while (scanner.hasNext()) {
          str += scanner.nextLine();
        }
        request.setResult(String.format(str, professor.getName(), student.getName(), student.getId(), getPassCredit(student), courses,
                getAverageScoreByStudent(student), scores));
        logger.info("professor whit id " + professor.getId() + " accept " + request.getType().name() + " request with id " + request.getId());
      } catch (FileNotFoundException e) {
        logger.error("recommendation file not found");
      }
    } else {
      request.setResult("rejected");
      logger.info("professor whit id " + professor.getId() + " reject " + request.getType().name() + " request with id " + request.getId());
    }
    request.setFinished(true);
  }

  public void answerDropout(EducationalRequest request, boolean accepted) {
    Professor professor = findEduAssistantByFaculty(request.getFaculty());
    if (accepted) {
      Student student = findStudentById(Integer.parseInt(request.getStudentId()));
      student.setStatus(Student.EducationalStatus.dropout);
      logger.info("professor whit id " + professor.getId() + " accept " + request.getType().name() + " request with id " + request.getId());
      request.setResult("accepted");
    } else {
      logger.info("professor whit id " + professor.getId() + " reject " + request.getType().name() + " request with id " + request.getId());

      request.setResult("rejected");
    }
    request.setFinished(true);
  }

  public void answerMinor(EducationalRequest request, String faculty, boolean accepted) {
    Professor professor = findEduAssistantByFaculty(faculty);
    if (accepted) {
      if (faculty.equals(request.getFaculty())) {
        request.setFacultyResult("accepted");
      } else {
        request.setTargetFacultyResult("accepted");
      }
      logger.info("professor whit id " + professor.getId() + " accept " + request.getType().name() + " request with id " + request.getId());
    } else {
      if (faculty.equals(request.getFaculty())) {
        request.setFacultyResult("rejected");
      } else {
        request.setTargetFacultyResult("rejected");
      }
      logger.info("professor whit id " + professor.getId() + " reject " + request.getType().name() + " request with id " + request.getId());

    }

    Student student = findStudentById(Integer.parseInt(request.getStudentId()));
    if ((request.getFacultyResult()!=null && request.getFacultyResult().equals("rejected")) ||
            (request.getTargetFacultyResult()!=null && request.getTargetFacultyResult().equals("rejected"))) {
      request.setResult("rejected");
      student.setMinor(request.getTargetFaculty() + " reject");
      request.setFinished(true);
      logger.info(request.getType().name() + " request with id " + request.getId() + " of student whit id " + student.getId() + " is rejected");
    } else if ((request.getFacultyResult()!=null && request.getFacultyResult().equals("accepted")) &&
            (request.getTargetFacultyResult()!=null && request.getTargetFacultyResult().equals("accepted"))) {
      request.setResult("your minor request for " + request.getTargetFaculty() + " is accepted");
      student.setMinor(request.getTargetFaculty() + " accept");
      logger.info(request.getType().name() + " request with id " + request.getId() + " of student whit id " + student.getId() + " is accepted");
      request.setFinished(true);
    }
  }

  ///////////////////////////////////////program/////////////////////////////////////////////

  public void startProgram() {
    logger.info("Application started");
    try {
      data.loadData();
    } catch (Exception e) {
      logger.error("can't load data");
    }
  }

  public void saveData() {
    try {
      data.saveData(University.getInstance());
    } catch (Exception e) {
      logger.error("can't save data");
    }
    logger.info("a client closed window");
  }
}