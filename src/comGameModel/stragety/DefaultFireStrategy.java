package comGameModel.stragety;

import comGameModel.Bullet;
import comGameModel.GameModel;
import comGameModel.Tank;
import comGameModel.decorator.RectDecorator;
import comGameModel.decorator.TailDecorator;

import java.awt.*;

/**
 * @author ������
 * @version 1.0
 */
public class DefaultFireStrategy implements FireStrategy {//Ĭ�Ͽ������

    @Override
    public void fire(Tank t) {

        int bx = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;//̹�˷����ӵ���λ��
        int by = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;//̹�˷����ӵ���λ��

        //BUG new Bullet ���Լ�����һ��
        GameModel.getInstance().add(
                new RectDecorator(
                        new TailDecorator(
                        new Bullet(bx, by, t.dir, t.group))));//��̹�˵�λ�÷�������ӵ�

//        if (t.group==Group.GOOD)new Thread()->new Audio("audio/ta")
    }
}
