package q8;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GoogleIpAddress {
  public static void main(String[] args) {
    String hostName = "www.google.com";

    try {
      // FIXME hostName に対応するすべてのIPアドレスを取得する

      System.out.println("ホスト名: " + hostName);
      System.out.println("IPアドレス一覧:");
      InetAddress[] addr = InetAddress.getAllByName(hostName);

      // FIXME 取得したIPアドレスを1行ずつ出力する
      for (InetAddress ip : addr) {
        System.out.println(ip.getHostAddress());
      }

    } catch (UnknownHostException e) {
      System.err.println("ホスト名の解決に失敗しました: " + e.getMessage());
    }
  }
}
