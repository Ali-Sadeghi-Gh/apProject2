package GUI.messenger;

import shared.model.message.Message;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MessagesPanel extends JPanel {
  public MessagesPanel(ArrayList<Message> messages) {
    setPreferredSize(new Dimension(470, messages.size() * 75 + 5));
    ArrayList<Message> messageArrayList = new ArrayList<>(messages);
    Collections.reverse(messageArrayList);
    for (Message message : messageArrayList) {
      add(new MessageLabel(message));
    }
  }
}
