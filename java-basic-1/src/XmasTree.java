import java.util.Scanner;

public class XmasTree {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // Scannerの宣言はwhileの外に出しておく

    // input[0] = str.split(",");

    int leaf = 0, trunkWidth = 0, trunkLength = 0;
    String snow = "";

    while (true) {
      try {
        System.out.println("葉の数,幹の幅,幹の長さ,任意の文字列 を入力してください。");
        String str = scanner.next();
        String[] input = str.split(",");

        if (input[0].equals("q") || input[0].equals("e")) {
          System.out.println("終了します。");
          break;
        }

        leaf = Integer.parseInt(input[0]);
        trunkWidth = Integer.parseInt(input[1]);
        trunkLength = Integer.parseInt(input[2]);
        snow = input[3];

        // int i = 0;
        int snowCount = 0;
        // 上の部分
        for (int i = 0; i <= leaf; i++) {
          // 左側の雪
          for (snowCount = i; snowCount < leaf; snowCount++) {
            if (snowCount % 3 == 0) {
              System.out.print(snow);
            } else {
              System.out.print(" ");
            }
          }
          System.out.print(" ");
          // 葉
          for (int leafCount = 0; leafCount < i; leafCount++) {
            System.out.print("*");
            System.out.print("*");
          }
          System.out.print(" ");
          // 右側の雪
          for (snowCount = leaf; snowCount > i; snowCount--) {
            if (snowCount % 3 == 1) {
              System.out.print(snow);
            } else {
              System.out.print(" ");
            }
          }
          System.out.println("");
          // System.out.println("");
        }

        // 下の部分
        int space = (2 * leaf - trunkWidth) / 2 + 1; // 雪と余白の関係で少しオフセット
        for (int j = 0; j < trunkLength; j++) {
          for (int k = 0; k < space; k++) {
            System.out.print(" ");
          }
          for (int l = 0; l < trunkWidth; l++) {
            System.out.print("*");
          }
          System.out.println("");
        }

        System.out.println("");
      } catch (NumberFormatException e) {
        System.out.println("不正な入力です。");
        System.out.println("自然数,自然数,自然数,任意の文字 の順で入力してください。");
        // continue;
      }
    }
  }
}
