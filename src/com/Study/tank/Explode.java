package com.Study.tank;

import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Explode {

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;


    TankFrame tf = null;
    private int step = 0;


    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }


    public void paint(Graphics g) {//绘制子弹
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);//使用爆炸并且每进行一步++
        if (step >= ResourceMgr.explodes.length) {
            tf.explodes.remove(this);
        }




    }
}
