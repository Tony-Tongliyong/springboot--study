package com.wuxin.tong.controller.algorithm;

/**
 * @author: tongly
 * @contact:wuxin@yscredit.com
 * @file: QKSORT
 * @time: 2019/2/12 10:23
 * @desc:
 */
public class QKSORT {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int[] a = {12,213,2123,230,4366,56,235,56,215,78,234,578,223,565,21,785,237,578,1412,3423,126,213,2123,23,43,56,23,56,21,78,23,578,2214};
        int[] b = quickSort(a,0,a.length-1);
        for(int i=0;i<b.length;i++) {
            System.out.println(b[i]);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
    private static int[] quickSort(int[]  a ,int left,int right) {
        if(left < right){
            int i,j,t,temp;
            //temp中存的就是基准数
            temp = a[left];
            i = left;
            j = right;
            while(i!=j)
            {
                //顺序很重要，要先从有边开始找
                while(a[j] >= temp && i<j) {
                    j--;
                }
                //再找左边的
                while(a[i] <= temp && i<j) {
                    i++;
                }
                //交换两个数在数组中的位置
                if(i < j)
                {
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
            //最终将基准数归位
            a[left] = a[i];
            a[i] = temp;
            //继续处理左边的，这里是一个递归的过程
            quickSort(a,left,i-1);
            //继续处理右边的 ，这里是一个递归的过程
            quickSort(a,i+1,right);
        }
        return a;
    }

}