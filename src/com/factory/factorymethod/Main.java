package com.factory.factorymethod;

/**
 * @author ¼¦ÍÈ×Ó
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Movable m = new CarFactory().create();
        m.go();
    }
}