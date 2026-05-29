package q2;

public class KuKu {
  public static void main(String[] args) {
    // TODO
    for (int i = 1; i <= 9; i++) {
      System.out.print("|");
      for (int j = 1; j <= 9; j++) {
        System.out.printf("%2d|", i * j);
      }
      System.out.println();
    }
  }
}