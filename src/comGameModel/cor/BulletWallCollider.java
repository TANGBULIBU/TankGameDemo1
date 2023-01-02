package comGameModel.cor;

import comGameModel.Bullet;
import comGameModel.GameObject;
import comGameModel.Tank;
import comGameModel.Wall;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class BulletWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {//前一个物体和子弹碰撞 后一个物体和坦克碰撞都算
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
//            b.collideWith(t);//bullet 和tank接触

            if (b.rect.intersects(w.rect)) {
                b.die();
            }

        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
             return collide(o2, o1);//也就是谁是主动谁是被动 交换一下他们的主动权
        }
        return true;
    }
}
