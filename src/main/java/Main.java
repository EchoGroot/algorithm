/**
 * @projectName algorithm
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME.Main
 * @copyright Copyright 2021 Thunisoft, Inc All rights reserved.
 */

import java.util.HashSet;

/**
 * Main
 *
 * @author yuyouyang
 * @description
 * @date 2021/9/4 21:45
 */
class Node {
    int val;
    String str;

    @Override
    public boolean equals(Object o) {
        return ((Node) o).str.equals(this.str);
    }

    @Override
    public int hashCode() {
        return val;
    }

    public Node(int val, String str) {
        this.val = val;
        this.str = str;
    }
}

public class Main {

    public static void main(String[] args) {
        Node a = new Node(1, "a");
        Node b = new Node(1, "b");
        Node c = new Node(1, "c");
        Node d = new Node(1, "d");
        Node e = new Node(1, "e");
        Node f = new Node(1, "f");
        Node g = new Node(1, "g");
        Node h = new Node(1, "h");
        Node i = new Node(1, "i");
        Node j = new Node(1, "j");
        Node k = new Node(1, "k");
        HashSet<Node> nodes = new HashSet<>();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);
        nodes.add(g);
        nodes.add(h);
        nodes.add(i);
        nodes.add(j);
        nodes.add(k);
        System.out.println("扩容前");
        for (Node node : nodes) {
            System.out.print(node.str + ",");
        }
        System.out.println();
        nodes.add(new Node(2, "22"));
        nodes.add(new Node(3, "33"));
        nodes.add(new Node(4, "44"));
        nodes.add(new Node(5, "55"));
        System.out.println("扩容后");
        for (Node node : nodes) {
            System.out.print(node.str + ",");
        }
        System.out.println();

    }
}























