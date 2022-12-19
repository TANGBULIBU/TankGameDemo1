package com.Study.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ������
 * @version 1.0
 */
public class TankFrame extends Frame {


    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);//this ���ǿ����ӵ��ķ���

    List<Tank> tanks = new ArrayList<>();//����
    List<Bullet> bullets = new ArrayList<>();//����
    List<Explode> explodes = new ArrayList<>();



    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;//����Ϊ���� ����һ��λ�ü���


    public TankFrame() {


        setSize(GAME_WIDTH, GAME_HEIGHT);//���ô���
        setResizable(false);
        setTitle("tank game");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {//�������� ����ر� ���������
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //�����ӵ�����

    }

    Image offScreenImage = null;//����ͼƬ

    @Override
    public void update(Graphics g) {//��ʧ��˸���� ������ΪͼƬһ��һ���ٴλ���
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);//��ȡ��ǰ�����С��ͼƬ
        }
        Graphics gOffScreen = offScreenImage.getGraphics();//�õ�ͼƬ
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);//������Ϊ��ɫ
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);//����ͼƬ�ٴλ��Ƶ�������

    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("�ӵ�������" + bullets.size(), 10, 60);
        g.drawString("̹�˵�����" + tanks.size(), 10, 80);
        g.drawString("��ը������" + explodes.size(), 10, 100);
        g.setColor(c);//�����ӵ����ڴ�й¶ �����ӵ��ɳ����ڵ��ǲ�����ʧ ���Ծ��ǵ�ǰ�ӵ����Ҫ���� Ҳ���ǽ����������ڸɵ�


        myTank.paint(g);//̹�˻���

        for (int i = 0; i < bullets.size(); i++) {//
            bullets.get(i).paint(g);
        }
        /*
        ʹ�����ֵ���������bug �ӵ����ܲ����Ƴ� ����Ϊ����ʹ�õ���������ķ�ʽɾ������
         */
//        for (Bullet b : bullets){
//            b.paint(g);
//        }

        //����̹��
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {//�ӵ���̹����ײ
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));

            }
        }

        //��ը
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
        public void keyPressed(KeyEvent e) {//����
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
        public void keyReleased(KeyEvent e) {//̧��
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

        private void setMainTankDir() {//ȷ������

            if (!bL && !bU && !bD && !bR) myTank.setMoving(false);//��������Щ�� �Ͳ����ƶ�
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
