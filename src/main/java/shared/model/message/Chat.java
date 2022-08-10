package shared.model.message;

import java.util.ArrayList;

public class Chat {
  private int contactId;
  private String contactName;
  private String lastMessage = "chat created";
  private ArrayList<Message> messages;
  private Messenger messenger;

  public Chat(Messenger messenger, int contactId, String contactName) {
    this.contactId = contactId;
    this.contactName = contactName;
    this.messenger = messenger;
  }

  public void addMessage(Message message) {
    messages.add(message);
    if (message.isFile()) {
      lastMessage = "File";
    } else {
      lastMessage = message.getMessage();
    }
    messenger.takeChatUp(this);
  }

  public ArrayList<Message> getMessages() {
    return messages;
  }

  public void setMessages(ArrayList<Message> messages) {
    this.messages = messages;
  }

  public int getContactId() {
    return contactId;
  }

  public String getContactName() {
    return contactName;
  }

  public String getLastMessage() {
    return lastMessage;
  }
}
