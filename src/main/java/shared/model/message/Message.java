package shared.model.message;

public class Message {
  private String author;
  private boolean isFile;
  private String message;
  private byte[] file;

  public Message(String message) {
    isFile = false;
    this.message = message;
  }

  public Message(byte[] file) {
    isFile = true;
    this.file = file;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public boolean isFile() {
    return isFile;
  }

  public String getMessage() {
    return message;
  }

  public byte[] getFile() {
    return file;
  }
}
