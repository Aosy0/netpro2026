package q6;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

class ItemWriteCSV {
  public static void main(String[] args) {
    // TODO プログラムを完成させる
    try {
      // FileWriterクラスのオブジェクトを生成する
      FileWriter file = new FileWriter("items.csv");
      // PrintWriterクラスのオブジェクトを生成する
      PrintWriter pw = new PrintWriter(new BufferedWriter(file));
      System.out.println("items.csvを開きました。保存を開始します。");
      LocalDateTime nowDate = LocalDateTime.now();
      System.out.println("現在時刻 : " + nowDate);
      System.out.println("商品名を入力してください");
      Scanner scanner = new Scanner(System.in);
      String name = scanner.nextLine();
      System.out.println("入力値は「" + name + "」です。");
      System.out.println("値段を入力してください");
      String price = scanner.nextLine();
      System.out.println("入力値は「" + price + "」です。");

      // ファイルに書き込む
      pw.println(nowDate + ", " + name + "," + price);
      System.out.println("items.csvに書き込みました。終了します。");

      // ファイルを閉じる
      pw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}