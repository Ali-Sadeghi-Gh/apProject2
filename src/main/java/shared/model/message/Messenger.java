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
    ArrayList<Chat> chatArrayList = new ArrayList<>();
    for (Chat c : chats) {
      Chat chat = new Chat(c.getContactId(), c.getContactName());
      chat.setLastMessage(c.getLastMessage());
      chatArrayList.add(chat);
    }
    return chatArrayList;
  }

  public Chat getChat(String contactId) {
    for (Chat chat : chats) {
      if (contactId.equals(chat.getContactId())) {
        takeChatUp(chat);
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