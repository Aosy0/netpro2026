package q8;

import java.io.*;
import java.net.*;

public class SimpleAddressServer {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8088)) {
      System.out.println("サーバがポート8088で起動しました。");
      while (true) {
        try (Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

          String townName = in.readLine();
          String postalCode;

          ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
          // TODO クライアントから受け取った町名が, ハードコードされている町名と一致すれば, その町名の郵便番号を返す
          if (townName.equals("千住曙町")) {
            postalCode = "120-0023";
          } else if (townName.equals("千住旭町")) {
            postalCode = "120-0026";
          } else if (townName.equals("千住東")) {
            postalCode = "120-0025";
          } else if (townName.equals("千住大川町")) {
            postalCode = "120-0024";
          } else if (townName.equals("千住関屋町")) {
            postalCode = "120-0022";
          } else if (townName.equals("千住宮元町")) {
            postalCode = "120-0021";
          } else if (townName.equals("千住仲町")) {
            postalCode = "120-0032";
          } else if (townName.equals("千住橋戸町")) {
            postalCode = "120-0033";
          } else if (townName.equals("千住緑町")) {
            postalCode = "120-0034";
          } else {
            postalCode = "不明";
          }
          System.out.println(postalCode);

          ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

          oos.writeObject("町名: " + townName + " の郵便番号は " + postalCode + "です。");
          oos.flush();

          // close処理
          ois.close();
          oos.close();
          // socketの終了。
          clientSocket.close();
          serverSocket.close();
        } catch (IOException e) {
          System.err.println("クライアントとの通信中にエラーが発生しました: " + e.getMessage());
        }
      }
    } catch (IOException e) {
      System.err.println("サーバの起動中にエラーが発生しました: " + e.getMessage());
    }
  }
}