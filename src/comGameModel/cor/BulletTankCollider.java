package comGameModel.cor;

import comGameModel.Bullet;
import comGameModel.GameObject;
import comGameModel.Tank;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
//            b.collideWith(t);//bullet 和tank接触

            if (b.collideWith(t)) {
                return false;
            }

        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);//也就是谁是主动谁是被动 交换一下他们的主动权
        }
        return true;
    }
}
