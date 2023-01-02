package comGameModel.cor;

import comGameModel.GameObject;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public interface Collider {//责任链模式
     boolean collide(GameObject o1, GameObject o2);

}
