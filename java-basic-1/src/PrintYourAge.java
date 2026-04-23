//ユーザの現在の年齢を入力し、10年後の年齢を表示するプログラム

import java.time.LocalDateTime;
import java.util.Scanner;

public class PrintYourAge {
  public static void main(String[] args) {
    // クラスの変数を作るには、new を使う。

    // readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
    // Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX } と書く

    Scanner scan = new Scanner(System.in); // Scannerの宣言はwhileの外に出しておく
    while (true) {
      try {
        System.out.println("何歳ですか?");
        String age = scan.next();
        if (age.equals("q") || age.equals("e")) {
          System.out.println("終了します。");
          break;
        }
        int ageInt = Integer.parseInt(age);
        if (ageInt < 0 || ageInt >= 120) {
          System.out.println("0以上120未満の間の数字を入力してください。");
          continue;
        }
        System.out.println("あなたは" + ageInt + "歳ですね。");

        // 現在時刻を取得する
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        System.out.println("あなたは2030年に、" + (ageInt + (2030 - year)) + "歳ですね。");

        int birthYear = year - ageInt;
        if (birthYear >= 2019) {
          System.out.println("あなたは令和" + (birthYear - 2018) + "年生まれですね。");
        } else if (birthYear >= 1989) {
          System.out.println("あなたは平成" + (birthYear - 1988) + "年生まれですね。");
        } else if (birthYear >= 1926) {
          System.out.println("あなたは昭和" + (birthYear - 1925) + "年生まれですね。");
        } else if (birthYear >= 1912) {
          System.out.println("あなたは大正" + (birthYear - 1911) + "年生まれですね。");
        } else {
          System.out.println("あなたは明治" + (birthYear - 1867) + "年生まれですね。");
        }
        System.out.println("");
      } catch (NumberFormatException e) {
        System.out.println("数字のみを入力してください。");
      }
    }
  }
}
