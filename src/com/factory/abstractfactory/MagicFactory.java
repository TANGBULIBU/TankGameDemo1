package com.factory.abstractfactory;

/**
 * @author ������
 * @version 1.0
 */
public class MagicFactory extends AbstractFactory{

    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
