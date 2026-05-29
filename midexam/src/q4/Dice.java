package q4;

import java.util.*;

public class Dice {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int i = 0; // 試行回数

    while (true) {
      // TODO Diceを振る処理
      String input = scanner.nextLine();
      if (input.equals("exit") || input.equals("quit") || input.equals("0")) {
        System.out.println("Diceプログラムを終了します");
        break;
      }
      if (input.equals("")) {
        i++;
        int dice1 = random.nextInt(6) + 1; // 1から6の乱数
        int dice2 = random.nextInt(6) + 1; // 1から6の乱数
        int dice3 = random.nextInt(6) + 1; // 1から6の乱数
        System.out.println("Dice: " + dice1 + ", " + dice2 + ", " + dice3 + "(累計" + i + "回目)");
        if (dice1 == dice2 && dice2 == dice3) {
          System.out.println("Diceプログラムを終了します");
          break;
        }

      }
    }
    scanner.close();
  }
}