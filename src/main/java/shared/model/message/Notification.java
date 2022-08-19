package shared.model.message;

public class Notification {
  private NotificationType type;
  private String fromId;
  private String toId;
  private NotificationStatus status;

  public Notification(NotificationType type, String fromId, String toId) {
    this.type = type;
    this.fromId = fromId;
    this.toId = toId;
    status = NotificationStatus.UNDEFINED;
  }

  public NotificationType getType() {
    return type;
  }

  public void setType(NotificationType type) {
    this.type = type;
  }

  public String getFromId() {
    return fromId;
  }

  public void setFromId(String fromId) {
    this.fromId = fromId;
  }

  public String getToId() {
    return toId;
  }

  public void setToId(String toId) {
    this.toId = toId;
  }

  public NotificationStatus getStatus() {
    return status;
  }

  public void setStatus(NotificationStatus status) {
    this.status = status;
  }

  public enum NotificationType {
    MESSAGE
  }

  public enum NotificationStatus {
    ACCEPT,
    REJECT,
    UNDEFINED
  }
}
