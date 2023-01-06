package comGameModel;

import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Explode extends GameObject {

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();


    private int step = 0;


    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {//绘制子弹
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);//使用爆炸并且每进行一步++
        if (step >= ResourceMgr.explodes.length) {
            GameModel.getInstance().remove(this);
        }

    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

}
