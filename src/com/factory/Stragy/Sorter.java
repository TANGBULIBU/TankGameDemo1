package com.factory.Stragy;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Sorter<T> {//冒泡排序

    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {//前一个
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {//后一个
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;//也就是说第一个小的话取j 否则取minPos
            }
            swap(arr, i, minPos);
        }
    }

    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
