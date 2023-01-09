package comGameModel;


import comGameModel.cor.ColliderChain;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ������
 * @version 1.0
 */
public class GameModel {//������������й�

    private static final GameModel INSTANCE = new GameModel();

    static {//��̬����
        INSTANCE.init();
    }


    //   Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);//this ���ǿ����ӵ��ķ���
    Tank myTank;//��¼����
    //    List<Tank> tanks = new ArrayList<>();//����
    //    List<Bullet> bullets = new ArrayList<>();//����
    //    List<Explode> explodes = new ArrayList<>();

    ColliderChain chain = new ColliderChain();

    //����List����ֻ����Object�м���

    private List<GameObject> objects = new ArrayList<>();

    public static GameModel getInstance() {//����ʽ
        return INSTANCE;
    }

    private GameModel() {

    }

    private void init() {//��ʼ�� initialize
        //��ʼ����վ̹��
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);//this ���ǿ����ӵ��ķ���


        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //��ʼ���з�̹��
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 100, 200, Dir.DOWN, Group.BAD);
        }

        //��ʼ��ǽ
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
//        g.drawString("�ӵ�������" + bullets.size(), 10, 60);
//        g.drawString("̹�˵�����" + tanks.size(), 10, 80);
//        g.drawString("��ը������" + explodes.size(), 10, 100);
        g.setColor(c);//�����ӵ����ڴ�й¶ �����ӵ��ɳ����ڵ��ǲ�����ʧ ���Ծ��ǵ�ǰ�ӵ����Ҫ���� Ҳ���ǽ����������ڸɵ�


        myTank.paint(g);//̹�˻���

        for (int i = 0; i < objects.size(); i++) {//
            objects.get(i).paint(g);
        }

        /**
         * ��ײ�߼�
         *
         */

        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {//�˴���i+1
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);

//                collider.collide(o1,o2);
//                collider2.collide(o1,o2);

                chain.collide(o1, o2);
            }
        }
//        for (int i = 0; i < bullets.size(); i++) {//�ӵ���̹����ײ
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//
//            }
//        }

//        //��ը
//        for (int i = 0; i < explodes.size(); i++) {
//            explodes.get(i).paint(g);
//        }

    }

    public Tank getMainTank() {
        return myTank;
    }

    //����
    public void save() {
        File f = new File("F:\\Java mashibing TankDemo/tank.data");
        ObjectOutputStream oos=null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(f));//д��
            oos.writeObject(myTank);
            oos.writeObject(objects);//д��

        } catch (IOException e) {
            e.printStackTrace();
        }finally {//��Ҫ���ǹر���
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

        ObjectInputStream ois = null;//��ȡ
        try {
            ois = new ObjectInputStream(new FileInputStream(f));

            //��д���˭ ���ȶ�ȡ˭

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
