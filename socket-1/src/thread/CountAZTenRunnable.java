package thread;

// Runnable インターフェースを実装することで、このクラスのインスタンスはスレッドとして実行可能になります。
public class CountAZTenRunnable implements Runnable {
  // main メソッドはプログラムのエントリーポイントです。
  public static void main(String[] args) {
    Thread[] threads = new Thread[26];
    // 2つの文字を初期化します。
    char c = 97; // ASCII値 97 は 'a' です
    for (int i = 0; i < 26; i++) {
      // 初期化した文字をコンソールに出力します。
      // System.out.println(c); // 出力: a
      CountAZTenRunnable ct = new CountAZTenRunnable();
      threads[i] = new Thread(ct, String.valueOf(c));
      threads[i].start();
      c = (char) (c + 1); // c に 1 を足すと次の文字になります
    }


    // CountAZTenRunnable クラスのインスタンスを作成します。


    // ct を実行する新しいスレッドを作成します。
    // Thread th = new Thread(ct);

    // スレッドを開始します。これにより、CountAZTenRunnable の run メソッドが呼び出されます。
    // th.start();

    // この try-catch ブロックは、0 から 9 までの値を 500 ミリ秒間隔で出力するループを実行します。
    try {
      for (int i = 0; i < 10; i++) {
        // System.out.println("main:i=" + i);

        // メインスレッドを 500 ミリ秒間一時停止します。
        Thread.sleep(500); // ミリ秒単位のスリープ時間
      }
    } catch (InterruptedException e) {
      // スレッドが中断された場合は、例外を出力します。
      System.err.println(e);
    }
  }

  // run メソッドは、新しいスレッドが実行するコードを含みます。
  public void run() {
    // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
    try {
      for (int i = 0; i < 10; i++) {
        System.out.println(Thread.currentThread().getName() + i);
        // System.out.println();

        // スレッドを 1000 ミリ秒間一時停止します。
        Thread.sleep(100); // ミリ秒単位のスリープ時間
      }
    } catch (InterruptedException e) {
      // スレッドが中断された場合は、例外を出力します。
      System.err.println(e);
    }
  }
}