package com.factory.factorymethod;

/**
 * @author ������
 * @version 1.0
 */

/*
�򵥹�������չ�Բ���
ÿ�ζ�Ҫ��д����
���ÿ�ֲ�Ʒ�½�
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        return new Car();
    }

    public Broom createBroom(){
        return new Broom();

    }
}
