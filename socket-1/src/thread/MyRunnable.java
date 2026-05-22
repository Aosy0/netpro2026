package thread;

public class MyRunnable implements Runnable {
  public void run() {
    // スレッドが実行する処理を記述
    System.out.println("MyRunnable is running");
    System.out.println("thread1");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("thread2");
  }

  public static void main(String[] args) {
    // Runnable インタフェースを実装したクラスのインスタンスを作成
    MyRunnable myRunnable = new MyRunnable();

    // 新しいスレッドを作成して開始
    Thread thread = new Thread(myRunnable);
    thread.start();
    System.out.println("main1");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("main2");
  }
}