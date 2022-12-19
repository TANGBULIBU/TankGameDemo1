package com.factory.abstractfactory;

/**
 * @author ¼¦ÍÈ×Ó
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
