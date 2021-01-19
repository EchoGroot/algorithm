package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class N皇后_51 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] arr;

        private List<List<String>> ans = new ArrayList<>();

        private int n;
        private int countQ = 0;


        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            arr = new int[n + 2][n + 2];
            for (int i = 0; i < n; i++) {
                dg(1, i + 1);
                arr[1][i + 1] = 0;
                countQ--;
            }
            return ans;
        }

        private void dg(int x, int y) {
            arr[x][y] = 1;
            countQ++;
            if (validate(x, y)) {
                if (countQ == n) {
                    output();
                    return;
                }
                if (x < n) {
                    x++;
                    for (int i = 0; i < n; i++) {
                        y = i + 1;
                        dg(x, y);
                        arr[x][y] = 0;
                        countQ--;
                    }
                }
            }
        }

        private void output() {
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    builder.append(arr[i + 1][j + 1] == 1 ? "Q" : ".");
                }
                strings.add(builder.toString());
            }
            ans.add(strings);
        }

        private boolean validate(int x, int y) {
            int countXQ = 0;
            int countYQ = 0;
            int countLUQ = 0;
            int countRDQ = 0;
            int countRUQ = 0;
            int countLDQ = 0;
            for (int i = 0; i < n; i++) {
                if (arr[x][i + 1] == 1) {
                    countYQ++;
                }
                if (arr[i + 1][y] == 1) {
                    countXQ++;
                }
                if (x - i > 0 && y - i > 0 && arr[x - i][y - i] == 1) {
                    countLUQ++;
                }
                if (x + i <= n && y + i <= n && arr[x + i][y + i] == 1) {
                    countRDQ++;
                }
                if (x - i > 0 && y + i <= n && arr[x - i][y + i] == 1) {
                    countRUQ++;
                }
                if (x + i <= n && y - i > 0 && arr[x + i][y - i] == 1) {
                    countLDQ++;
                }

            }
            if (countXQ > 1
                    || countYQ > 1
                    || countLUQ > 1
                    || countRDQ > 1
                    || countRUQ > 1
                    || countLDQ > 1
            ) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new N皇后_51().new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}
