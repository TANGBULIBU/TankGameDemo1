package comGameModel;

import java.awt.*;

/**
 * @author 鸡腿子
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

    public Rectangle rect = new Rectangle();//记录子弹数据


    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;


        //记录子弹数据
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

//        gm.add(this);//自己加到bullets队列
        GameModel.getInstance().add(this);//饿汉式只能通过调用getInstance才能添加

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {//绘制子弹
        if (!living) {
            GameModel.getInstance().remove(this);//如果没有存活 就移除
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

        move();//子弹也需要有移动状态


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

        //超出边界就结束
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;


        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

//    public boolean collideWith(Tank tank) {
//
//        if (this.group == tank.getGroup()) return false;//队友伤害默认不开启
//
////        //TODO 用一个rect记录子弹的位置
////        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);// Rectangle 矩形 this子弹的位置数据
////        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);// tank的位置数据
//
//
//        if (rect.intersects(tank.rect)) {//对象1，2相交
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
