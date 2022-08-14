package client.GUI;

import client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
  private final Client client;
  public int FRAME_WIDTH;
  public int FRAME_HEIGHT;

  public MainFrame(Client client) {
    this.client = client;
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] gd = ge.getScreenDevices();
    FRAME_WIDTH = gd[0].getDefaultConfiguration().getBounds().width + 30;
    FRAME_HEIGHT = gd[0].getDefaultConfiguration().getBounds().height - 45;

    initial();
    repaintFrame();
  }

  private void initial() {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] gd = ge.getScreenDevices();
    int upLeftCornerX = gd[0].getDefaultConfiguration().getBounds().x - 15;
    int upLeftCornerY = gd[0].getDefaultConfiguration().getBounds().y;

    setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    setLocation(upLeftCornerX, upLeftCornerY);
    setResizable(false);
    setVisible(true);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        client.kill();
      }
    });
  }

  public void showMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }

  public void repaintFrame() {
    revalidate();
    repaint();
  }

  @Override
  public void setContentPane(Container contentPane) {
    getRootPane().setContentPane(contentPane);
    repaintFrame();
  }
}
