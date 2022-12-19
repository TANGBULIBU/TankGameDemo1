package com.factory.abstractfactory;

/**
 * @author ¼¦ÍÈ×Ó
 * @version 1.0
 */
public class ModernFactory extends AbstractFactory{

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
