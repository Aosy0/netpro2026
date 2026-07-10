package q7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleZipServer {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8088)) {
      System.out.println("サーバがポート8088で起動しました。");
      while (true) {
        try (Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

          String postalCode = in.readLine();

          // TODO クライアントから受け取った郵便番号が, ハードコードされている郵便番号と一致すれば, その郵便番号の町名を返す
          String townName;
          if (postalCode.equals("120-0034")) {
            townName = "足立区千住";
          } else if (postalCode.equals("124-0023")) {
            townName = "足立区千住曙町";
          } else if (postalCode.equals("120-0026")) {
            townName = "足立区千住旭町";
          } else if (postalCode.equals("120-0025")) {
            townName = "足立区千住旭町";
          } else if (postalCode.equals("120-0031")) {
            townName = "足立区千住大川町";
          } else if (postalCode.equals("120-0031")) {
            townName = "足立区千住河原町";
          } else if (postalCode.equals("120-0033")) {
            townName = "足立区千住寿町";
          } else if (postalCode.equals("120-0045")) {
            townName = "足立区千住桜木";
          } else if (postalCode.equals("120-0024")) {
            townName = "足立区千住関屋町";
          } else {
            townName = "不明";
          }
          System.out.println(postalCode);

          ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

          oos.writeObject("郵便番号: " + postalCode + " に対応する町名は " + townName + "です。");
          oos.flush();

        } catch (IOException e) {
          System.err.println("クライアントとの通信中にエラーが発生しました: " + e.getMessage());
        }
      }
    } catch (IOException e) {
      System.err.println("サーバの起動中にエラーが発生しました: " + e.getMessage());
    }
  }
}