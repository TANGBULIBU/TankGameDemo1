package comGameModel.observer;

import comGameModel.Tank;

/**
 * @author ������
 * @version 1.0
 */
public interface TankFireObserver {
    void actionOnFire(TankFireEvent e);
}
