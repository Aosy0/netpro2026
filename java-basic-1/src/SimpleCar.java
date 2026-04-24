public class SimpleCar {
  // フィールド（属性）
  private String color;
  private String model;

  // コンストラクタ
  public SimpleCar(String color, String model) {
    this.color = color;
    this.model = model;
  }

  // メソッド
  public void displayInfo() {
    System.out.println("Model: " + model + ", Color: " + color);
  }
}
