import java.util.*;

public class AverageC {
  public static void main(String[] args) {
    // まず各学生の数学テストの点数をランダムに生成する
    Map<Integer, Integer> scores = new HashMap<>();
    int sum = 0;
    for (int i = 100; i < 200; i++) {
      // student[i] = (int) Math.round(Math.random() * 100);
      scores.put(i, (int) Math.round(Math.random() * 100));
      sum += scores.get(i);
    }
    int avg = sum / scores.size();
    System.out.println("受験者数: " + scores.size());
    System.out.println("受験者全体での平均点は" + avg + "です。");
    System.out.println();

    // 合格者のフィルタリングと表示
    System.out.println("合格者の一覧は以下。");
    System.out.println("受験番号,点数");
    scores.entrySet().stream()
        .filter(score -> score.getValue() >= 80) // entrySet()で流れてきた一組のデータをフィルター
        .sorted(Map.Entry.comparingByValue()) // フィルターが終わったらソートして流す
        .forEach(sorted -> System.out.println(sorted.getKey() + "," + sorted.getValue()));
  }
}
