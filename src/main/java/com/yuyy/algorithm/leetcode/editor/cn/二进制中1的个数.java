/**
 * @projectName java-training
 * @package com.yuyy.algorithm.leetcode.editor.cn
 * @className com.yuyy.algorithm.leetcode.editor.cn.二进制中1的个数
 */
package com.yuyy.algorithm.leetcode.editor.cn;

import org.junit.Test;

/**
 * 二进制中1的个数
 * @description 二进制中1的个数
 * @author 余游洋
 * @date 2020/11/16 下午4:37
 * @version 1.0
 */
public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
//        int count=0;
//        while(n!=0){
//            count+=n&1;
//            n>>>=1;
//        }
//        return count;
    }
    @Test
    public void test(){
        System.out.println(hammingWeight(11));
    }
}
