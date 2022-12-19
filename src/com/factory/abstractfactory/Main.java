package com.factory.abstractfactory;

/**
 * @author ¼¦ÍÈ×Ó
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory f=new MagicFactory();
        Vehicle c=f.createVehicle();
        c.go();

        Weapon w=f.createWeapon();
        w.shoot();

        Food b=f.createFood();
        b.printName();
    }
}
