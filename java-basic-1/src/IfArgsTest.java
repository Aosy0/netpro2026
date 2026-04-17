public class IfArgsTest {
  public static void main(String[] args) {
    int x = Integer.parseInt(args[0]);
    /* 以下を改造する。 **/
    if (x >= 7 && x <= 9) {
      System.out.println(x + " is Big Number");
    } else if (x >= 4 && x <= 6) {
      System.out.println(x + " is Middle Number");
    } else if (x >= 1 && x <= 3) {
      System.out.println(x + " is Small Number");
    } else {
      System.out.println("out of scope");
    }
  }// main end
}// class end