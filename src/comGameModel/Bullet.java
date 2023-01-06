package comGameModel;

import java.awt.*;

/**
 * @author ������
 * @version 1.0
 */
public class Bullet extends GameObject {
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Dir dir;

    private boolean living = true;
    //    GameModel gm = null;
    public Group group = Group.BAD;

    public Rectangle rect = new Rectangle();//��¼�ӵ�����


    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;


        //��¼�ӵ�����
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

//        gm.add(this);//�Լ��ӵ�bullets����
        GameModel.getInstance().add(this);//����ʽֻ��ͨ������getInstance�������

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {//�����ӵ�
        if (!living) {
            GameModel.getInstance().remove(this);//���û�д�� ���Ƴ�
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;

            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;

            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;

        }

        move();//�ӵ�Ҳ��Ҫ���ƶ�״̬


    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }


    private void move() {

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

        //�����߽�ͽ���
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;


        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

//    public boolean collideWith(Tank tank) {
//
//        if (this.group == tank.getGroup()) return false;//�����˺�Ĭ�ϲ�����
//
////        //TODO ��һ��rect��¼�ӵ���λ��
////        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);// Rectangle ���� this�ӵ���λ������
////        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);// tank��λ������
//
//
//        if (rect.intersects(tank.rect)) {//����1��2�ཻ
//            tank.die();
//            this.die();
//
//            int eX = tank.getX() + tank.WIDTH / 2 - Explode.WIDTH / 2;
//            int eY = tank.getY() + tank.HEIGHT / 2 - Explode.HEIGHT / 2;
//            gm.add(new Explode(eX, eY, gm));
//            return true;
//        }
//        return false;
//
//    }

    public void die() {
        this.living = false;
    }


}
