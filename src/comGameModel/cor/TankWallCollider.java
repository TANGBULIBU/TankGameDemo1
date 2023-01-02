package comGameModel.cor;

import comGameModel.Bullet;
import comGameModel.GameObject;
import comGameModel.Tank;
import comGameModel.Wall;

/**
 * @author ������
 * @version 1.0
 */
public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {//ǰһ��������ӵ���ײ ��һ�������̹����ײ����
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;
//            b.collideWith(t);//bullet ��tank�Ӵ�

            if (t.rect.intersects(w.rect)) {
                t.back();
            }

        } else if (o1 instanceof Wall && o2 instanceof Tank) {
             return collide(o2, o1);//Ҳ����˭������˭�Ǳ��� ����һ�����ǵ�����Ȩ
        }
        return true;
    }
}
