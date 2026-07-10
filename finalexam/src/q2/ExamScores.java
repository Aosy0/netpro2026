package q2;

public class ExamScores {
  // TODO クラス図に従い実装すること
  int examId;
  int mathScore;
  int engScore;
  int physicsScore;

  public void setExamId(int examId) {
    this.examId = examId;
  }

  public int getExamId() {
    return examId;
  }

  public void setMathScore(int mathScore) {
    this.mathScore = mathScore;
  }

  public int getMathScore() {
    return mathScore;
  }

  public void setEngScore(int engScore) {
    this.engScore = engScore;
  }

  public int getEngScore() {
    return engScore;
  }

  public void setPhysicsScore(int physicsScore) {
    this.physicsScore = physicsScore;
  }

  public int getPhysicsScore() {
    return physicsScore;
  }

  public float getAverageScore() {
    return (float) Math.ceil((mathScore + engScore + physicsScore) / 3);
  }

  public boolean isPass() {
    if (getMathScore() == 100)
      return true;
    else if (getAverageScore() >= 80)
      return true;
    else
      return false;
  }
}