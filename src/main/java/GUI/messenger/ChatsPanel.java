package GUI.messenger;

import shared.model.message.Chat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ChatsPanel extends JPanel {
  MessengerPanel messengerPanel;

  public ChatsPanel(ArrayList<Chat> chats, MessengerPanel messengerPanel) {
    this.messengerPanel = messengerPanel;
    setPreferredSize(new Dimension(440, chats.size() * 75 + 5));
    ArrayList<Chat> chatArrayList = new ArrayList<>(chats);
    Collections.reverse(chatArrayList);
    for (Chat chat : chatArrayList) {
      add(new ChatLabel(chat, this));
    }
  }

  public void updateMessenger(String contactId) {
    messengerPanel.updateMessenger(contactId);
  }
}
