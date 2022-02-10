package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class 扁平化嵌套列表迭代器_341 {

    public static void main(String[] args) {
        // Solution solution = new 扁平化嵌套列表迭代器_341().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        private List<NestedInteger> temp;

        public NestedIterator(List<NestedInteger> nestedList) {
            temp = new LinkedList<>(nestedList);
        }

        @Override
        public boolean hasNext() {
            while (!temp.isEmpty() && !temp.get(0).isInteger()) {
                List<NestedInteger> firstList = temp.remove(0).getList();
                for (int i = firstList.size() - 1; i >= 0; i--) {
                    temp.add(0, firstList.get(i));
                }
            }
            return !temp.isEmpty();
        }

        @Override
        public Integer next() {
            return temp.remove(0).getInteger();
        }
    }

    // public class NestedIterator implements Iterator<Integer> {
    //
    //     private Iterator<Integer> iterator;
    //     private List<Integer> result;
    //
    //     public NestedIterator(List<NestedInteger> nestedList) {
    //         result = new ArrayList<>();
    //         for (NestedInteger item : nestedList) {
    //             traverse(item);
    //         }
    //         iterator = result.iterator();
    //     }
    //
    //     public void traverse(NestedInteger nestedInteger) {
    //         if (nestedInteger.isInteger()) {
    //             result.add(nestedInteger.getInteger());
    //             return;
    //         }
    //         for (NestedInteger item : nestedInteger.getList()) {
    //             traverse(item);
    //         }
    //     }
    //
    //     @Override
    //     public Integer next() {
    //         return iterator.next();
    //     }
    //
    //     @Override
    //     public boolean hasNext() {
    //         return iterator.hasNext();
    //     }
    // }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
