package q1;

public class SeatReservationMain {
  public static void main(String[] args) {
    // 5x5の座席表（0:空席、1:予約済）
    int[][] seats = {
        { 0, 1, 0, 0, 1 },
        { 1, 0, 0, 0, 0 },
        { 0, 0, 1, 0, 1 },
        { 1, 1, 0, 1, 0 },
        { 0, 0, 0, 0, 0 }
    };

    // TODO: 左右に隣り合う空席（どちらも0）のペアを見つけて出力する
    for (int i = 0; i < seats.length; i++) {
      for (int j = 0; j < seats[i].length - 1; j++) {
        if (seats[i][j] == 0 && seats[i][j + 1] == 0) {
          System.out.println("[" + i + ", " + j + "] [" + i + ", " + (j + 1) + "]");
        }
      }
    }
  }
}