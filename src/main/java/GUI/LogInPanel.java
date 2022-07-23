package GUI;

import client.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LogInPanel extends JPanel {
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
    logInButton = new JButton("LOG IN");
    showPass = new JCheckBox();
    idLabel = new JLabel("ID : ");
    passLabel = new JLabel("PASSWORD : ");
    captchaField = new JTextField();
    captchaLabel = new JLabel("CAPTCHA : ");
    changeCaptcha = new JButton(new ImageIcon("./src/main/resources/captchas/changeCaptcha.png"));
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
    captchaImg = new JLabel(new ImageIcon("./src/main/resources/captchas/captcha" + rand + ".png"));
    captchaImg.setBounds(mainFrame.FRAME_WIDTH / 2 - 100, mainFrame.FRAME_HEIGHT / 2, 200, 50);
    this.add(captchaImg);
  }

  private void setCaptcha() {
    remove(captchaImg);
    rand = random.nextInt(6);
    captchaImg = new JLabel(new ImageIcon("./src/main/resources/captchas/captcha" + rand + ".png"));
    captchaImg.setBounds(mainFrame.FRAME_WIDTH / 2 - 100, mainFrame.FRAME_HEIGHT / 2, 200, 50);
    this.add(captchaImg);
  }

  private void setListener() {
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
      int id;
      try {
        id = Integer.parseInt(idField.getText());
      } catch (Exception exception) {
        JOptionPane.showMessageDialog(mainFrame, "id must be number");
        return;
      }

      if (captchaField.getText().hashCode() != captchaArray[rand]) {
        JOptionPane.showMessageDialog(mainFrame, "wrong captcha input");
        setCaptcha();
        mainFrame.repaintFrame();
        return;
      }

      String password = passwordField.getText();
      client.login(id, password);
    });
  }
}
