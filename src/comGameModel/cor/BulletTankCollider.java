package comGameModel.cor;

import comGameModel.Bullet;
import comGameModel.Explode;
import comGameModel.GameObject;
import comGameModel.Tank;

/**
 * @author ������
 * @version 1.0
 */
public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {//ǰһ��������ӵ���ײ ��һ�������̹����ײ����
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
//          b.collideWith(t);//bullet ��tank�Ӵ�

            if (b.group == t.getGroup()) return true;//����ӵ��Ƿ����Լ������

            if (b.rect.intersects((t.rect))) {//��ײ�ķ���
                t.die();
                b.die();
                int eX = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                new Explode(eX, eY);
                return false;
            }

        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);//Ҳ����˭������˭�Ǳ��� ����һ�����ǵ�����Ȩ
        }
        return true;
    }
}
