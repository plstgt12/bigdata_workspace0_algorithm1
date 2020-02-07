package com.plstgt12;

/**
 * @author plstgt12
 * @create 2020-02-03 20:23
 *
 * 一、归并排序的基本思想
 *    采用的是"分治"的思想：首先第一轮将整个数组分成两部分，第二轮会将这两部分的每一部分再分成两部分，直到某一部分
 * 只剩下一个数字；然后会将这些有序序列进行合并。
 *
 * 二、归并排序的时间复杂度
 *    假设数组为arr，长度为n。当经过k次"分半"操作后，数组被分为只有一个元素的多个子数组，此时有：n / (2 ^ k) = 1，
 * k = log_{2}n；而每次需要对2^k个有序序列进行归并，则时间复杂度为k * 2^k = nlog_{2}n
 *
 * 三、归并排序的空间复杂度
 *    归并排序需要用到长度为n的临时数组，因此空间复杂度为O(n)。
 *
 * 四、归并排序是稳定的
 *    因为在两个有序子序列进行归并时，当左子序列的数字等于右子序列时，可以让左子序列先进入到归并后的序列中，
 * 做到相同数字的顺序不发生改变，因此归并排序是稳定的。
 */
public class MergeSortTest {

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

        mergeSort(arr, 0, arr.length - 1);

        System.out.println();
        System.out.println("排序后的数组为:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {

        if(left == right) return;

        int middle = (left + right) / 2;

        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    //对两个有序数组[left, middle]和[middle + 1, right]进行归并
    public static void merge(int[] arr, int left, int middle, int right) {

        //用临时数组temp存放归并后的数组
        int[] temp = new int[right - left + 1];
        int k = 0; //标记temp数组的位置

        int i = left, j = middle + 1; //分别用i和j表示两个子数组的初始位置
        while(i <= middle && j <= right) {

            while(i <= middle && arr[i] <= arr[j]) temp[k++] = arr[i++];
            while(j <= right && arr[j] < arr[i]) temp[k++] = arr[j++];

        }

        while(i <= middle) temp[k++] = arr[i++];
        while(j <= right) temp[k++] = arr[j++];

        //将归并后的数组赋值给原数组arr的[left, right]位置
        for(int k2 = 0; k2 < temp.length; k2++) {
            arr[left + k2] = temp[k2];
        }
    }
}
