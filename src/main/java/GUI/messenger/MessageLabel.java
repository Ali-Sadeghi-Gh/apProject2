package GUI.messenger;

import shared.model.message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MessageLabel extends JLabel {
  private Message message;

  public MessageLabel(Message message) {
    this.message = message;
    setBackground(Color.lightGray);
    setOpaque(true);
    setPreferredSize(new Dimension(450, 70));
    if (message.isFile()) {
      setForeground(Color.blue);
      setText(message.getAuthor() + ": " + "File");
      addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
          JFileChooser fileChooser = new JFileChooser("C:\\Users\\HP\\Downloads");
          int response = fileChooser.showSaveDialog(null);
          if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getCurrentDirectory() + "\\" + message.getFileName());
            try {
              file.createNewFile();
            } catch (IOException exception) {
              exception.printStackTrace();
            }
            FileOutputStream fileOutputStream;
            try {
              fileOutputStream = new FileOutputStream(file);
              fileOutputStream.write(message.getFile());
              fileOutputStream.close();
            } catch (IOException exception) {
              exception.printStackTrace();
            }
          }
        }

        @Override
        public void mousePressed(MouseEvent e) {
          mouseClicked(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
          mouseClicked(e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
          setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
      });
    } else {
      setText(message.getAuthor() + ": " + message.getMessage());
    }
    setHorizontalAlignment(CENTER);
    setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
  }
}
