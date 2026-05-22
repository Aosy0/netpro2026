package thread;

public class SleepExample1 {
  public static void main(String[] args) {
    System.out.println("プログラム開始");

    try {
      // スレッドを 2000 ミリ秒 (2 秒間) スリープします。
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.err.println("スレッドが中断されました: " + e);
    }
    System.out.println("2 秒間スリープ後にプログラム再開しました");
  }
}