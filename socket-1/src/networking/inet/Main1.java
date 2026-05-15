package networking.inet;

public class Main1 {
  public static void main(String[] args) {
    SingletonTest singletonTest = SingletonTest.getSingletonTest();
    System.out.println(singletonTest.getValue());

  }

}