package comGameModel;

import comGameModel.cor.BulletTankCollider;
import comGameModel.cor.Collider;
import comGameModel.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class GameModel {


    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);//this 就是控制子弹的发射

//    List<Tank> tanks = new ArrayList<>();//数组
//    List<Bullet> bullets = new ArrayList<>();//数组
//    List<Explode> explodes = new ArrayList<>();
    Collider collider=new BulletTankCollider();
    Collider collider2=new TankTankCollider();

    //以上List现在只需向Object中加入

    private List<GameObject> objects = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add( new Tank(50 + i * 100, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量" + bullets.size(), 10, 60);
//        g.drawString("坦克的数量" + tanks.size(), 10, 80);
//        g.drawString("爆炸的数量" + explodes.size(), 10, 100);
        g.setColor(c);//测试子弹的内存泄露 就是子弹飞出窗口但是不会消失 所以就是当前子弹最好要结束 也就是将其生命周期干掉


        myTank.paint(g);//坦克绘制

        for (int i = 0; i < objects.size(); i++) {//
            objects.get(i).paint(g);
        }

        /**
         * 碰撞逻辑
         *
         */

        for (int i = 0; i < objects.size(); i++) {
            for (int j = 0; j < objects.size(); j++) {
                GameObject o1=objects.get(i);
                GameObject o2=objects.get(j);

                collider.collide(o1,o2);
                collider2.collide(o1,o2);
            }
        }
//        for (int i = 0; i < bullets.size(); i++) {//子弹和坦克碰撞
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//
//            }
//        }

//        //爆炸
//        for (int i = 0; i < explodes.size(); i++) {
//            explodes.get(i).paint(g);
//        }

    }

    public Tank getMainTank() {
        return myTank;
    }

}
