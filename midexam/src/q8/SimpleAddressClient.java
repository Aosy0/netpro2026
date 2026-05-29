package q8;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleAddressClient {
  public static void main(String[] args) {
    String townName = "千住旭町"; // ここを必要に応じて変更 FIXME

    try (Socket socket = new Socket("localhost", 8088);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      // FIXME サーバに町名の文字列を送信する
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

      Scanner scanner = new Scanner(System.in);
      townName = scanner.nextLine();
      scanner.close();

      oos.writeObject(townName);
      oos.flush();

      // FIXME サーバからの返信を受け取る
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

      townName = ois.readObject().toString();

      ois.close();
      oos.close();
      socket.close();

      System.out.println(townName);
    } catch (IOException e) {
      System.err.println("サーバとの通信中にエラーが発生しました: " + e.getMessage());
    } catch (Exception e) {
      System.err.println("エラーが発生したのでプログラムを終了します");
      throw new RuntimeException(e);
    }
  }
}