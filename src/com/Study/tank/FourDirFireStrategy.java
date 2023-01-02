package com.Study.tank;

/**
 * @author ������
 * @version 1.0
 */
public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(Wall t) {
        int bx = t.x + Wall.WIDTH / 2 - Bullet.WIDTH / 2;//̹�˷����ӵ���λ��
        int by = t.y + Wall.HEIGHT / 2 - Bullet.HEIGHT / 2;//̹�˷����ӵ���λ��

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bx, by, dir, t.group, t.tf);//��̹�˵�λ�÷�������ӵ�
        }
    }
}
