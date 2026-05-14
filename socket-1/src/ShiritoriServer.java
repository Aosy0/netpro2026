import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ShiritoriServer {

  private static final int times = 2;

  private static String serverProcess(String content) {
    StringBuilder sb = new StringBuilder();
    sb.append("🎁");// sb.append("pz1");
    for (int i = 0; i < times; i++) {
      sb.append(content);
    }
    sb.append("🎁");// sb.append("pz2");
    String result = sb.toString();
    return result;
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
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
      WordResponse wordResponse = new WordResponse();
      char lastCharFromServer = '\0';

      while (true) {
        Shiritori word = (Shiritori) ois.readObject();// Integerクラスでキャスト。

        String wordFromClient = word.getWord();
        if (wordFromClient.equals("q")) {
          System.out.println("しりとり終了。");
          break;
        }
        System.out.println("メッセージは" + wordFromClient);
        // String wordFromClient = word.getContent();
        // System.out.println("プレゼントの内容は" + wordFromClient);

        // しりとりになってるかチェック
        if (lastCharFromServer != '\0') { // 初回（'\0'）以外はチェックする
          char clientFirstChar = wordResponse.getFirstChar(wordFromClient);
          if (clientFirstChar != lastCharFromServer) {
            Shiritori response = new Shiritori();
            response.setWord("「" + lastCharFromServer + "」から始まる言葉にしてください！");
            oos.writeObject(response);
            oos.flush();
            continue;
          }
        }

        // クライアント側の「ん」チェック
        char clientLastChar = wordResponse.getLastChar(wordFromClient);
        if (clientLastChar == 'ん') {
          Shiritori response = new Shiritori();
          response.setWord(wordFromClient + "ですね。「ん」がついたのであなたの負けです！");
          oos.writeObject(response);
          oos.flush();
          break;
        }

        String wordFromServer = wordResponse.getWord(wordFromClient);
        // System.out.println(wordFromServer);

        if (wordFromServer.contains("error")) {
          Shiritori response = new Shiritori();
          response.setWord("ひらがなの単語を入力してください。");
          oos.writeObject(response);
          oos.flush();
          continue;
        }

        // サーバー側の「ん」チェック
        char serverLastChar = wordResponse.getLastChar(wordFromServer);
        if (serverLastChar == 'ん') {
          Shiritori response = new Shiritori();
          response.setWord(wordFromClient + "ですね。次は「" + wordFromServer + "」です。「ん」がついてしまったのでサーバーの負けです...");
          oos.writeObject(response);
          oos.flush();
          break;
        }

        Shiritori response = new Shiritori();
        response.setWord(wordFromClient + " ですね。では次の言葉は、 " + wordFromServer + "です。");
        // response.setWord(serverProcess(wordFromClient));
        lastCharFromServer = serverLastChar;

        oos.writeObject(response);
        oos.flush();
      }

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
}