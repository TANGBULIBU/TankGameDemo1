package comGameModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class GameModel {


    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);//this 就是控制子弹的发射

    List<Tank> tanks = new ArrayList<>();//数组
    List<Bullet> bullets = new ArrayList<>();//数组
    List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

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

    public Tank getMainTank() {
        return myTank;
    }

}
