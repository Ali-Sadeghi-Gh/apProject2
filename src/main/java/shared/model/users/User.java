package shared.model.users;

import server.Controller;
import shared.model.message.Chat;
import shared.model.message.Messenger;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
  protected String name;
  protected String email;
  protected String melliCode;
  protected String facultyName;
  protected String phoneNumber;
  protected int password;
  protected String lastLogIn;
  protected List<String> courses;
  protected Messenger messenger;
  protected ArrayList<String> contacts;

  public User(String name, String email, String melliCode, String facultyName, String phoneNumber, String password, String lastLogIn) {
    this.name = name;
    this.email = email;
    this.melliCode = melliCode;
    this.facultyName = facultyName;
    this.phoneNumber = phoneNumber;
    this.password = password.hashCode();
    this.lastLogIn = lastLogIn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password.hashCode();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getMelliCode() {
    return melliCode;
  }

  public void setMelliCode(String melliCode) {
    this.melliCode = melliCode;
  }

  public String getFacultyName() {
    return facultyName;
  }

  public void setFacultyName(String facultyName) {
    this.facultyName = facultyName;
  }

  public String getLastLogIn() {
    return lastLogIn;
  }

  public void setLastLogIn(String lastLogIn) {
    this.lastLogIn = lastLogIn;
  }

  public List<String> getCourses() {
    return courses;
  }

  public void addCourse(String courseId) {
    if (courses == null) {
      courses = new ArrayList<>();
    }
    courses.add(courseId);
  }

  public void removeCourse(String courseId) {
    courses.remove(courseId);
  }

  public abstract int getId();

  public void setMessenger(Messenger messenger) {
    this.messenger = messenger;
  }

  public Messenger getMessenger() {
    if (messenger == null) {
      messenger = new Messenger();
    }
    if (messenger.getChat("1") == null && !(this instanceof Admin)) {
      messenger.addChat(new Chat("1", "Admin"));
    }
    return messenger;
  }

  public ArrayList<String> getContacts() {
    contacts = Controller.getInstance().getContacts(this);
    return contacts;
  }

  public void addContact(String contact) {
    getContacts().add(contact);
  }
}
