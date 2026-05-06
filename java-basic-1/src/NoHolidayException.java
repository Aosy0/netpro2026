public class NoHolidayException extends Exception {
  // @Override
  public NoHolidayException() {
    super.printStackTrace();
    System.err.println("その日は平日です！！！");
  }
}
