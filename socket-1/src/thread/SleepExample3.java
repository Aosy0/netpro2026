package thread;

public class SleepExample3 {
  public static void main(String[] args) {
    // スレッド1: 500 ミリ秒ごとにメッセージを出力
    Thread thread1 = new Thread(() -> {
      try {
        for (int i = 0; i < 5; i++) {
          System.out.println("スレッド1が実行中: " + i);
          Thread.sleep(500); // 500 ミリ秒スリープ
        }
      } catch (InterruptedException e) {
        System.err.println("スレッド1が中断されました: " + e);
      }
    });

    // スレッド2: 1000 ミリ秒ごとにメッセージを出力
    Thread thread2 = new Thread(() -> {
      try {
        for (int i = 0; i < 5; i++) {
          System.out.println("スレッド2が実行中: " + i);
          Thread.sleep(1000); // 1000 ミリ秒スリープ
        }
      } catch (InterruptedException e) {
        System.err.println("スレッド2が中断されました: " + e);
      }
    });

    // スレッドを開始
    thread1.start();
    thread2.start();
  }
}