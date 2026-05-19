public interface IElectricCharge { // classではなくインタフェースとして宣言。名前にIをつける実装がないことがとわかりやすい。
  public void chargeBattery(int b);// 定義のみ記載{実装}は記載しない ;を忘れない。

  public int getAllBattery();

  public int consumeBattery(int b);
}