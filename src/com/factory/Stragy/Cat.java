package com.factory.Stragy;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Cat implements Comparable<Cat>{//泛型传入也需要是Cat 否则报错

    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat c) {//比较猫的大小 public int compareTo(Object o)
        //Cat c=(Cat) o;//强制转换
        if (this.weight < c.weight) return -1;
        else if (this.weight > c.weight) return 1;
        else return 0;
    }

//    public int compareTo(Object o) {//如果用新的Comparable 接口的话
//        Cat c=(Cat) o;
//        if (this.weight < c.weight) return -1;
//        else if (this.weight > c.weight) return 1;
//        else return 0;
//    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
