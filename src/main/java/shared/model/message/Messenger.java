package shared.model.message;

import java.util.ArrayList;

public class Messenger {
  private ArrayList<Chat> chats;

  public void addChat(Chat chat) {
    if (chats == null) {
      chats = new ArrayList<>();
    }
    chats.add(chat);
  }

  public ArrayList<Chat> getChats() {
    if (chats == null) {
      chats = new ArrayList<>();
    }
    return chats;
  }

  public Chat getChat(String contactId) {
    if (chats == null) {
      chats = new ArrayList<>();
    }
    for (Chat chat : chats) {
      if (contactId.equals(chat.getContactId())) {
        return chat;
      }
    }
    return null;
  }

  public void takeChatUp(Chat chat) {
    chats.remove(chat);
    chats.add(chat);
  }
}
