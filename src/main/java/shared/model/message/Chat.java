package shared.model.message;

import shared.util.Config;

import java.util.ArrayList;

public class Chat {
  private final String contactId;
  private final String contactName;
  private String lastMessage = getConfig().getProperty(String.class, "lastMessageDefault");
  private ArrayList<Message> messages;

  public Chat(String contactId, String contactName) {
    this.contactId = contactId;
    this.contactName = contactName;
  }

  public void addMessage(Message message) {
    if (messages == null) {
      messages = new ArrayList<>();
    }
    messages.add(message);
    if (message.isFile()) {
      lastMessage = getConfig().getProperty(String.class, "fileName");
    } else {
      lastMessage = message.getMessage();
    }
  }

  public ArrayList<Message> getMessages() {
    return messages;
  }

  public String getContactId() {
    return contactId;
  }

  public String getContactName() {
    return contactName;
  }

  public String getLastMessage() {
    return lastMessage;
  }

  public void setLastMessage(String lastMessage) {
    this.lastMessage = lastMessage;
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "sharedConfig"));
  }
}
