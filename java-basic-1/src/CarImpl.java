public class CarImpl implements IDrivable, IElectric {
  private int speed; // privateでは動かなかった。おそらくパッケージを利用していないため。
  private int power;

  @Override
  public void drive(int speed) {
    this.speed = speed;
    System.out.println("Driving at " + this.speed + " kilometers per hour.");
  }

  @Override
  public void stop(int i) {
    this.speed = 0;
  }

  @Override
  public int speedUp(int speed) {
    return this.speed;
  }

  @Override
  public int speedDown(int speed) {
    this.speed = speed;
    return this.speed;
  }

  @Override
  public boolean chargeElectricePower(int power) {
    if (power > 0) {
      this.power += power;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int getElectricePower() {
    return this.power;
  }

}
