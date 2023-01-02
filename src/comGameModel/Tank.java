package comGameModel;

import comGameModel.stragety.DefaultFireStrategy;
import comGameModel.stragety.FireStrategy;
import comGameModel.stragety.FourDirFireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Tank extends GameObject {//将坦克固有类封装给坦克 并且实现构造方法 以调用方向速度等
    public int x, y;
    int oldX, oldY;//记录上一次位置所在
    public Dir dir = Dir.DOWN;//特有属性 默认朝向
    private static final int SPEED = 4;//不能呗改变

    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();


    private boolean moving = true;
    private boolean living = true;


    private Random random = new Random();//生成随机数
    public Group group = Group.BAD;

    FireStrategy fs = new FourDirFireStrategy();
    public GameModel gm;

    /**
     * rectangle 每次移动需要碰撞检测 也就是有n*m此检测 2mn的新对象 消除这个数据
     */
    public Rectangle rect = new Rectangle();//记录坦克数据

    public Rectangle getRect() {
        return rect;
    }

    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {//将子弹引入
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        //记录坦克数据
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if (group == Group.GOOD) {
//            fs=new FourDirFireStrategy();
            String goodFSName = (String) PropertyMgr.get("goodFS");

            try {
                fs = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();//名字代表的类Load到内存中
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            fs = new DefaultFireStrategy();//默认发射方式
        }
    }


    public void paint(Graphics g) {

        if (!living) {
            gm.remove(this);//如果没有存活 就不绘制 被消灭的话 就移除
        }

        //判定是好的坦克还是坏的坦克

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

    public void back() {//当前位置回到之前
        x = oldX;
        y = oldY;
    }

    private void move() {

        //记录移动之前的位置
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
            this.fire();//只有敌人才是随机发射


        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

        //边界检测
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

    private void randomDir() {//随机方向

        this.dir = Dir.values()[random.nextInt(4)];//values() 返回到一个数组 数组内是能取的值
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

    public void stop() {//如果碰撞则停止行动 但是问题是下一步无法再重新启动 需要调用到上一个位置来
//        moving = false;
    }
}
