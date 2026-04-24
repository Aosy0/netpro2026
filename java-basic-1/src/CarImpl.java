public class CarImpl implements IDrivable {
  public int speed; // privateでは動かなかった。おそらくパッケージを利用していないため。

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

}