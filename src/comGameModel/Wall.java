package comGameModel;


import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Wall extends GameObject {
    int w, h;

    public Rectangle rect;//方块模式

    public Wall(int x, int y, int w, int h) {//定义好了 就不需要移动了
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.rect = new Rectangle(x,y,w,h);
    }

    @Override
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }

}
