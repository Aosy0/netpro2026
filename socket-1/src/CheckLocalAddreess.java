import java.net.InetAddress;

public class CheckLocalAddreess {
//ヒント　IPアドレスからホスト名を取り出すコードの一部分　以下を実装してみようmainが必要です。CheckLocalAddreess.java

// IP Address
InetAddress addr
       = InetAddress.getByName("8.8.8.8");
// Host name
System.out.println("Host name is: "
       + addr.getHostName());
// Host Address
System.out.println("Ip address is: "
       + addr.getHostAddress());
}
