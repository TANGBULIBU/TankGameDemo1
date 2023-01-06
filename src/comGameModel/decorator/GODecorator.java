package comGameModel.decorator;

import comGameModel.GameModel;
import comGameModel.GameObject;

import java.awt.*;

/**
 * @author ¼¦ÍÈ×Ó
 * @version 1.0
 */
public abstract class GODecorator extends GameObject {

    GameObject go;

    public GODecorator(GameObject go) {

        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);


}
