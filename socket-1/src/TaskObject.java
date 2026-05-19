import java.io.Serializable;

public class TaskObject implements Serializable, ITask {
  public String message;
  public String content;
  public int execNumber;
  public int result;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String present) {
    this.content = present;
  }

  public void setExecNumber(int x) {
    this.execNumber = x;
  }

  public void exec() {
    isPrime(execNumber);
  }

  public int getResult() {
    return result;
  }
}
