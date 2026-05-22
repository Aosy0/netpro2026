package thread;

public class MyThread extends Thread {
  public void run() {
    // スレッドが実行する処理を記述
    System.out.println("MyThread is running");
    System.out.println("thread 1　新しい並列処理の流れ");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("thread 2");
  }

  public static void main(String[] args) {
    // 新しいスレッドを作成して開始
    MyThread thread = new MyThread();
    thread.start();
    System.out.println("main 1　古い処理の流れ");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("main 2");

  }
}