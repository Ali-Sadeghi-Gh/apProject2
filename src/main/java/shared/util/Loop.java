package shared.util;

public class Loop {
  private final double fps;
  protected Thread thread;
  private static Loop currentLoop;
  private static Loop offlineLoop;
  private final Runnable updatable;
  private volatile boolean running;

  public Loop(double fps, Runnable updatable) {
    this.fps = fps;
    this.updatable = updatable;
    running = false;
    thread = new Thread(this::run);
  }

  public void start() {
    if (currentLoop != null) {
      currentLoop.stop();
    }
    currentLoop = this;

    running = true;
    try {
      update();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    thread.start();
  }

  public void offlineStart() {
    offlineLoop = this;
    running = true;
    try {
      update();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    thread.start();
  }

  public void stop() {
    running = false;
    if (Thread.currentThread().equals(thread)) {
      return;
    }
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void stopCurrent() {
    if (currentLoop != null) {
      currentLoop.stop();
    }
  }

  public static void stopOffline() {
    if (offlineLoop != null) {
      offlineLoop.stop();
    }
  }

  private void run() {
    long lastCycleTime = System.nanoTime();
    double nanosecondsPerUpdate = 1000000000 / fps;
    double delta = 0;
    while (running) {
      long now = System.nanoTime();
      delta += (now - lastCycleTime) * 1.0 / nanosecondsPerUpdate;
      lastCycleTime = now;
      if (delta < 1) {
        sleep((long) (nanosecondsPerUpdate * (1 - delta)));
      }
      while (running && delta >= 1) {
        try {
          update();
        } catch (Throwable throwable) {
          throwable.printStackTrace();
        }
        delta--;
      }
    }
  }

  public void update() {
    if (updatable != null) {
      updatable.run();
    }
  }

  public void sleep(long time) {
    int milliseconds = (int) ((time) / 1000000);
    int nanoseconds = (int) ((time) % 1000000);
    try {
      Thread.sleep(milliseconds, nanoseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
