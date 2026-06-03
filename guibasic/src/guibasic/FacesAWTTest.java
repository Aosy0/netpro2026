package guibasic;

import java.awt.*;
import java.awt.event.*;

public class FacesAWTTest {

  // private FaceFrame[] f = new FaceFrame[9]; // 顔フレームの配列
  // メインメソッド：プログラムの開始点

  public static void main(String[] args) {
    new FacesAWTTest(); // インスタンスを生成
  }

  // コンストラクタ：ウィンドウを作成して表示
  FacesAWTTest() {
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
      setBackground(new Color(224, 229, 236));
      for (int j = 0; j < 3; j++) {
        for (int i = 0; i < 3; i++) {
          fobjs[i + 3 * j] = new FaceObj();
        }
      }
    }

    // 描画処理
    public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      for (int j = 0; j < 3; j++) {
        for (int i = 0; i < 3; i++) {
          fobjs[i + 3 * j].setPosition(200 * i + 50, 200 * j + 50);
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

    Color baseColor = new Color(224, 229, 236);
    Color shadowColor = new Color(163, 177, 198);
    Color lightColor = new Color(255, 255, 255);
    Color featureColor = new Color(100, 100, 120);

    // ソフトシャドウを描画するヘルパー（右下）
    private void drawSoftShadow(Graphics2D g2, int x, int y, int w, int h, int radius, int cornerRadius) {
      for (int i = radius; i > 0; i--) {
        float alpha = 0.18f * (1.0f - (float) i / radius);
        g2.setColor(new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(), (int) (alpha * 255)));
        g2.fillRoundRect(x + i, y + i, w, h, cornerRadius, cornerRadius);
      }
    }

    private void drawSoftHighlight(Graphics2D g2, int x, int y, int w, int h, int radius, int cornerRadius) {
      for (int i = radius; i > 0; i--) {
        float alpha = 0.22f * (1.0f - (float) i / radius);
        g2.setColor(new Color(lightColor.getRed(), lightColor.getGreen(), lightColor.getBlue(), (int) (alpha * 255)));
        g2.fillRoundRect(x - i, y - i, w, h, cornerRadius, cornerRadius);
      }
    }

    private void drawInnerShadow(Graphics2D g2, int x, int y, int w, int h, int radius, int cornerRadius) {
      for (int i = radius; i > 0; i--) {
        float alpha = 0.15f * (1.0f - (float) i / radius);
        g2.setColor(new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(), (int) (alpha * 255)));
        g2.fillRoundRect(x - i, y - i, w, h, cornerRadius, cornerRadius);
      }
    }

    private void drawInnerHighlight(Graphics2D g2, int x, int y, int w, int h, int radius, int cornerRadius) {
      for (int i = radius; i > 0; i--) {
        float alpha = 0.15f * (1.0f - (float) i / radius);
        g2.setColor(new Color(lightColor.getRed(), lightColor.getGreen(), lightColor.getBlue(), (int) (alpha * 255)));
        g2.fillRoundRect(x + i, y + i, w, h, cornerRadius, cornerRadius);
      }
    }

    // 今後、顔のスタイル・パーツ管理などをここに記述
    public void setPosition(int xStart, int yStart) {
      this.xStart = xStart;
      this.yStart = yStart;
    }

    public void drawFace(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      drawNeumorphBase(g2); // ニューモーフィズムベース
      drawEye(g2, 35); // 目
      drawNose(g2, 40); // 鼻
      setEmotionLevel(g2, 1, 1); // 表情レベル（中立）を設定
    }

    public void drawNeumorphBase(Graphics2D g2) {
      drawSoftShadow(g2, xStart, yStart, w, h, 12, 40);
      drawSoftHighlight(g2, xStart, yStart, w, h, 12, 40);
      g2.setColor(baseColor);
      g2.fillRoundRect(xStart, yStart, w, h, 40, 40);
    }

    public void drawBrow(Graphics2D g2, int bx, int browoffset) {
      g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
      g2.setColor(featureColor);
      g2.drawLine(xStart + 40, yStart + 50 + browoffset, xStart + 40 + bx, yStart + 50);
      g2.drawLine(xStart + 120, yStart + 50, xStart + 120 + bx, yStart + 50 + browoffset);
      g2.setStroke(new BasicStroke(1));
    }

    public void drawNose(Graphics2D g2, int nx) {
      int xMiddle = xStart + w / 2;
      int yMiddle = yStart + h / 2;

      g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
      g2.setColor(featureColor);
      g2.drawLine(xMiddle, yMiddle - nx / 2, xMiddle, yMiddle + nx / 2);
      g2.setStroke(new BasicStroke(1));
    }

    public void drawEye(Graphics2D g2, int r) {
      int x1 = xStart + 40;
      int y1 = yStart + 70;
      int x2 = xStart + 120;
      int y2 = yStart + 70;

      drawInnerShadow(g2, x1 + r/2, y1 + r/2, 2, 2, 6, r);
      drawInnerShadow(g2, x2 + r/2, y2 + r/2, 2, 2, 6, r);

      drawInnerHighlight(g2, x1 + r/2, y1 + r/2, 2, 2, 6, r);
      drawInnerHighlight(g2, x2 + r/2, y2 + r/2, 2, 2, 6, r);

      g2.setColor(baseColor);
      g2.fillOval(x1, y1, r, r);
      g2.fillOval(x2, y2, r, r);

      g2.setColor(featureColor);
      g2.fillOval(xStart + 50, yStart + 78, r / 2, r / 2);
      g2.fillOval(xStart + 130, yStart + 78, r / 2, r / 2);
    }

    public void drawMouth(Graphics2D g2, int mx) {
      int xMiddle = xStart + w / 2;
      int yMouth = yStart + h - 30;

      g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
      g2.setColor(featureColor);
      g2.drawLine(xMiddle - mx / 2, yMouth + 10, xMiddle, yMouth);
      g2.drawLine(xMiddle + mx / 2, yMouth + 10, xMiddle, yMouth);
      g2.setStroke(new BasicStroke(1));
    }

    public void setEmotionLevel(Graphics2D g2, int ex, int ey) {
      // ex: 0-2 (左-右), ey: 0-2 (上-下)
      // まゆげの傾きと口の形を変える
      int browOffset = (ex - 1) * 10; // -10, 0, +10
      int mouthOffset = (ey - 1) * 20; // -20, 0, +20
      drawBrow(g2, 30, browOffset);
      drawMouth(g2, 100 + mouthOffset);
    }

  }
}
// FacesAWTMain end