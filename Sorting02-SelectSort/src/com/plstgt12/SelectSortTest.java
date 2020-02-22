package com.plstgt12;

/**
 * @author plstgt12
 * @create 2020-02-22 19:34
 *
 * 一、选择排序的基本思想（假设是从小到大排序）
 * 1、第一轮会以序列的第一个作为基准元素，将整个序列最小的元素与第一个元素交换，
 * 此时整个序列最小的会放在序列的第一个位置上。
 * 第二轮则会将整个序列第二小的放在序列的第二个位置上，后面按照类似的过程完成
 * n - 1轮比较，n表示序列的元素个数。
 * 2、对在这里用变量min记录下当前的最小元素，index记录下当前最小元素的位置。
 * 后面如果找到比min还小的元素，则刷新min和index的值
 * 3、在该轮比较中，如果index的位置没有发生变化，则不需要与基准元素进行交换(其实
 * index的位置就是基准元素!)
 *
 * 二、选择排序的终止条件
 *     无论初始序列如何，都需要进行n - 1轮比较
 *
 * 三、选择排序的时间复杂度
 * 1、元素的比较: (n - 1) + (n - 2) + ... + 1 = O(n^2)
 * 2、元素的交换: 3 * (n - 1)
 * 3、时间复杂度: O(n^2)
 *
 * 四、选择排序的空间复杂度
 * 1、在每轮进行比较时需要min记录该轮元素最小值，index记录最小值所在位置
 * 2、在元素交换时开辟一个临时变量temp
 * 3、空间复杂度: O(1)
 *
 * 五、选择排序是稳定的
 */
public class SelectSortTest {

    public static void main(String[] args) {
        int num = 8;
        RandomArrayMocker rm = new RandomArrayMocker();
        rm.mockRandomArray(num, 100);
        int[] arr = rm.arr;

        System.out.println("排序前的数组为:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        selectSort(arr);

        System.out.println();

        System.out.println("排序后的数组为:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static void selectSort(int[] arr) {

        int indexPerRound;
        int minPerRound;

        for(int i = 0; i < arr.length - 1; i++) {
            //每一轮会让第i小的数放在数组的第i个位置
            indexPerRound = i;
            minPerRound = arr[i];

            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < minPerRound) {
                    indexPerRound = j;
                    minPerRound = arr[j];
                }
            }

            if(indexPerRound != i) {
                int temp = arr[indexPerRound];
                    arr[indexPerRound] = arr[i];
                    arr[i] = temp;
            }

        }
    }
}
