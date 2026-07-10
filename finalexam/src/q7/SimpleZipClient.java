package q7;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleZipClient {
  public static void main(String[] args) {
    String postalCode = "120-0026"; // ここを必要に応じて変更 FIXME

    try (Socket socket = new Socket("localhost", 8088);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      // FIXME サーバに郵便番号の文字列を送信する
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

      Scanner scanner = new Scanner(System.in);
      postalCode = scanner.nextLine();
      scanner.close();

      oos.writeObject(postalCode);
      oos.flush();

      // FIXME サーバからの返信を受け取る
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

      townName = ois.readObject().toString();

      ois.close();
      oos.close();
      socket.close();

      System.out.println(townName);

      System.out.println("郵便番号: " + postalCode + "の町名は " + townName + " です。");
    } catch (IOException e) {
      System.err.println("サーバとの通信中にエラーが発生しました: " + e.getMessage());
    }
  }
}