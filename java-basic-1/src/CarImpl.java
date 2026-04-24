public class CarImpl implements IDrivable {
  public int speed; // privateでは動かなかった。おそらくパッケージを利用していないため。

  @Override
  public void drive(int speed) {
    this.speed = speed;
    System.out.println("Driving at " + this.speed + " kilometers per hour.");
  }

  @Override
  public int speedUp(int speed) {
    this.speed = speed;
    throw new UnsupportedOperationException("Unimplemented method 'speedUp'");
  }

  @Override
  public int speedDown(int speed) {
    // TODO Auto-generated method stub
    this.speed = speed;
    return this.speed;
    // throw new UnsupportedOperationException("Unimplemented method 'speedDown'");
  }

  @Override
  public int stop(int i) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'stop'");
  }
}
