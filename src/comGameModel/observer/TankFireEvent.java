package comGameModel.observer;

import comGameModel.Tank;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class  TankFireEvent {
    Tank tank;

    public Tank getSource() {
        return tank;//哪个tank发射的 返回到自己
    }

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
}
