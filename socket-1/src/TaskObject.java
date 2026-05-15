import java.io.Serializable;

public class TaskObject implements Serializable, ITask {
  public String message;
  public String content;

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

}
