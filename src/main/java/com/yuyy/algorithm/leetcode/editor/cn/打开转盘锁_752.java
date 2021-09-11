package com.yuyy.algorithm.leetcode.editor.cn;


import java.util.*;

public class 打开转盘锁_752{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private HashSet<String> deadendsSet;
    public int openLock(String[] deadends, String target) {
		initDeadendsSet(deadends);
		Queue<String> queue=new LinkedList<>();
		Set<String> visited=new HashSet<>();
		queue.add("0000");
		visited.add("0000");
		int step = 0;
		while (queue.size() > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String poll = queue.poll();
				if (compareDeadend(poll)){
					continue;
				}
				if (compareTarget(poll,target)){
					return step;
				}
				int[] arr=(int[])convert(poll);
				for (int j = 0; j < 4; j++) {
				    int[] tmp = new int[4];
				    tmp[0]=arr[0];
				    tmp[1] = arr[1];
				    tmp[2] = arr[2];
				    tmp[3] = arr[3];
					if (arr[j] > -9) {
						tmp[j] = arr[j]-1;
						addQueue(visited,tmp,queue);
					}
					if (arr[j] < 9) {
						tmp[j] = arr[j]+1;
						addQueue(visited,tmp,queue);
					}
				}
			}
			step++;
		}
		return -1;
    }

    private void addQueue(Set<String> visited, int[] tmp, Queue<String> queue){
		String convert = (String) convert(tmp);
		if (!visited.contains(convert)){
			queue.add(convert);
			visited.add(convert);
		}
	}

	private Object convert(Object obj) {
		if (obj instanceof String) {
			String str=(String) obj;
			boolean flag=true;
			int res[]=new int[4];
			int index=0;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '-') {
					flag=false;
					continue;
				}
				if (flag) {
				    res[index++] = c-'0';
				}else {
					res[index++] = 0-(c-'0');
					flag=true;
				}
			}
			return res;

		}else{
			int[] obj1 = (int[]) obj;
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < 4; i++) {
				result.append(obj1[i]);
			}
			return result.toString();
		}
	}

	private Boolean compareTarget(String curr,String target){
		return target.equals(convertAdd10(curr));
	}
	private String convertAdd10(String curr){
		int[] ints = (int[]) convert(curr);
		for (int i = 0; i < 4; i++) {
			if(ints[i]<0){
				ints[i]+=10;
			}
		}
		return(String)convert(ints);
	}
	private Boolean compareDeadend(String target){
		return deadendsSet.contains(convertAdd10(target));
	}

	private String convertToString(String str) {
		StringBuilder sb = new StringBuilder();
		for (char c :
				str.toCharArray()) {
			if (c!='-') {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	private void initDeadendsSet(String[] deadends) {
    	deadendsSet = new HashSet<String>();
		for (String deadend :
				deadends) {
			deadendsSet.add(deadend);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

	public static void main(String[] args) {
		Solution solution = new 打开转盘锁_752().new Solution();
		System.out.println(solution.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
	}
}
