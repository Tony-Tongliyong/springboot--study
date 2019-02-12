package com.wuxin.tong.controller.algorithm;

/**
 * @author: tongly
 * @contact:wuxin@yscredit.com
 * @file: InsertionSort
 * @time: 2019/2/12 10:33
 * @desc:
 */
public class InsertionSort {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int[] a = {12,2123,23,43,56,23,56,21,78,23,578,2214};
        int[] b = insertSort(a);
        for(int i= 0;i<b.length;i++){
            System.out.println(b[i]);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
    private static int[] insertSort(int[] a) {
        //直接插入排序
        for (int i = 1; i < a.length; i++) {
            //待插入元素
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的往后移动一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //插入进来
            a[j + 1] = temp;
        }
        return a;
    }
}