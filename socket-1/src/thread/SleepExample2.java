package thread;

public class SleepExample2 implements Runnable {
  public void run() {
    try {
      for (int i = 0; i < 5; i++) {
        System.out.println("スレッドが実行中: " + i);
        // スレッドを 1000 ミリ秒 (1 秒間) スリープします。
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.err.println("スレッドが中断されました: " + e);
    }
  }

  public static void main(String[] args) {
    Thread thread = new Thread(new SleepExample2());
    thread.start();
  }
}