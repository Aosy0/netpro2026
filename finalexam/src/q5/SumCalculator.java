package q5;

public class SumCalculator implements Runnable {
  private int threadNumber;

  public SumCalculator(int threadNumber) {
    this.threadNumber = threadNumber;
  }

  @Override
  public void run() {
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
      sum += i;
    }
    System.out.println("スレッド " + threadNumber + " の計算結果: " + sum);
  }

  public static void main(String[] args) {
    Thread[] threads = new Thread[50];

    // TODO 50個のスレッドを作成し, 実行する
    // スレッドを配列に追加し、それぞれのスレッドに異なる処理を割り当てる
    for (int i = 0; i < threads.length; i++) {
      final int threadNum = i + 1;
      threads[i] = new Thread(new SumCalculator(threadNum));
    }

    // すべてのスレッドを開始
    for (Thread thread : threads) {
      thread.start();
    }

    // すべてのスレッドの終了を待機
    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("すべてのスレッドが終了しました。");
  }
}