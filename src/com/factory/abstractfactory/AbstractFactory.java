package com.factory.abstractfactory;

/**
 * @author ������
 * @version 1.0
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();

}
