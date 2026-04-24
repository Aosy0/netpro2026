public class CatTest {
  public static void main(String args[]) {
    SimpleCar myCar1 = new SimpleCar("Red", "Toyota");
    SimpleCar myCar2 = new SimpleCar("Blue", "Nissan GTR-35");

    myCar1.displayInfo();
    myCar2.displayInfo();

    // ----

    IDrivable mycar = (IDrivable) new CarImpl();
    // mycar.speed は参照できない。
    mycar.drive(20);
    System.out.println("current spped is " + mycar.speedUp(5));
    System.out.println("current spped is " + mycar.speedDown(8));
    mycar.stop(5);

  }
}
