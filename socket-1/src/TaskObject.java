import java.io.Serializable;

public class TaskObject implements Serializable, ITask {
  public String message;
  public String content;
  public int execNumber;
  public int result;

  public void setExecNumber(int x) {
    this.execNumber = x;
  }

  public void exec() {
    // int temp = execNumber;
    for (int i = execNumber; i >= 2; i--) {
      if (isPrime(i)) {
        result = i;
        return;
      }
    }
    result = 0;
  }

  public int getResult() {
    return result;
  }

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    if (n <= 3) {
      return true;
    }

    // 2と3の倍数以外の奇数を確認
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }

    // 6k ± 1の形の数のみを確認
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }

    return true;
  }
}
