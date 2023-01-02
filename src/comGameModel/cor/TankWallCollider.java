package comGameModel.cor;

import comGameModel.Bullet;
import comGameModel.GameObject;
import comGameModel.Tank;
import comGameModel.Wall;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {//前一个物体和子弹碰撞 后一个物体和坦克碰撞都算
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;
//            b.collideWith(t);//bullet 和tank接触

            if (t.rect.intersects(w.rect)) {
                t.back();
            }

        } else if (o1 instanceof Wall && o2 instanceof Tank) {
             return collide(o2, o1);//也就是谁是主动谁是被动 交换一下他们的主动权
        }
        return true;
    }
}
