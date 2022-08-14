package client.GUI.messenger;

import shared.model.message.Chat;
import shared.util.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChatLabel extends JLabel {
  public ChatLabel(Chat chat, ChatsPanel chatsPanel) {
    setBackground(Color.lightGray);
    setOpaque(true);
    setPreferredSize(new Dimension(getConfig().getProperty(Integer.class, "chatLabelWidth"),
            getConfig().getProperty(Integer.class, "chatLabelHeight")));
    setText(String.format(getConfig().getProperty(String.class, "lastMessagePattern"), chat.getContactName(), chat.getLastMessage()));
    setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    setHorizontalAlignment(CENTER);
    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        chatsPanel.updateMessenger(chat.getContactId());
      }

      @Override
      public void mousePressed(MouseEvent e) {
        chatsPanel.updateMessenger(chat.getContactId());
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        chatsPanel.updateMessenger(chat.getContactId());
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        setBackground(Color.gray);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        setBackground(Color.lightGray);
      }
    });
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "messengerConfig"));
  }
}
