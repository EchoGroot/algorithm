/**
 * @projectName java-training
 * @package com.yuyy.algorithm.leetcode.editor.cn
 * @className com.yuyy.algorithm.leetcode.editor.cn.剪绳子
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.yuyy.algorithm.leetcode.editor.cn;

import org.junit.Test;

/**
 * 剪绳子
 * @description
 * @author 余游洋
 * @date 2020/10/28 9:18
 * @version 1.0
 */
public class 剪绳子 {
    private int[] arrMax;

    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        arrMax = new int[60];
        arrMax[0] = 0;
        arrMax[1] = 1;
        arrMax[2] = 2;
        arrMax[3] = 3;
        arrMax[4] = 4;
        for (int i = 5; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= (i >> 1); j++) {
                max = Math.max(arrMax[j] * arrMax[i - j], max);
            }
            arrMax[i] = max;
        }
        return arrMax[n];
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(12));
    }
}
