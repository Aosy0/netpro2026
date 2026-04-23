public class TheBoilingEarthEraC {
  public static void main(String[] args) {
    double[][] temperatures = new double[10][31];
    double avgTemp = 29.70; // 2017年の7月最高気温の平均は29.7℃
    double randomTemp = 0.0;
    int[] count = new int[10]; // 連続猛暑日(ペア)の回数をカウントする配列
    int year = 2017; // 年のカウンタ

    System.out.println("猛暑日連続ペア:");
    for (int i = 0; i < temperatures.length; i++) {
      for (int j = 0; j < temperatures[i].length; j++) {
        // 平均気温±5℃の範囲でランダムな気温を生成する
        randomTemp = (Math.random() * 10 - 5) + avgTemp;
        // 小数点以下2桁に丸める
        temperatures[i][j] = Math.round(randomTemp * 100) / 100.0;

        // System.out.printf("%.2f\n", temperatures[i][j]); // 小数点以下2桁表示を強制
        // 「2日連続で35.0℃以上の日(＝連続猛暑日)」を探し、その年と日付ペアを出力しなさい。年ごとの集計値（連続猛暑日(ペア)の回数）も最後に出力してください。
        if (j > 0) {  // 1日目は前日がないのでj > 0にして除外
          if (temperatures[i][j] >= 35.0 && temperatures[i][j - 1] >= 35.0) {
            System.out.printf("%d年7月%d日\t%.2f℃ と\t%d年7月%d日\t%.2f℃\n", i + 2017, j, temperatures[i][j - 1], i + 2017, j + 1, temperatures[i][j]);
            count[i]++;
          }
        }
      }
      avgTemp += 0.35; // 毎年平均気温は 0.35℃ずつ上昇するものとする
    }
    for(int x: count) {
      System.out.printf("%d年の連続猛暑日(ペア)の回数: %d\n", year, x);
      year++;
    }
  }
}