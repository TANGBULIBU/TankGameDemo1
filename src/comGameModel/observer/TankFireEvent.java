package comGameModel.observer;

import comGameModel.Tank;

/**
 * @author ������
 * @version 1.0
 */
public class  TankFireEvent {
    Tank tank;

    public Tank getSource() {
        return tank;//�ĸ�tank����� ���ص��Լ�
    }

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
}
