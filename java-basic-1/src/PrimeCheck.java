import java.util.ArrayList;
import java.util.List;

public class PrimeCheck {
  public static void main(String[] args) {
    int preLastDigit = 7;
    int[][] counts = new int[10][10]; // [直前の下一桁][今の下一桁] それぞれ0～9に対応するため要素数10
    for (int num = 11; num <= 100000; num++) { // 対象は 7 以上 100000 以下の素数 7はprePrimeに格納して11から始める
      boolean isPrime = true;
      if (num % 2 == 0) { // 偶数は先にリターン
        isPrime = false;
        // continue;
      }

      for (int i = 3; i <= Math.sqrt(num); i += 2) {
        if (num % i == 0) {
          isPrime = false;
          break;
        }
      }

      int lastDigit;
      if (isPrime) {
        // System.out.println(num);
        lastDigit = num % 10;
        counts[preLastDigit][lastDigit]++;
        // System.out.println(lastDigit);

        preLastDigit = lastDigit;
      }

    }

    // 結果を格納する
    List<int[]> ranking = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (counts[i][j] > 0) {
          ranking.add(new int[] { i, j, counts[i][j] });
        }
      }
    }

    ranking.sort((a, b) -> b[2] - a[2]);

    for (int i = 0; i < ranking.size(); i++) {
      int[] entry = ranking.get(i);
      System.out.printf("%d-%d : %d 回%n", entry[0], entry[1], entry[2]);
    }
  }
}
