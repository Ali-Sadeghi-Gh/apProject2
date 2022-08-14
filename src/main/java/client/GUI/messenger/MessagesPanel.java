package client.GUI.messenger;

import shared.model.message.Message;
import shared.util.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MessagesPanel extends JPanel {
  public MessagesPanel(ArrayList<Message> messages) {
    setPreferredSize(new Dimension(getConfig().getProperty(Integer.class, "messagePanelWidth"),
            messages.size() * getConfig().getProperty(Integer.class, "messageHeight") + 5));
    ArrayList<Message> messageArrayList = new ArrayList<>(messages);
    Collections.reverse(messageArrayList);
    for (Message message : messageArrayList) {
      add(new MessageLabel(message));
    }
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "messengerConfig"));
  }
}
