package com.Study.tank;

/**
 * @author ������
 * @version 1.0
 */
public class DefaultFireStrategy implements FireStrategy{//Ĭ�Ͽ������

    @Override
    public void fire(Wall t) {

        int bx = t.x + Wall.WIDTH / 2 - Bullet.WIDTH / 2;//̹�˷����ӵ���λ��
        int by = t.y + Wall.HEIGHT / 2 - Bullet.HEIGHT / 2;//̹�˷����ӵ���λ��

        new Bullet(bx, by, t.dir, t.group, t.tf);//��̹�˵�λ�÷�������ӵ�

//        if (t.group==Group.GOOD)new Thread()->new Audio("audio/ta")
    }
}
