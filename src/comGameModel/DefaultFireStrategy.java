package comGameModel;

/**
 * @author ������
 * @version 1.0
 */
public class DefaultFireStrategy implements FireStrategy {//Ĭ�Ͽ������

    @Override
    public void fire(Tank t) {

        int bx = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;//̹�˷����ӵ���λ��
        int by = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;//̹�˷����ӵ���λ��

        new Bullet(bx, by, t.dir, t.group, t.gm);//��̹�˵�λ�÷�������ӵ�

//        if (t.group==Group.GOOD)new Thread()->new Audio("audio/ta")
    }
}
