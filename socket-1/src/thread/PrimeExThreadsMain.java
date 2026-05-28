package thread;

import java.util.*;

public class PrimeExThreadsMain extends Thread {
  private int numStart;
  private int numEnd;

  public void setNumber(int numStart, int numEnd) {
    this.numStart = numStart;
    this.numEnd = numEnd;
  }

  public static void main(String[] args) {
    int numThreads = 9; // 作成するスレッドの数
    Thread[] threads = new Thread[numThreads];

    for (int i = 0; i < numThreads; i++) {
      PrimeExThreadsMain ct = new PrimeExThreadsMain();
      int start = i * 100;
      int end = (i + 1) * 100;
      ct.setNumber(start, end);
      ct.setName("th-" + i);
      threads[i] = ct;
      threads[i].start();
    }
  }

  @Deprecated
  public void run() {
    try {
      List<Integer> primes = new ArrayList<>();
      for (int n = numStart; n <= numEnd; n++) {
        if (SieveOfEratosthenes.isPrime(n)) {
          primes.add(n);
          System.out.println(getName() + ": - " + n);
        }
      }

      Thread.sleep(0);
      String primesStr = "";
      for (int prime : primes) {
        // System.out.println(prime);
        primesStr += prime + "\n";
      }
      System.out.println("-----" + numStart + " - " + numEnd + "の素数判定結果-----" + "\n" + primesStr);

    } catch (InterruptedException e) {
      System.err.println(e);
    }
  }

  public class SieveOfEratosthenes {
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

    // public static void main(String[] args) {
    // int n = 100;
    // List<Integer> primes = findPrimes(n);
    // System.out.println("Prime numbers up to " + n + ": " + primes);
    // }
  }

}
