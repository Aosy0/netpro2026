import java.util.Scanner;

public class Calc2Scanner {

  public static void main(String[] args) {
    int i = 0;

    Scanner scan = new Scanner(System.in);
    while (i < 10) {// 10回繰り返す

      String str = scan.next();
      System.out.println("最初のトークンは: " + str);

      str = scan.next();
      System.out.println("次のトークンは  : " + str);
      i++;
    }
    scan.close();
  }
}