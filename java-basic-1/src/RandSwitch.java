public class RandSwitch { // 乱数発生
  public static void main(String[] args) {
    while (true) {
      System.out.print("?");
      int x = 1 + (int) ((Math.random()) * 6.0);// 0<=Math.random()<1の切り捨てのため
      System.out.println(x);

      switch (x) {
        case 1:
          System.out.println("１です");
          break; // break を書き忘れがちなので注意!
        case 6:
          System.out.println("りんご");
          break; // break を書き忘れがちなので注意!
        case 3:
          System.out.println("ばなな");
          break;
        default: // それ以外
          System.out.println("いちご");
      }
      // switch case を使って：
      // 1、6のときは りんご
      // 3のときは ばなな
      // それ以外のときは いちご を表示する
    }
  }
}