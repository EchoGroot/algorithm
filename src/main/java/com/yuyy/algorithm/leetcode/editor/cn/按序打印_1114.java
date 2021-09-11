package com.yuyy.algorithm.leetcode.editor.cn;

import java.util.concurrent.CountDownLatch;

public class 按序打印_1114{

	public static void main(String[] args) {
        Foo solution = new 按序打印_1114().new Foo();
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Foo {

	    private CountDownLatch c1=new CountDownLatch(1);
	    private CountDownLatch c2=new CountDownLatch(1);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        c1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        c1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
