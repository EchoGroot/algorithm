package com.yuyy.algorithm.leetcode.editor.cn;


/**
 * description: 旋转数组的最小数字 <br>
 * date: 2020/7/21 9:12 <br>
 * author: lenovo <br>
 * version: 1.0 <br>
 */
public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int start=0;
        int end=numbers.length-1;
        int mid = 0 ;
        while (numbers[start] >= numbers[end]) {
            if(end-start == 1){
                break;
            }
            mid = start + ((end - start)>>1);
            if(numbers[mid]>=numbers[start]){
                start = mid ;
            }else if(numbers[mid] <= numbers[end]){
                end = mid;
            }
        }
        System.out.println(numbers[end]);
        return numbers[end];
    }

    public static void main(String[] args) {
        旋转数组的最小数字 clazz = new 旋转数组的最小数字();
        System.out.println(clazz.minArray(new int[]{3, 4, 5, 1, 2}));
    }
}
