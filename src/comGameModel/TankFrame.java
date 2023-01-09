package comGameModel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author ������
 * @version 1.0
 */
public class TankFrame extends Frame {

    GameModel gm = GameModel.getInstance();

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
        gm.paint(g);
    }

    class MyKeyListener extends KeyAdapter {//MyKeyListenerҲ���ǹ۲��� �����¼�

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

                case KeyEvent.VK_T://����
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
                    gm.getMainTank().handleFireKey();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {//ȷ������

            Tank myTank = gm.getMainTank();

            if (!bL && !bU && !bD && !bR) gm.getMainTank().setMoving(false);//��������Щ�� �Ͳ����ƶ�
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
