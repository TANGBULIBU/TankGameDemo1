package com.factory.Stragy;

/**
 * @author ������
 * @version 1.0
 */
public class Sorter<T> {//ð������

    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {//ǰһ��
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {//��һ��
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;//Ҳ����˵��һ��С�Ļ�ȡj ����ȡminPos
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
