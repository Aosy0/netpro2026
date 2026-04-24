public class Car {
  // フィールド（属性）
  private String color;
  private String model;

  // コンストラクタ
  public Car(String color, String model) {
    this.color = color;
    this.model = model;
  }

  // メソッド
  public void displayInfo() {
    System.out.println("Model: " + model + ", Color: " + color);
  }
}

// オブジェクトの生成と使用 別のメインクラスなどから呼び出す。例えばCatTestクラスから呼び出す。
// Car myCar = new Car("Red", "Toyota");
// myCar.displayInfo();
