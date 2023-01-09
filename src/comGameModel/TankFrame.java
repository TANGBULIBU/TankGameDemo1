package comGameModel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class TankFrame extends Frame {

    GameModel gm = GameModel.getInstance();

    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;//抽象为常量 更改一个位置即可

    public TankFrame() {

        setSize(GAME_WIDTH, GAME_HEIGHT);//设置窗口
        setResizable(false);
        setTitle("tank game");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {//监听窗口 如果关闭 则结束程序
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //传入子弹对象
    }

    Image offScreenImage = null;//定义图片

    @Override
    public void update(Graphics g) {//消失闪烁现象 就是作为图片一张一张再次绘制
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);//获取当前画面大小的图片
        }
        Graphics gOffScreen = offScreenImage.getGraphics();//拿到图片
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);//背景变为黑色
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);//这张图片再次绘制到画面上

    }

    @Override
    public void paint(Graphics g) {
        gm.paint(g);
    }

    class MyKeyListener extends KeyAdapter {//MyKeyListener也就是观察者 监听事件

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {//按键
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_A:
                    bL = true;
                    break;
                case KeyEvent.VK_D:
                    bR = true;
                    break;
                case KeyEvent.VK_W:
                    bU = true;
                    break;
                case KeyEvent.VK_S:
                    bD = true;
                    break;

                case KeyEvent.VK_T://保存
                    gm.save();
                    break;
                case KeyEvent.VK_L:
                    gm.load();
                    break;


                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {//抬起
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_A:
                    bL = false;
                    break;
                case KeyEvent.VK_D:
                    bR = false;
                    break;
                case KeyEvent.VK_W:
                    bU = false;
                    break;
                case KeyEvent.VK_S:
                    bD = false;
                    break;
                case KeyEvent.VK_J:
                    gm.getMainTank().handleFireKey();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {//确定朝向

            Tank myTank = gm.getMainTank();

            if (!bL && !bU && !bD && !bR) gm.getMainTank().setMoving(false);//不按下这些键 就不会移动
            else {

                myTank.setMoving(true);
                if (bL)
                    myTank.setDir(Dir.LEFT);
                if (bR)
                    myTank.setDir(Dir.RIGHT);
                if (bU)
                    myTank.setDir(Dir.UP);
                if (bD)
                    myTank.setDir(Dir.DOWN);

            }


        }
    }
}
