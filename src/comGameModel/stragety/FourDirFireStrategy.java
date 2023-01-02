package comGameModel.stragety;

import comGameModel.Bullet;
import comGameModel.Dir;
import comGameModel.Tank;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bx = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;//坦克发射子弹的位置
        int by = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;//坦克发射子弹的位置

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bx, by, dir, t.group);//从坦克的位置发射出来子弹
        }
    }
}
