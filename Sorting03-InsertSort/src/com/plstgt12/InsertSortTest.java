package com.plstgt12;

/**
 * @author plstgt12
 * @create 2020-02-22 19:34
 *
 * 一、插入排序的基本思想（假设是从小到大排序）
 *    假设数组arr的[0, k - 1]的元素已经按照从小到大的顺序排列，现在要将位置为k的数插入到已经排好顺序的子数组
 * 当中。首先让arr[k]与arr[k - 1]进行比较，如果arr[k] < arr[k - 1]，则两个数交换位置，arr[k - 1]与
 * arr[k - 2]进行同样的比较；否则已经找到要插入的位置（因为[0, k - 1]已经有序），结束本轮插入排序。
 *
 * 二、插入排序的时间复杂度
 * 1、元素的比较: 1 + 2 + ... + (n - 1) = O(n^2)
 * 2、元素的交换: 3 * (n - 1)
 * 3、时间复杂度: O(n^2)
 *
 * 三、插入排序的空间复杂度
 *    在arr[k] < arr[k - 1]时需要交换arr[k]与arr[k - 1]的位置，需要用到临时变量temp，因此空间复杂度
 * 为O(1)
 *
 * 四、插入排序是稳定的
 */
public class InsertSortTest {

    public static void main(String[] args) {
        int num = 8;
        RandomArrayMocker rm = new RandomArrayMocker();
        rm.mockRandomArray(num, 100);
        int[] arr = rm.arr;

        System.out.println("排序前的数组为:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        insertSort(arr);

        System.out.println();

        System.out.println("排序后的数组为:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static void insertSort(int[] arr) {

        for(int i = 1; i < arr.length; i++) {

            //会将数组第i位置的数放在数组[0, i - 1]的合适位置
            for(int j = i - 1; j >= 0; j--) {

                if(arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                } else {
                    break;
                }

            }
        }
    }


}
