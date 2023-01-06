package comGameModel;

import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public abstract class GameObject {//所有物体的父类
    public int x, y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();


}
