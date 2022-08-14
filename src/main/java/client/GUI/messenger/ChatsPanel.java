package client.GUI.messenger;

import shared.model.message.Chat;
import shared.util.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ChatsPanel extends JPanel {
  MessengerPanel messengerPanel;

  public ChatsPanel(ArrayList<Chat> chats, MessengerPanel messengerPanel) {
    this.messengerPanel = messengerPanel;
    setPreferredSize(new Dimension(getConfig().getProperty(Integer.class, "chatPanelWidth"),
            chats.size() * getConfig().getProperty(Integer.class, "chatHeight") + 5));
    ArrayList<Chat> chatArrayList = new ArrayList<>(chats);
    Collections.reverse(chatArrayList);
    for (Chat chat : chatArrayList) {
      add(new ChatLabel(chat, this));
    }
  }

  public void updateMessenger(String contactId) {
    messengerPanel.updateMessenger(contactId);
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "messengerConfig"));
  }
}
