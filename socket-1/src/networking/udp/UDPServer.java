package networking.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPServer {
  public static void main(String[] args) {
    DatagramSocket socket = null;
    try {
      socket = new DatagramSocket(9876);
      byte[] receiveData = new byte[1024];
      byte[] sendData;

      while (true) {
        // 受信パケットを作成
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("受信: " + message);

        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        String serverResponse = message.toUpperCase();
        sendData = serverResponse.getBytes(StandardCharsets.UTF_8);
        // 返信をクライアントに送信
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        socket.send(sendPacket);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (socket != null && !socket.isClosed()) {
        socket.close();
      }
    }
  }
}