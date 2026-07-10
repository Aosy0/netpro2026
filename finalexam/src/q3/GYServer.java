package q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GYServer {
  public static void main(String[] args) {
    int portNumber = 12345;

    try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
      System.out.println("Server started on port " + portNumber);

      while (true) {
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket);

        // TODO クライアントハンドラを起動する処理

      }
    } catch (IOException e) {
      System.err.println("Server error: " + e.getMessage());
    }
  }

  // 西暦を元号に変換するメソッド
  private static String convertToEra(int year) {
    String era = "元号範囲外";
    int gyear = 1889;

    // TODO （令和ー明治 2026-1889に対応すること 元号は元年（１年）優先 月は考慮しない）

    return era + gyear;
  }

  private static class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (
          BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter output = new PrintWriter(socket.getOutputStream(), true);) {
        String clientMessage;
        while ((clientMessage = input.readLine()) != null) {
          if (clientMessage.equalsIgnoreCase("quit")) {
            break;
          }

          // TODO 受信した西暦を元号に変換し, クライアントへ返信する
        }
      } catch (IOException e) {
        System.err.println("ClientHandler error: " + e.getMessage());
      } finally {
        try {
          socket.close();
        } catch (IOException e) {
          System.err.println("Error closing socket: " + e.getMessage());
        }
      }
    }
  }
}