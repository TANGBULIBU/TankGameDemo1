package comGameModel.observer;

import comGameModel.Tank;

/**
 * @author ������
 * @version 1.0
 */
public class TankFireHandler implements TankFireObserver {
    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();//�õ��Ǵ��ĸ�̹�˷�����
        t.fire();//����fire
    }
}
