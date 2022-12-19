package com.factory.Stragy;

import java.util.Arrays;

/**
 * @author º¶Õ»◊”
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //int [] a={9,2,3,5,7,1,4};
        Cat [] c={new Cat(3,3),new Cat(5,5),new Cat(1,1)};
        Dog[] a={new Dog(3),new Dog(5),new Dog(2)};
        Sorter sorter = new Sorter();//≈≈–Ú¿‡
        sorter.sort(a,new DogComparator());
        System.out.println(Arrays.toString(a));

        sorter.sort(c,new CatWeightComparator());
        System.out.println(Arrays.toString(c));
    }
}
