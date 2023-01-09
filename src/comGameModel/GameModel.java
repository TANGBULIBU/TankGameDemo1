package comGameModel;


import comGameModel.cor.ColliderChain;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class GameModel {//定义物体和他有关

    private static final GameModel INSTANCE = new GameModel();

    static {//静态语句块
        INSTANCE.init();
    }


    //   Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);//this 就是控制子弹的发射
    Tank myTank;//记录数据
    //    List<Tank> tanks = new ArrayList<>();//数组
    //    List<Bullet> bullets = new ArrayList<>();//数组
    //    List<Explode> explodes = new ArrayList<>();

    ColliderChain chain = new ColliderChain();

    //以上List现在只需向Object中加入

    private List<GameObject> objects = new ArrayList<>();

    public static GameModel getInstance() {//饿汉式
        return INSTANCE;
    }

    private GameModel() {

    }

    private void init() {//初始化 initialize
        //初始化主站坦克
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);//this 就是控制子弹的发射


        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 100, 200, Dir.DOWN, Group.BAD);
        }

        //初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
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
            for (int j = i + 1; j < objects.size(); j++) {//此处是i+1
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);

//                collider.collide(o1,o2);
//                collider2.collide(o1,o2);

                chain.collide(o1, o2);
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

    //保存
    public void save() {
        File f = new File("F:\\Java mashibing TankDemo/tank.data");
        ObjectOutputStream oos=null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(f));//写入
            oos.writeObject(myTank);
            oos.writeObject(objects);//写入

        } catch (IOException e) {
            e.printStackTrace();
        }finally {//不要忘记关闭流
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void load() {

        File f = new File("F:\\Java mashibing TankDemo/tank.data");

        ObjectInputStream ois = null;//读取
        try {
            ois = new ObjectInputStream(new FileInputStream(f));

            //先写入的谁 就先读取谁

            myTank = (Tank) ois.readObject();

            objects = (List) ois.readObject();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
