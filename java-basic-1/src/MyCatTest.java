public class MyCatTest {
  public static void main(String[] args) {
    IDrivable mycar = (IDrivable) new CarImpl();
    // mycar.speed;とはかけない。
    mycar.drive(20);
    System.out.println("current spped is " + mycar.speedUp(5));
    System.out.println("current spped is " + mycar.speedDown(8));
    mycar.stop(5);
  }
}
