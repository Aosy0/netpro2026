public class HybridCarImpl implements ICar, IElectricCharge, INavigation {// 二つのインタフェースを実装(implementsのimple)
  private int b = 50;
  private int sp = 5;
  private String distination = "東京";

  public static void main(String[] args) {
    HybridCarImpl masaCar = new HybridCarImpl();

    ICar car = (ICar) masaCar;// ICarインタフェースでキャスト
    car.setSpeed(60);
    car.printCarName();

    IElectricCharge charger = (IElectricCharge) masaCar;// IElectricChargeインタフェースでキャスト
    charger.chargeBattery(100);
    System.out.println("btt_now:" + charger.getAllBattery());
    charger.consumeBattery(15);
    System.out.println("btt_now:" + charger.getAllBattery());

    INavigation nav = (INavigation) masaCar;// INavigationインタフェースでキャスト
    nav.setDistination("大阪");
    nav.printRoute();
  }


  @Override
  public void chargeBattery(int b) {
    this.b = b;

  }

  @Override
  public int getAllBattery() {
    return b;
  }

  @Override
  public int consumeBattery(int b) {
    this.b -= b;
    return this.b;
  }

  @Override
  public void setSpeed(int sp) {
    this.sp = sp;
  }

  @Override
  public int getSpeed() {
    return sp;
  }

  @Override
  public void printCarName() {
    System.out.println("masacar");
  }

  @Override
  public void setDistination(String distination) {
    this.distination = distination;
  }

  @Override
  public void printRoute() {
    System.out.println("目的地は" + distination);
  }
}