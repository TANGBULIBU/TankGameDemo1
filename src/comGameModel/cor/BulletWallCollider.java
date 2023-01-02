package comGameModel.cor;

import comGameModel.Bullet;
import comGameModel.GameObject;
import comGameModel.Tank;
import comGameModel.Wall;

/**
 * @author ������
 * @version 1.0
 */
public class BulletWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {//ǰһ��������ӵ���ײ ��һ�������̹����ײ����
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
//            b.collideWith(t);//bullet ��tank�Ӵ�

            if (b.rect.intersects(w.rect)) {
                b.die();
            }

        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
             return collide(o2, o1);//Ҳ����˭������˭�Ǳ��� ����һ�����ǵ�����Ȩ
        }
        return true;
    }
}
