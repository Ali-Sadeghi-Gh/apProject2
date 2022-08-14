package shared.util;

import shared.model.users.User;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
  public static Date convertStringToDateExam(String string) throws ParseException {
    return new SimpleDateFormat(getConfig().getProperty(String.class, "examDateFormat")).parse(string);
  }

  public static String convertDateToStringExam(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat(getConfig().getProperty(String.class, "examDateFormat"));
    return sdf.format(date);
  }

  public static Date convertStringToDate(String string) throws ParseException {
    return new SimpleDateFormat(getConfig().getProperty(String.class, "dateFormat")).parse(string);
  }

  public static String getCurrentTime() {
    SimpleDateFormat sdf = new SimpleDateFormat(getConfig().getProperty(String.class, "dateFormat"));
    return sdf.format(new Date());
  }

  public static boolean needToChangPassword(User user) {
    if (user.getLastLogIn() == null) {
      return false;
    }
    try {
      if ((convertStringToDate(getCurrentTime()).getTime() - convertStringToDate(user.getLastLogIn()).getTime())/1000 >
              getConfig().getProperty(Integer.class, "changePasswordTime")) {
        return true;
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static String getExpiration() {
    SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
    Date date = new Date(new Date().getTime() + getConfig().getProperty(Long.class, "enrollmentExpirationTime"));
    return sdf.format(date);
  }

  public static void showCurrentTime(JLabel label) {
    Thread currentTime = new Thread() {
      @Override
      public void run() {
        super.run();
        while (true) {
          label.setText("current time: " + getCurrentTime());
          try {
            sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    };
    currentTime.start();
  }

  public static String[][] sortExamTime(String[][] data) {
    for (int i = 0; i < data.length; i++) {
      for (int j = i; j < data.length; j++) {
        try {
          if (convertStringToDateExam(data[i][6]).getTime() > convertStringToDateExam(data[j][6]).getTime()) {
            String[] temp = data[i];
            data[i] = data[j];
            data[j] = temp;
          }
        } catch (Exception ignored) {}
      }
    }
    return data;
  }

  private static Config getConfig() {
    return Config.getConfig(Config.getMainConfig().getProperty(String.class, "sharedConfig"));
  }
}
