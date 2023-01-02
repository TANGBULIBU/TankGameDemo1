package comGameModel.cor;

import comGameModel.Bullet;
import comGameModel.Explode;
import comGameModel.GameObject;
import comGameModel.Tank;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {//前一个物体和子弹碰撞 后一个物体和坦克碰撞都算
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
//          b.collideWith(t);//bullet 和tank接触

            if (b.group == t.getGroup()) return true;//检测子弹是否是自己队伍的

            if (b.rect.intersects((t.rect))) {//碰撞的方法
                t.die();
                b.die();
                int eX = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                new Explode(eX, eY);
                return false;
            }

        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);//也就是谁是主动谁是被动 交换一下他们的主动权
        }
        return true;
    }
}
