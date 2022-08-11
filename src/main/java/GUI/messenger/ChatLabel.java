package GUI.messenger;

import shared.model.message.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChatLabel extends JLabel {
  public ChatLabel(Chat chat, ChatsPanel chatsPanel) {
    setBackground(Color.lightGray);
    setOpaque(true);
    setPreferredSize(new Dimension(420, 70));
    setText(chat.getContactName() + " - " + chat.getLastMessage());
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
}
