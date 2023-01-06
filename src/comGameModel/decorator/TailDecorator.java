package comGameModel.decorator;

import comGameModel.GameObject;

import java.awt.*;

/**
 * @author ������
 * @version 1.0
 */
public class TailDecorator extends GODecorator{

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {

        this.x = go.x;
        this.y = go.y;//��ȡ�ӵ�λ��ʱ��Ҫ�����ӵ��ı仯���仯
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.red);
        g.drawLine(go.x, go.y, go.x+getWidth(), go.y+getHeight());
        g.setColor(c);

    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }

}
