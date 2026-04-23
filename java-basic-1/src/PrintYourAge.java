//ユーザの現在の年齢を入力し、10年後の年齢を表示するプログラム

import java.util.Scanner;

public class PrintYourAge {
  public static void main(String[] args) {
    // クラスの変数を作るには、new を使う。

    // readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
    // Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX } と書く
    try {
      System.out.println("何歳ですか?");
      Scanner scan = new Scanner(System.in);
      String age = scan.next();
      int ageInt = Integer.parseInt(age);
      System.out.println("あなたは" + ageInt + "歳ですね。");
      System.out.println("あなたは10年後に、" + (ageInt + 10) + "歳ですね。");
    } catch (NumberFormatException e) {
      System.out.println("数字のみを入力してください。");
    }
  }
}
