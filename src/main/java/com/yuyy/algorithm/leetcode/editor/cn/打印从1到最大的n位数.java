/**
 * @projectName java-training
 * @package com.yuyy.algorithm.leetcode.editor.cn
 * @className com.yuyy.algorithm.leetcode.editor.cn.打印从1到最大的n位数
 */
package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 打印从1到最大的n位数
 * @description 打印从1到最大的n位数
 * @author Yuyy
 * @date 2020/12/7 下午10:16
 * @version 1.0
 */
public class 打印从1到最大的n位数 {

    private Boolean flag;

    private String[] arr;

    private Map<String, String> map = new HashMap<>();

    private void init() {
        flag=true;
        map.put("0", "1");
        map.put("1", "2");
        map.put("2", "3");
        map.put("3", "4");
        map.put("4", "5");
        map.put("5", "6");
        map.put("6", "7");
        map.put("7", "8");
        map.put("8", "9");
        map.put("9", "0");
    }


    public int[] printNumbers(int n) {
        init();
        arr = new String[n];
        add(arr, 0);
        return null;
    }

    private void add(String[] arr, int i) {
        if (flag&&valid()) {
            return;
        }
        if ("9".equals(arr[i])) {
            add(arr, i + 1);
        }
        arr[i] = map.get(arr[i]);
    }

    private boolean valid() {
        for (int i = 0; i < arr.length; i++) {
            if(!"9".equals(arr[i])){
                return false;
            }
        }
        return true;
    }
}
