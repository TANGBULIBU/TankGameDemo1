package comGameModel;

import java.awt.*;

/**
 * @author ������
 * @version 1.0
 */
public abstract class GameObject {//��������ĸ���
    public int x, y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();


}
