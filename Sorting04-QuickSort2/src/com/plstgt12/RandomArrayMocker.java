package com.plstgt12;

/**
 * @author plstgt12
 * @create 2020-02-07 18:49
 */
public class RandomArrayMocker {

    int[] arr;

    public void mockRandomArray(int num, int data) {
        arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = (int) (Math.random() * data);
        }
    }

}
