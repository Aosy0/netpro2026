package q2;

import java.util.Random;

public class ExamMaxAveMain {
  public static void main(String[] args) {
    // シード値を設定する
    Random random = new Random(0);

    // TODO 条件を満たす実装を行うこと
    ExamScores[] examScores = new ExamScores[3000];
    System.out.println("合格者のIDと各成績");
    for (int i = 0; i < examScores.length; i++) {
      examScores[i] = new ExamScores();
      examScores[i].setExamId(i + 1);
      examScores[i].setMathScore(random.nextInt(101));
      examScores[i].setEngScore(random.nextInt(101));
      examScores[i].setPhysicsScore(random.nextInt(101));
      if (examScores[i].isPass()) {
        System.out
            .println("examid: " + examScores[i].getExamId() + ", Math: " + examScores[i].getMathScore() + ", English: "
                + examScores[i].getEngScore() + ", Physics: " + examScores[i].getPhysicsScore());
      }
    }
  }
}