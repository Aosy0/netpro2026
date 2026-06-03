package guibasic;

import java.awt.*;
import java.awt.event.*;

public class FacesAWTMain {

  // private FaceFrame[] f = new FaceFrame[9]; // 顔フレームの配列
  // メインメソッド：プログラムの開始点

  public static void main(String[] args) {
    new FacesAWTMain(); // インスタンスを生成
  }

  // コンストラクタ：ウィンドウを作成して表示
  FacesAWTMain() {
    FaceFrame f = new FaceFrame(); // カスタムフレーム生成
    f.setSize(800, 800); // ウィンドウサイズ設定
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0); // ウィンドウを閉じたときに終了
      }
    });
    f.setVisible(true); // ウィンドウを表示

  }

  // 内部クラス：顔を描画するためのフレーム
  class FaceFrame extends Frame {

    private int w; // 顔の幅
    private int h; // 顔の高さ
    private int xStart; // 顔の左上x座標
    private int yStart; // 顔の左上y座標private
    private FaceObj fobj1; // 顔オブジェクト
    private FaceObj fobj2; // 顔オブジェクト

    FaceObj[] fobjs = new FaceObj[9];

    // コンストラクタ：FaceObjインスタンスを生成
    FaceFrame() {
      // fobj1 = new FaceObj();
      // fobj2 = new FaceObj();
      for (int j = 0; j < 3; j++) {
        for (int i = 0; i < 3; i++) {
          fobjs[i + 3 * j] = new FaceObj();
        }
      }
    }

    // 描画処理
    public void paint(Graphics g) {
      // w = 200;
      // h = 200;
      // xStart = 50;
      // yStart = 50;

      // fobj1.drawFace(g);
      // fobj2.setPosition(xStart + w + 50, yStart); // 2つ目の顔を右に配置
      // fobj2.drawFace(g);
      for (int j = 0; j < 3; j++) {
        for (int i = 0; i < 3; i++) {
          fobjs[i + 3 * j].setPosition(200 * i + 50, 200 * j + 50);
          // fobjs[i + 3 * j].setEmotionLevel(i, j);
          Color faceColor = new Color(i * 100, j * 100, 200);
          g.setColor(faceColor);
          fobjs[i + 3 * j].drawFace(g);
        }
      }
    }
  }

  // 顔に関するロジックを後で追加する予定のクラス
  private class FaceObj {
    int w = 200;
    int h = 200;
    int xStart = 50;
    int yStart = 50;

    // 今後、顔のスタイル・パーツ管理などをここに記述
    public void setPosition(int xStart, int yStart) {
      this.xStart = xStart;
      this.yStart = yStart;
    }

    public void drawFace(Graphics g) {
      // 顔の各パーツを描画
      // Color color = new Color(255, 123, 24, 56);
      // g.setColor(color);
      drawRim(g); // 顔の輪郭
      // drawBrow(g, 30, 30); // まゆげ
      drawEye(g, 35); // 目
      drawNose(g, 40); // 鼻
      // drawMouth(g, 100); // 口
      setEmotionLevel(g, 1, 1); // 表情レベル（中立）を設定
    }

    // 顔の枠線を描く
    public void drawRim(Graphics g) {
      // g.drawLine(xStart, yStart, xStart + w, yStart);
      // g.drawLine(xStart, yStart, xStart, yStart + h);
      // g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
      // g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
      g.drawRoundRect(xStart + 5, yStart + 5, w - 10, h - 10, 40, 40);
    }

    // まゆげを描く（未実装）
    public void drawBrow(Graphics g, int bx, int browoffset) {
      g.drawLine(xStart + 40, yStart + 50 + browoffset, xStart + 40 + bx, yStart + 50);
      g.drawLine(xStart + 120, yStart + 50, xStart + 120 + bx, yStart + 50 + browoffset);
    }

    // 鼻を描く（未実装）
    public void drawNose(Graphics g, int nx) {
      int xMiddle = xStart + w / 2;
      int yMiddle = yStart + h / 2;
      g.drawLine(xMiddle, yMiddle - nx / 2, xMiddle, yMiddle + nx / 2);
    }

    // 両目を描く
    public void drawEye(Graphics g, int r) {
      g.fillOval(xStart + 40, yStart + 70, r, r);
      g.fillOval(xStart + 120, yStart + 70, r, r);
    }

    // 口を描く
    public void drawMouth(Graphics g, int mx) {
      int xMiddle = xStart + w / 2;
      int yMouth = yStart + h - 30;
      g.drawLine(xMiddle - mx / 2, yMouth + 10, xMiddle, yMouth);
      g.drawLine(xMiddle + mx / 2, yMouth + 10, xMiddle, yMouth);
    }

    public void setEmotionLevel(Graphics g, int ex, int ey) {
      // ex: 0-2 (左-右), ey: 0-2 (上-下)
      // まゆげの傾きと口の形を変える
      int browOffset = (ex - 1) * 10; // -10, 0, +10
      int mouthOffset = (ey - 1) * 20; // -20, 0, +20
      drawBrow(g, 30, browOffset);
      drawMouth(g, 100 + mouthOffset);
    }

  }
}
// FacesAWTMain end
