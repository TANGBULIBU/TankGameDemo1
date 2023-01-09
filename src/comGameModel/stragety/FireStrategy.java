package comGameModel.stragety;

import comGameModel.Tank;

import java.io.Serializable;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public interface FireStrategy extends Serializable {//开火的策略模式
    void  fire(Tank t);
}