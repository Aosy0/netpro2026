import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class ShiritoriTCPClient {

  public static void main(String arg[]) {
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Serverで指定したポートを入力してください(5051など) → ");
      int port = scanner.nextInt();
      System.out.println("localhostの" + port + "番ポートに接続を要求します");
      Socket socket = new Socket("localhost", port);
      System.out.println("接続されました");

      System.out.println("しりとりをします。");
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

      System.out.println("ひらがなかアルファベットで単語を入力してください。");
      String message = scanner.next();
      //System.out.println("プレゼントの内容を入力してください(例:お菓子) ↓");
      //String content = scanner.next();
      scanner.close();

      Shiritori word = new Shiritori();
      word.setMessage(message);
      //word.setContent(content);

      oos.writeObject(word);
      oos.flush();

      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

      Shiritori okaeshiWord = (Shiritori) ois.readObject();

      String replayMsg = okaeshiWord.getMessage();
      System.out.println("サーバからのメッセージは" + replayMsg);
      //String replayContent = okaeshiWord.getContent();
      //System.out.println(replayContent + "をもらいました！");

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
