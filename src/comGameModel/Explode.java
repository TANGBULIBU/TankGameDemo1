package comGameModel;

import java.awt.*;

/**
 * @author ������
 * @version 1.0
 */
public class Explode extends GameObject{

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;


    GameModel gm = null;
    private int step = 0;


    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }


    public void paint(Graphics g) {//�����ӵ�
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);//ʹ�ñ�ը����ÿ����һ��++
        if (step >= ResourceMgr.explodes.length) {
            gm.remove(this);
        }




    }
}