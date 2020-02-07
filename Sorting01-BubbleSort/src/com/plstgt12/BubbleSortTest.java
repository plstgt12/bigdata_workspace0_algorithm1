package com.plstgt12;

/**
 * @author plstgt12
 * @create 2020-02-01 18:11
 *
 * 一、冒泡排序的基本思想（假定为从小到大排序）
 * 1、第一轮从第一个元素开始，相邻的两个元素之间进行比较，如果左边的元素比右边大，则两个元素交换顺序，
 * 否则不交换顺序。经过一轮交换，最大的元素在最后一个位置。
 * 2、第二轮从第一个元素开始，一直到倒数第二个元素，以相同的方式进行交换。
 *
 * 二、冒泡排序的终止条件
 *     当该轮排序没有元素之间的交换，说明该序列已经完全有序，此时冒泡排序终止。
 *
 * 三、冒泡排序的时间复杂度
 * 1、元素的比较：第一轮需要n - 1次元素的比较，第二轮需要n - 2次元素的比较，以此类推，第n - 1轮需要1
 * 次元素之间的比较。
 * 2、元素的交换：每次交换需要执行3条语句，比如a[i]和a[i + 1]进行交换，则要执行以下三条语句：
 * （1）int temp = a[i]; (2)a[i] = a[j]; (3)a[j] = temp;
 * 3、时间复杂度：4 * ((n - 1) + (n - 2) + ... + 1)) = O(n^2)
 *
 * 四、冒泡排序的空间复杂度
 * 由于整个过程只需要在交换元素的时候引入一个临时变量temp，因此空间复杂度为O(1)
 *
 * 五、冒泡排序是稳定的
 * 稳定性：当出现相同元素时，排序后和排序前元素的相对位置没有发生改变
 */

public class BubbleSortTest {

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

        bubbleSort(arr);

        System.out.println();

        System.out.println("排序后的数组为:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {

            boolean loopFlag = false; //假设每次冒泡排序过程中，不发生相邻数字顺序的交换

            //每轮排序会将第i + 1大的数字放在数组的第arr.length - i位，比如当i = 0时，最大的数字放在数组的最后
            for(int j = 0; j < arr.length - 1 - i; j++) {

                if(arr[j + 1] < arr[j]) {
                    //数组相邻两个数字之间后一个比前一个小，则交换两个数的位置，并将loopFlag变为true
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    loopFlag = true;
                }
            }

            //此轮排序没有相邻数字的交换，说明该数组已经有序，冒泡排序结束！
            if(!loopFlag) {
                break;
            }
        }
    }
}
