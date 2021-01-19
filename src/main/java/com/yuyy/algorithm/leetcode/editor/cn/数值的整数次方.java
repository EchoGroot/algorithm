/**
 * @projectName java-training
 * @package com.yuyy.algorithm.leetcode.editor.cn
 * @className com.yuyy.algorithm.leetcode.editor.cn.数值的整数次方
 */
package com.yuyy.algorithm.leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 数值的整数次方
 * @description 数值的整数次方
 * @author 余游洋
 * @date 2020/11/16 下午7:10
 * @version 1.0
 */
public class 数值的整数次方 {

    private int[] arrTwo;
    private Map<Integer,Double> arrRes=new HashMap<>();


    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }

        arrTwo=new int[32];

        arrTwo[0]=1;
        arrTwo[1]=2;
        for (int i = 2; i < 32; i++) {
            arrTwo[i]=arrTwo[i-1]*2;
        }
        if (n<0){
            x=1/x;
            n=-n;
        }
        int i=2;


        arrRes.put(1,x);
        return func(x,n);
    }

    public double func(double x,int n){
        if (arrRes.containsKey(n)){
            return arrRes.get(n);
        }
        double res=x;
        int i=2;
        for ( ; n-arrTwo[i-1]>=0; i++) {
            res*=res;
            arrRes.put(arrTwo[i-1],res);
            if(n==arrTwo[i-1]){
                return res;
            }
        }
        res*=func(x,n-arrTwo[i-2]);
        return res;
    }



    @Test
    public void test(){
        System.out.println(myPow(0.00001, 2147483647));
    }
}
