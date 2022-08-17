package shared.model.users;

public class Admin extends User {
  public Admin(String name, String email, String melliCode, String facultyName, String phoneNumber, String password, String lastLogIn) {
    super(name, email, melliCode, facultyName, phoneNumber, password, lastLogIn);
  }

  @Override
  public int getId() {
    return 1;
  }
}
