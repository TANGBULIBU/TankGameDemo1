package com.factory.factorymethod;

/**
 * @author ������
 * @version 1.0
 */
public class CarFactory {
    public  Car create(){
        System.out.println("a car created");
        return new Car();
    }
}
