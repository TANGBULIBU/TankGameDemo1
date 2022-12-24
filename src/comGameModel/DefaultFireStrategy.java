package comGameModel;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class DefaultFireStrategy implements FireStrategy {//默认开火策略

    @Override
    public void fire(Tank t) {

        int bx = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;//坦克发射子弹的位置
        int by = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;//坦克发射子弹的位置

        new Bullet(bx, by, t.dir, t.group, t.gm);//从坦克的位置发射出来子弹

//        if (t.group==Group.GOOD)new Thread()->new Audio("audio/ta")
    }
}
