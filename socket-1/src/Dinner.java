public class Dinner {
  Dish dish1;
  Dish dish2;
  Dish dish3;

  public static void main(String[] args) {
    Dinner dinner = new Dinner();
    dinner.eat3Dishes();
  }

  Dinner() {
    dish1 = new Dish();
    dish1.setName("特選シーザサラダ");
    dish1.setPrice(10);

    dish2 = new Dish();
    dish2.setName("銀しゃり");
    dish2.setPrice(2);

    dish3 = new Dish();
    dish3.setName("梅干し");
    dish3.setPrice(20);
  }// Dinnerコンストラクターエンド

  void eat3Dishes() {
    String str = dish1.getName() + "=" + dish1.getPrice() + ","
        + dish2.getName() + "=" + dish2.getPrice() + ","
        + dish3.getName() + "=" + dish3.getPrice();
    System.out.println("たかしへ、ママです。今日の晩御飯は" + str + "よ");
  }// eat end

  // cook3Dishes()
}// Dinner end