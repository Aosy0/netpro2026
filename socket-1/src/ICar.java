public interface ICar {// classではなくインタフェースとして宣言。名前にIをつける実装がないことがとわかりやすい。
  public void setSpeed(int sp);

  public int getSpeed();

  public void printCarName();
}