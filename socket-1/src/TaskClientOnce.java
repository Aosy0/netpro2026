import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientOnce {
  public static void main(String arg[]) {
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.print("ポートを入力してください(5051など) → ");
      int port = scanner.nextInt();
      System.out.println("localhostの" + port + "番ポートに接続を要求します");
      Socket socket = new Socket("localhost", port);
      System.out.println("接続されました");

      System.out.println("入力された数字以下で最大の素数を計算します。");
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

      System.out.println("2以上の数字を入力してください ↓");
      String input = scanner.next();

      scanner.close();

      TaskObject number = new TaskObject();
      number.setExecNumber(Integer.parseInt(input));

      oos.writeObject(number);
      oos.flush();

      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

      TaskObject resultTask = (TaskObject) ois.readObject();

      int resultPrime = resultTask.getResult();
      System.out.println(input + "以下で最大の素数は" + resultPrime + "です。");

      ois.close();
      oos.close();
      socket.close();

    } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
    catch (BindException be) {
      be.printStackTrace();
      System.err.println("ポート番号が不正か、サーバが起動していません");
      System.err.println("サーバが起動しているか確認してください");
      System.err.println("別のポート番号を指定してください(6000など)");
    } catch (Exception e) {
      System.err.println("エラーが発生したのでプログラムを終了します");
      throw new RuntimeException(e);
    }
  }
}
