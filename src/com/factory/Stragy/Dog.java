package com.factory.Stragy;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Dog implements Comparable<Dog>{//新增Dog类 调用Comparable接口
    //也是使用比较的方法 可以不用更改Sorter方法
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog d){
        if (this.food<d.food)return -1;
        else if (this.food>d.food)return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
