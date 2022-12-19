package com.factory.Stragy;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public interface Comparable<T> {//<T>指定需要的类型 使用泛型 就不用类型转换

    int compareTo(T o);


}
