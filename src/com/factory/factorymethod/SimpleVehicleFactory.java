package com.factory.factorymethod;

/**
 * @author 鸡腿子
 * @version 1.0
 */

/*
简单工厂的拓展性不好
每次都要新写方法
针对每种产品新建
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        return new Car();
    }

    public Broom createBroom(){
        return new Broom();

    }
}
