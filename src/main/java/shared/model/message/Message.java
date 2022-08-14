package shared.model.message;

import shared.util.Time;

public class Message {
  private String author;
  private final boolean isFile;
  private String message;
  private byte[] file;
  private String fileName;
  private String time;

  public Message(String message) {
    isFile = false;
    this.message = message;
    setTime();
  }

  public Message(byte[] file, String fileName) {
    isFile = true;
    this.file = file;
    this.fileName = fileName;
    setTime();
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

  public String getFileName() {
    return fileName;
  }

  public String getTime() {
    return time;
  }

  public void setTime() {
    this.time = Time.getCurrentTime();
  }
}
