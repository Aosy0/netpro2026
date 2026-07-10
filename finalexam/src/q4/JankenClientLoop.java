package q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class JankenClientLoop {
  public static void main(String[] args) {
    // TODO 以下を実装すること
    try {
      Socket socket = new Socket("localhost", 5050);

      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

      Scanner scanner = new Scanner(System.in);

      while (true) {
        String message = scanner.next();
        String content = scanner.next();
        if (message.equals("q")) {
          break;
        }

        oos.writeObject(content);
        oos.flush();
        String serverHand = (String) ois.readObject();
        // String replayMsg = okaeshiWord.getWord();
        System.out.println("Response from Server: " + serverHand);

      }
      scanner.close();

      ois.close();
      oos.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}