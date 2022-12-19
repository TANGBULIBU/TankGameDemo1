package com.Study.tank;

import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Bullet {
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;
    private Dir dir;

    private boolean living = true;
    TankFrame tf = null;
    private Group group = Group.BAD;

    Rectangle rect = new Rectangle();//记录子弹数据


    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        //记录子弹数据
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        tf.bullets.add(this);//自己加到bullets队列

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {//绘制子弹
        if (!living) {
            tf.bullets.remove(this);//如果没有存活 就移除
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

    public void collideWith(Tank tank) {

        if (this.group == tank.getGroup()) return;//队友伤害默认不开启

//        //TODO 用一个rect记录子弹的位置
//        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);// Rectangle 矩形 this子弹的位置数据
//        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);// tank的位置数据


        if (rect.intersects(tank.rect)) {//对象1，2相交
            tank.die();
            this.die();

            int eX = tank.getX() + tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tf.explodes.add(new Explode(eX, eY, tf));
        }

    }

    private void die() {
        this.living = false;
    }

}
