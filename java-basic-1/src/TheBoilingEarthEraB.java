public class TheBoilingEarthEraB {
  public static void main(String[] args) {
    double[][] temperatures = new double[10][31];
    double avgTemp = 29.70; // 2017年の7月最高気温の平均は29.7℃
    double randomTemp = 0.0;
    System.out.println("真夏日連続ペア:");
    for (int i = 0; i < temperatures.length; i++) {
      for (int j = 0; j < temperatures[i].length; j++) {
        // 平均気温±5℃の範囲でランダムな気温を生成する
        randomTemp = (Math.random() * 10 - 5) + avgTemp;
        // 小数点以下2桁に丸める
        temperatures[i][j] = Math.round(randomTemp * 100) / 100.0;

        // System.out.printf("%.2f\n", temperatures[i][j]); // 小数点以下2桁表示を強制
        if (i == 9 && j > 0) { // 2026年において、「2日連続で最高気温が30.0℃以上の日（=真夏日）」が存在したら、その日付ペアをすべて出力しなさい。
          if (temperatures[i][j] >= 30.0 && temperatures[i][j - 1] >= 30.0) {
            System.out.printf("2026年7月%d日\t%.2f℃ と\t2026年7月%d日\t%.2f℃\n", j, temperatures[i][j - 1], j + 1, temperatures[i][j]);
          }
        }
      }
      avgTemp += 0.35; // 毎年平均気温は 0.35℃ずつ上昇するものとする
    }
  }
}
