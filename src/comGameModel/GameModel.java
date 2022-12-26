package comGameModel;

import comGameModel.cor.BulletTankCollider;
import comGameModel.cor.Collider;
import comGameModel.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ������
 * @version 1.0
 */
public class GameModel {


    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);//this ���ǿ����ӵ��ķ���

//    List<Tank> tanks = new ArrayList<>();//����
//    List<Bullet> bullets = new ArrayList<>();//����
//    List<Explode> explodes = new ArrayList<>();
    Collider collider=new BulletTankCollider();
    Collider collider2=new TankTankCollider();

    //����List����ֻ����Object�м���

    private List<GameObject> objects = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //��ʼ���з�̹��
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
            for (int j = 0; j < objects.size(); j++) {
                GameObject o1=objects.get(i);
                GameObject o2=objects.get(j);

                collider.collide(o1,o2);
                collider2.collide(o1,o2);
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

}
