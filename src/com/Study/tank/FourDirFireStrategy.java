package com.Study.tank;

/**
 * @author ������
 * @version 1.0
 */
public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bx = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;//̹�˷����ӵ���λ��
        int by = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;//̹�˷����ӵ���λ��

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bx, by, dir, t.group, t.tf);//��̹�˵�λ�÷�������ӵ�
        }
    }
}
