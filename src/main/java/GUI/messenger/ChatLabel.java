package GUI.messenger;

import client.Client;
import shared.model.message.Chat;
import shared.model.users.UserRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChatLabel extends JLabel {
  public ChatLabel(Chat chat, Client client, UserRole userRole) {
    setBackground(Color.lightGray);
    setOpaque(true);
    setPreferredSize(new Dimension(420, 70));
    setText(chat.getContactName() + " - " + chat.getLastMessage());
    setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    setHorizontalAlignment(CENTER);
    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        client.changeToMessengerPanel(userRole, chat.getContactId());
      }

      @Override
      public void mousePressed(MouseEvent e) {
        client.changeToMessengerPanel(userRole, chat.getContactId());
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
