package shared.model.message;

import java.util.ArrayList;

public class Chat {
  private String contactId;
  private String contactName;
  private String lastMessage = "chat created";
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
      lastMessage = "File";
    } else {
      lastMessage = message.getMessage();
    }
  }

  public ArrayList<Message> getMessages() {
    return messages;
  }

  public void setMessages(ArrayList<Message> messages) {
    this.messages = messages;
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
}
