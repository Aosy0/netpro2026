package q1;

public class NineteenOdd {
  public static void main(String args[]) {
    // TODO ここに実装
    for (int i = 1; i < 1000; i++) {
      if (i % 2 == 1) {
        if (i % 19 == 0) {
          System.out.print(i + ", ");
        }
      }
    }
  }
}