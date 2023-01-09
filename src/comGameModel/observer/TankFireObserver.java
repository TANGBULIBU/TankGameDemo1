package comGameModel.observer;

import comGameModel.Tank;

import java.io.Serializable;

/**
 * @author ������
 * @version 1.0
 */
public interface TankFireObserver extends Serializable {
    void actionOnFire(TankFireEvent e);
}
