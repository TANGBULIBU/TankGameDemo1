package comGameModel;

import java.awt.*;
import java.io.Serializable;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public abstract class GameObject implements Serializable {//所有物体的父类
    public int x, y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();


}
