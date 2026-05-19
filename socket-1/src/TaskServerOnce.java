import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskServerOnce {
  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    if (n <= 3) {
      return true;
    }

    // 2と3の倍数以外の奇数を確認
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }

    // 6k ± 1の形の数のみを確認
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String arg[]) {
    try {
      /* 通信の準備をする */
      Scanner scanner = new Scanner(System.in);
      System.out.print("ポートを入力してください(5051など) → ");
      int port = scanner.nextInt();
      scanner.close();
      System.out.println("localhostの" + port + "番ポートで待機します");
      ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

      Socket socket = server.accept(); // クライアントからの接続要求を待ち、
      // 要求があればソケットを取得し接続を行う
      System.out.println("接続しました。相手の入力を待っています......");

      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

      XmasPresent present = (XmasPresent) ois.readObject();// Integerクラスでキャスト。

      String msgPresent = present.getMessage();
      System.out.println("メッセージは" + msgPresent);
      String presentFromClient = present.getContent();
      System.out.println("プレゼントの内容は" + presentFromClient);

      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

      XmasPresent response = new XmasPresent();
      response.setMessage("サーバーです。メリークリスマス！\n" + presentFromClient + "ありがとう。\nプレゼントのお返しは" + times + "倍" + "です");
      response.setContent(serverProcess(presentFromClient));

      oos.writeObject(response);
      oos.flush();

      // close処理
      ois.close();
      oos.close();
      // socketの終了。
      socket.close();
      server.close();

    } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
    catch (BindException be) {
      be.printStackTrace();
      System.out.println("ポート番号が不正、ポートが使用中です");
      System.err.println("別のポート番号を指定してください(6000など)");
    } catch (Exception e) {
      System.err.println("エラーが発生したのでプログラムを終了します");
      throw new RuntimeException(e);
    }
  }

  public isPrime(int n) {
    // 素数判定のアルゴリズム
    if (execNumber <= 1) {
      result = 0;
      return;
    }
    if (execNumber <= 3) {
      result = 1;
      return;
    }

    // 2と3の倍数以外の奇数を確認
    if (execNumber % 2 == 0 || execNumber % 3 == 0) {
      result = 0;
      return;
    }

    // 6k ± 1の形の数のみを確認
    for (int i = 5; i * i <= execNumber; i += 6) {
      if (execNumber % i == 0 || execNumber % (i + 2) == 0) {
        result = 0;
        return;
      }
    }
    result = 1;
  }
}
