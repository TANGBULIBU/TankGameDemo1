package comGameModel.observer;

import comGameModel.Tank;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class TankFireHandler implements TankFireObserver {
    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();//拿到是从哪个坦克发出的
        t.fire();//让他fire
    }
}
