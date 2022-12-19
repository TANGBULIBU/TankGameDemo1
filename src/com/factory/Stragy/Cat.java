package com.factory.Stragy;

/**
 * @author ������
 * @version 1.0
 */
public class Cat implements Comparable<Cat>{//���ʹ���Ҳ��Ҫ��Cat ���򱨴�

    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat c) {//�Ƚ�è�Ĵ�С public int compareTo(Object o)
        //Cat c=(Cat) o;//ǿ��ת��
        if (this.weight < c.weight) return -1;
        else if (this.weight > c.weight) return 1;
        else return 0;
    }

//    public int compareTo(Object o) {//������µ�Comparable �ӿڵĻ�
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
