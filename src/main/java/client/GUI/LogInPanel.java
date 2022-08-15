package client.GUI;

import client.Client;
import shared.util.Config;

import javax.swing.*;
import java.util.Random;

public class
LogInPanel extends JPanel {
  Client client;
  MainFrame mainFrame;

  JTextField idField;
  JTextField captchaField;
  JPasswordField passwordField;
  JButton logInButton;
  JCheckBox showPass;
  JLabel idLabel;
  JLabel passLabel;
  JLabel captchaLabel;
  JLabel captchaImg;
  JButton changeCaptcha;
  JButton refreshButton;
  Random random = new Random();
  int rand;
  int[] captchaArray = {1569985, 1596889, 1746776, 1629661, 1568002, 1724641};

  public LogInPanel( MainFrame mainFrame, Client client) {
    this.client = client;
    this.mainFrame = mainFrame;

    initial();
    initComp();
    alignComp();
    setListener();
    mainFrame.repaintFrame();
  }

  private void initial() {
    setSize(700, 700);
    setLayout(null);
  }

  private void initComp() {
    idField = new JTextField();
    passwordField = new JPasswordField();
    logInButton = new JButton(getConfig().getProperty(String.class, "logInButtonText"));
    showPass = new JCheckBox();
    idLabel = new JLabel(getConfig().getProperty(String.class, "idLabelText"));
    passLabel = new JLabel(getConfig().getProperty(String.class, "passLabelText"));
    captchaField = new JTextField();
    captchaLabel = new JLabel(getConfig().getProperty(String.class, "captchaLabelText"));
    changeCaptcha = new JButton(new ImageIcon(getConfig().getProperty(String.class, "changeCaptchaPath")));
    refreshButton = new JButton(getConfig().getProperty(String.class, "refreshButtonText"));
  }

  private void alignComp() {
    idField.setBounds(mainFrame.FRAME_WIDTH / 2 - 50, mainFrame.FRAME_HEIGHT / 2 - 300, 200, 50);
    idField.setHorizontalAlignment(JTextField.CENTER);
    this.add(idField);

    idLabel.setBounds(mainFrame.FRAME_WIDTH / 2 - 150, mainFrame.FRAME_HEIGHT / 2 - 300, 200, 50);
    this.add(idLabel);

    passwordField.setBounds(mainFrame.FRAME_WIDTH / 2 - 50, mainFrame.FRAME_HEIGHT / 2 - 200, 200, 50);
    passwordField.setHorizontalAlignment(JTextField.CENTER);
    this.add(passwordField);

    passLabel.setBounds(mainFrame.FRAME_WIDTH / 2 - 150, mainFrame.FRAME_HEIGHT / 2 - 200, 200, 50);
    this.add(passLabel);

    showPass.setBounds(mainFrame.FRAME_WIDTH / 2 + 200, mainFrame.FRAME_HEIGHT / 2 - 200, 50, 50);
    passwordField.setEchoChar('*');
    this.add(showPass);

    logInButton.setBounds(mainFrame.FRAME_WIDTH / 2 + 50, mainFrame.FRAME_HEIGHT / 2 + 100, 200, 75);
    this.add(logInButton);

    captchaField.setBounds(mainFrame.FRAME_WIDTH / 2 - 50, mainFrame.FRAME_HEIGHT / 2 - 100, 200, 50);
    captchaField.setHorizontalAlignment(JTextField.CENTER);
    this.add(captchaField);

    captchaLabel.setBounds(mainFrame.FRAME_WIDTH / 2 - 150, mainFrame.FRAME_HEIGHT / 2 - 100, 200, 50);
    this.add(captchaLabel);

    changeCaptcha.setBounds(mainFrame.FRAME_WIDTH / 2 + 150, mainFrame.FRAME_HEIGHT / 2, 50, 50);
    this.add(changeCaptcha);

    rand = random.nextInt(6);
    captchaImg = new JLabel(new ImageIcon(String.format(getConfig().getProperty(String.class, "captchaImgPath"), rand)));
    captchaImg.setBounds(mainFrame.FRAME_WIDTH / 2 - 100, mainFrame.FRAME_HEIGHT / 2, 200, 50);
    this.add(captchaImg);

    refreshButton.setBounds(mainFrame.FRAME_WIDTH / 2 - 100, mainFrame.FRAME_HEIGHT / 2 + 100, 100, 25);
    refreshButton.setVisible(false);
    this.add(refreshButton);

    if (!client.isConnected()) {
      refreshButton.setVisible(true);
    }
  }

  private void setCaptcha() {
    remove(captchaImg);
    rand = random.nextInt(6);
    captchaImg = new JLabel(new ImageIcon(String.format(getConfig().getProperty(String.class, "captchaImgPath"), rand)));
    captchaImg.setBounds(mainFrame.FRAME_WIDTH / 2 - 100, mainFrame.FRAME_HEIGHT / 2, 200, 50);
    this.add(captchaImg);
  }

  private void setListener() {
    refreshButton.addActionListener(e -> {
      client.refresh();
    });

    changeCaptcha.addActionListener(e -> {
      setCaptcha();
      mainFrame.repaintFrame();
    });

    showPass.addActionListener(e -> {
      if (showPass.isSelected()) {
        passwordField.setEchoChar((char) 0);
      } else {
        passwordField.setEchoChar('*');
      }
    });

    logInButton.addActionListener(e -> {
      if (!client.isConnected()) {
        refreshButton.setVisible(true);
        return;
      }

      int id;
      try {
        id = Integer.parseInt(idField.getText());
      } catch (Exception exception) {
        JOptionPane.showMessageDialog(mainFrame, getConfig().getProperty(String.class, "idNumErrorMessage"));
        return;
      }

      if (captchaField.getText().hashCode() != captchaArray[rand]) {
        JOptionPane.showMessageDialog(mainFrame, getConfig().getProperty(String.class, "wrongCaptcha"));
        setCaptcha();
        mainFrame.repaintFrame();
        return;
      }

      String password = passwordField.getText();
      client.login(String.valueOf(id), password);
    });
  }

  private Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "GUIConfig"));
  }
}
