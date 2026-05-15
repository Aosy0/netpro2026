package networking.inet;

public class SingletonTest {
  private static SingletonTest singletonTest = new SingletonTest();
  private int value = 100;

  public static void main(String[] args) {
    new SingletonTest();
  }

  private SingletonTest() {
    // 逆に逆にプラベート
  }

  public static SingletonTest getSingletonTest() {
    if (singletonTest == null)
      singletonTest = new SingletonTest();

    return singletonTest;
  }

  public int getValue() {
    return value;
  }

}