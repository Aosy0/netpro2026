public class CatTest {
  public static void main(String args[]) {
    // オブジェクトの生成と使用 別のメインクラスなどから呼び出す。例えばCatTestクラスから呼び出す。
    Car myCar1 = new Car("Red", "Toyota");
    Car myCar2 = new Car("Blue", "Nissan GTR-35");
    myCar1.displayInfo();
    myCar2.displayInfo();

  }
}
