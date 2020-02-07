package com.plstgt12;

/**
 * @author plstgt12
 * @create 2020-02-07 18:10
 */
public class HeapSortTest {

    public static void main(String[] args) {

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

        HeapSort(arr);

        System.out.println();

        System.out.println("排序后的数组为:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }

    public static void HeapSort(int[] arr) {
        for(int i = arr.length - 1; i >= 1; i--) {
            HeapSortImpl(arr, i);

            /*
            此时数组的第1个数是数组从[0, i]的最大值，下面要将数组的第1个数和第i个数交换位置，即让第arr.length - i
            大的数字沉底
             */
            int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
        }
    }

    public static void HeapSortImpl(int[] arr, int num) {

        int index; //父节点的位置
        int ele; //子节点的值

        //i为二叉树的高度 - 1
        for(int i = (num - 1) / 2; i >= 0; i--) {

            index = 2 * i + 1;
            ele = arr[index];

            //如果右子节点的值大于左子节点，则index刷新为右子节点的位置，ele刷新为右子节点的值
            if(2 * i + 2 <= num && arr[index + 1] > arr[index]) {
                index++;
                ele = arr[index];
            }

            //如果父节点的值小于子节点的最大值，则父节点和最大的子节点交换位置
            if(arr[i] < arr[index]) {
                int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
            }
        }

    }
}
