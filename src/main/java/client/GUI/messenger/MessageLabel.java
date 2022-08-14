package client.GUI.messenger;

import shared.model.message.Message;
import shared.util.Config;

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
    setPreferredSize(new Dimension(getConfig().getProperty(Integer.class, "messageLabelWidth"),
            getConfig().getProperty(Integer.class, "messageLabelHeight")));
    if (message.isFile()) {
      setForeground(Color.blue);
      setText(String.format(getConfig().getProperty(String.class, "messagePattern"), message.getAuthor(), getConfig().getProperty(String.class, "fileName")));
      addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
          JFileChooser fileChooser = new JFileChooser(getConfig().getProperty(String.class, "fileChooserSaveDefaultDir"));
          int response = fileChooser.showSaveDialog(null);
          if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(String.format(getConfig().getProperty(String.class, "fileSavePattern"), fileChooser.getCurrentDirectory() , message.getFileName()));
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
      setText(String.format(getConfig().getProperty(String.class, "messagePattern"), message.getAuthor(), message.getMessage()));
    }
    setHorizontalAlignment(CENTER);
    setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
    JLabel timeLabel = new JLabel(message.getTime());
    timeLabel.setBounds(getConfig().getProperty(Integer.class, "timeLabelX"),
            getConfig().getProperty(Integer.class, "timeLabelY"),
            getConfig().getProperty(Integer.class, "timeLabelWidth"),
            getConfig().getProperty(Integer.class, "timeLabelHeight"));
    timeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12)); // NOI18N
    timeLabel.setHorizontalAlignment(LEFT);
    add(timeLabel);
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "messengerConfig"));
  }
}
