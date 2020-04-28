package com.plstgt12;

/**
 * @author plstgt12
 * @create 2020-02-02 22:07
 *
 * 一、快速排序1的基本思想
 *    第一轮以第一个元素为基准元素，最终会以该元素为基准，在左边的元素比该元素小，
 * 在右边的比该元素大。
 *    首先定义一个temp用来存放第一个元素，其次定义一个index用于记录小于第一个元素
 * 的下标（在这里下标值实际上为小于temp的元素的个数）;
 *    在本次循环结束后会将第一个元素与下标为index的元素进行交换，完成本轮排序；下
 * 一轮会分别对[0, index - 1]和[index + 1, arr.length]位置的元素进行同样的操作，
 * 得到最终的结果。
 *
 * 二、快速排序的终止条件
 *    对于[low, high]而言，当low > high时需要跳出循环，因此在定义方法的时候返回
 * 值类型为void比较好。
 *
 * 三、快速排序的时间复杂度
 *    第一轮：1次，第二轮：2次，第三轮：4次，...，第 k 轮: 1次，则：n / (2 ^ k) = 1, k = log_{2}n
 *    因此时间复杂度为: k * 2^k = O(nlogn)
 *
 * 四、快速排序的空间复杂度
 *    由于在这里引入了两个临时变量temp和temp1，因此空间复杂度即为快速排序的总次数，即为O(logn)
 *
 * 五、快速排序是不稳定的
 *    比如序列[5, 3A, 6, 3B]，经过第一轮快速排序后会变为[3B, 3A, 6, 5]，说明快速排序是不稳定的。
 */
public class Code01_QuickSortTest2 {

    public static void main(String[] args) {
        //排序前的数组
        //int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};

        /*
        随机生成num个[0, data - 1]数字构成的数组
         */
        int num = 8;
        RandomArrayMocker rm = new RandomArrayMocker();
        rm.mockRandomArray(num, 100);
        int[] arr = rm.arr;

        System.out.println("排序前的数组为:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        quickSort2(arr, 0, arr.length - 1);

        System.out.println();
        System.out.println("排序后的数组为:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void quickSort2(int[] arr, int left, int right) {

        if(left >= right) return;

        int index = left;
        int temp = arr[left];

        for(int i = left + 1; i <= right; i++) {

            if(arr[i] < temp) {
                index++;
                int temp1 = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp1;
            }
        }

        if(index != left) {
            arr[left] = arr[index];
            arr[index] = temp;
        }

        quickSort2(arr, left, index - 1);
        quickSort2(arr, index + 1, right);

    }
}
