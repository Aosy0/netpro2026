package guibasic;

import java.awt.*;
import java.awt.event.*;

//配列で5つのボールを動かしてみよう

public class MovingBallAWT {
  public static void main(String[] args) {
    FFrame f = new FFrame();
    f.setSize(500, 500);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    f.show();
  }


  static class FFrame extends Frame implements Runnable {

    Thread th;
    Ball[] myBalls = new Ball[5];
    // Ball myBall2;

    private boolean enable = true;
    private int counter = 0;

    FFrame() {
      th = new Thread(this);
      th.start();
    }

    public void run() {


      for (int i = 0; i < myBalls.length; i++) {
        myBalls[i] = new Ball();
      }
      myBalls[0].setPosition(200, 150);
      myBalls[0].setR(10);
      myBalls[0].setColor(Color.RED);

      // myBalls[1] = new Ball();
      myBalls[1].setPosition(50, 250);
      myBalls[1].setR(20);
      myBalls[1].setColor(Color.GREEN);

      myBalls[2].setPosition(300, 200);
      myBalls[2].setR(30);
      myBalls[2].setColor(Color.BLUE);

      myBalls[3].setPosition(150, 300);
      myBalls[3].setR(40);
      myBalls[3].setColor(Color.ORANGE);

      myBalls[4].setPosition(250, 100);
      myBalls[4].setR(50);
      myBalls[4].setColor(Color.CYAN);
      while (enable) {

        try {
          th.sleep(100);
          counter++;
          if (counter >= 200)
            enable = false;
        } catch (InterruptedException e) {
        }


        for (int i = 0; i < myBalls.length; i++) {
          myBalls[i].move();
        }

        repaint(); // paint()メソッドが呼び出される
      }
    }


    public void paint(Graphics g) {
      for (int i = 0; i < myBalls.length; i++) {
        myBalls[i].draw(g);
      }
    }

    // Ball というインナークラスを作る
    class Ball {
      int x;
      int y;
      int r; // 半径
      Color c = Color.RED;

      int xDir = 1; // 1:+方向 -1: -方向
      int yDir = 1;

      void setColor(Color c) {
        this.c = c;
      }

      void changeColor() {
        c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256),
            (int) (Math.random() * 256));
      }

      void move() {
        Insets insets = FFrame.this.getInsets(); // 壁の位置
        int leftWall = insets.left;
        int rightWall = FFrame.this.getWidth() - insets.right - (2 * r);
        int topWall = insets.top;
        int bottomWall = FFrame.this.getHeight() - insets.bottom - (2 * r);

        if ((xDir == 1) && (x >= rightWall)) {
          xDir = -1;
          changeColor();
        }
        if ((xDir == -1) && (x <= leftWall)) {
          xDir = 1;
          changeColor();
        }

        if (xDir == 1) {
          x = x + 10;
        } else {
          x = x - 10;
        }


        if ((yDir == 1) && (y >= bottomWall)) {
          yDir = -1;
          changeColor();
        }
        if ((yDir == -1) && (y <= topWall)) {
          yDir = 1;
          changeColor();
        }

        if (yDir == 1) {
          y = y + 10;
        } else {
          y = y - 10;
        }


      }


      void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
      }

      void setR(int r) {
        this.r = r;
      }

      void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(x, y, 2 * r, 2 * r); // rは半径なので2倍にする
      }

    }// innner class Ball end

  }

}
