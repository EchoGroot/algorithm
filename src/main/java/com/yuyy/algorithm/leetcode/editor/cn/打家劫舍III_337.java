package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class 打家劫舍III_337{

	public static void main(String[] args) {
		Solution solution = new 打家劫舍III_337().new Solution();
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
	    private Map<TreeNode,Integer> note=new HashMap<>();
    public int rob(TreeNode root) {
        if(note.containsKey(root)){
            return note.get(root);
        }
        if (root==null) {
            return 0;
        }
        int doIt = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int notDoIt = rob(root.left) + rob(root.right);
        int max = Math.max(doIt, notDoIt);
        note.put(root, max);
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
