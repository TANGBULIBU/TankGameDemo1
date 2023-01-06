package comGameModel;

import java.awt.*;

/**
 * @author ������
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

    public void paint(Graphics g) {//�����ӵ�
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);//ʹ�ñ�ը����ÿ����һ��++
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
