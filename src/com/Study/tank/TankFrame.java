package com.Study.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class TankFrame extends Frame {


    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);//this 就是控制子弹的发射

    List<Tank> tanks = new ArrayList<>();//数组
    List<Bullet> bullets = new ArrayList<>();//数组
    List<Explode> explodes = new ArrayList<>();



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
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量" + bullets.size(), 10, 60);
        g.drawString("坦克的数量" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量" + explodes.size(), 10, 100);
        g.setColor(c);//测试子弹的内存泄露 就是子弹飞出窗口但是不会消失 所以就是当前子弹最好要结束 也就是将其生命周期干掉


        myTank.paint(g);//坦克绘制

        for (int i = 0; i < bullets.size(); i++) {//
            bullets.get(i).paint(g);
        }
        /*
        使用这种迭代器会有bug 子弹可能不会移除 是因为不能使用迭代器以外的方式删除内容
         */
//        for (Bullet b : bullets){
//            b.paint(g);
//        }

        //绘制坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {//子弹和坦克碰撞
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));

            }
        }

        //爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

    }

    class MyKeyListener extends KeyAdapter {

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
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {//确定朝向

            if (!bL && !bU && !bD && !bR) myTank.setMoving(false);//不按下这些键 就不会移动
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
