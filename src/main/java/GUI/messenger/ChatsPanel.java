package GUI.messenger;

import client.Client;
import shared.model.message.Chat;
import shared.model.users.UserRole;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ChatsPanel extends JPanel {
  public ChatsPanel(ArrayList<Chat> chats, Client client , UserRole userRole) {
    ArrayList<Chat> chatArrayList = new ArrayList<>(chats);
    Collections.reverse(chatArrayList);
    setPreferredSize(new Dimension(440, chats.size() * 75 + 5));
    for (Chat chat : chatArrayList) {
      add(new ChatLabel(chat, client, userRole));
    }
  }
}
