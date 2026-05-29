package q5;

public class CalcTotalPrice {
  public static void main(String[] args) {
    Card[] cards = {
        new Card(100, true, false),
        new Card(2000, true, true),
        new Card(420, false, true),
        new Card(20000, false, false),
    };

    // 31210
    System.out.println(calcTotalPrice(cards));
  }

  public static int calcTotalPrice(Card[] items) {
    // FIXME この関数を作りなさい
    int totalPrice = 0;
    int price = 0;
    for (Card item : items) {
      if (item.isPremier) {
        price += item.price * 10;
        if (item.isBroken) {
          price = price / 2;
        }
      } else if (item.isBroken) {
        price += item.price / 2;
      } else {
        price += item.price;
      }
      totalPrice += price;
      price = 0;
    }
    return totalPrice;
  }

  public static class Card {
    public final int price;
    public final boolean isPremier;
    public final boolean isBroken;

    public Card(int price, boolean isPremier, boolean isBroken) {
      this.price = price;
      this.isPremier = isPremier;
      this.isBroken = isBroken;
    }
  }
}