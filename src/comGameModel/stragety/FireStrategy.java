package comGameModel.stragety;

import comGameModel.Tank;

import java.io.Serializable;

/**
 * @author ������
 * @version 1.0
 */
public interface FireStrategy extends Serializable {//����Ĳ���ģʽ
    void  fire(Tank t);
}