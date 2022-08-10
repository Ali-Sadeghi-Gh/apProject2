package shared.model.message;

import java.util.ArrayList;

public class Messenger {
  private ArrayList<Chat> chats;

  public void addChat(Chat chat) {
    chats.add(chat);
  }

  public ArrayList getChats() {
    ArrayList<Chat> chatArrayList = new ArrayList<>(chats);
    for (Chat chat : chatArrayList) {
      chat.setMessages(null);
    }
    return chatArrayList;
  }

  public Chat getChat(int contactId) {
    for (Chat chat : chats) {
      if (chat.getContactId() == contactId) {
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
