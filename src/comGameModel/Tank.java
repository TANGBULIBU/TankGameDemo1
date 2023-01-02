package comGameModel;

import comGameModel.stragety.DefaultFireStrategy;
import comGameModel.stragety.FireStrategy;
import comGameModel.stragety.FourDirFireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @author ������
 * @version 1.0
 */
public class Tank extends GameObject {//��̹�˹������װ��̹�� ����ʵ�ֹ��췽�� �Ե��÷����ٶȵ�
    public int x, y;
    int oldX, oldY;//��¼��һ��λ������
    public Dir dir = Dir.DOWN;//�������� Ĭ�ϳ���
    private static final int SPEED = 4;//�����¸ı�

    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();


    private boolean moving = true;
    private boolean living = true;


    private Random random = new Random();//���������
    public Group group = Group.BAD;

    FireStrategy fs = new FourDirFireStrategy();
    public GameModel gm;

    /**
     * rectangle ÿ���ƶ���Ҫ��ײ��� Ҳ������n*m�˼�� 2mn���¶��� �����������
     */
    public Rectangle rect = new Rectangle();//��¼̹������

    public Rectangle getRect() {
        return rect;
    }

    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {//���ӵ�����
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        //��¼̹������
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if (group == Group.GOOD) {
//            fs=new FourDirFireStrategy();
            String goodFSName = (String) PropertyMgr.get("goodFS");

            try {
                fs = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();//���ִ������Load���ڴ���
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            fs = new DefaultFireStrategy();//Ĭ�Ϸ��䷽ʽ
        }
    }


    public void paint(Graphics g) {

        if (!living) {
            gm.remove(this);//���û�д�� �Ͳ����� ������Ļ� ���Ƴ�
        }

        //�ж��Ǻõ�̹�˻��ǻ���̹��

        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;

            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;

            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;

        }
        move();
    }

    public void back() {//��ǰλ�ûص�֮ǰ
        x = oldX;
        y = oldY;
    }

    private void move() {

        //��¼�ƶ�֮ǰ��λ��
        oldX = x;
        oldY = y;

        if (!moving) return;

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
        }


        if (this.group == Group.BAD && random.nextInt(100) > 95)
            this.fire();//ֻ�е��˲����������


        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

        //�߽���
        boundCheck();

        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundCheck() {
        if (this.x < 5) x = 5;
        if (this.y < 100) y = 100;
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 5) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 5;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 5) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 5;


    }

    private void randomDir() {//�������

        this.dir = Dir.values()[random.nextInt(4)];//values() ���ص�һ������ ����������ȡ��ֵ
    }

    public void fire() {
        fs.fire(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isMoving() {
        return moving;
    }



    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void die() {
        this.living = false;
    }

    public void stop() {//�����ײ��ֹͣ�ж� ������������һ���޷����������� ��Ҫ���õ���һ��λ����
//        moving = false;
    }
}
