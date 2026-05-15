public class DinnerFullCourse {
  private Dish[] dishes = new Dish[5];// [0]-[4]の計5個

  public static void main(String[] args) {

    DinnerFullCourse fullcourse = new DinnerFullCourse();
    fullcourse.eatAll();
  }

  DinnerFullCourse() {
    dishes[0] = new Dish();
    dishes[0].setName("特選シーザサラダ");
    dishes[0].setPrice(10);

    dishes[1] = new Dish();
    dishes[1].setName("銀しゃり");
    dishes[1].setPrice(2);

    dishes[2] = new Dish();
    dishes[2].setName("梅干し");
    dishes[2].setPrice(20);

    dishes[3] = new Dish();
    dishes[3].setName("特選ステーキ");
    dishes[3].setPrice(100);

    dishes[4] = new Dish();
    dishes[4].setName("デザート");
    dishes[4].setPrice(5);
  }// DinnerFullCourseコンストラクターエンド

  void eatAll() {
    String str = "";
    for (Dish dish : dishes) {
      str += dish.getName() + "=" + dish.getPrice() + ",\n";
    }
    System.out.println("たかしへ、ママです。今日の晩御飯は\n" + str + "よ");
  }// eat end

  // cook3Dishes()
}// DinnerFullCourse end
