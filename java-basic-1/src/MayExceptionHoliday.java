import java.util.Arrays;
import java.util.Scanner;

public class MayExceptionHoliday {
  public static void main(String[] args) {
    Integer[] holiday = { 2, 3, 4, 5, 6, 9, 10, 16, 17, 23, 24, 30, 31 };
    Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        System.out.print("5月の何日ですか？（終了したい場合はexitと入力）：");
        String str = scanner.next();
        if (str.equals("exit")) {
          System.out.println("終了します");
          break;
        }
        int day = Integer.parseInt(str);
        if (day < 1 || day > 31) {
          System.out.println("1〜31の範囲で入力してください。");
          // continue;
        } else if (Arrays.asList(holiday).contains(day)) {
          System.out.println(day + "日はお休みです");
        } else {
          throw new NoHolidayException();
        }

      } catch (NoHolidayException e) {
        e.printStackTrace();
      }
    }
  }
}
