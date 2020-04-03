package org.daistudy.Common;

public class IntegerNode {
    /**
     * 节点的值
     */
    private int value;

    /**
     * 节点的下一个节点
     */
    private IntegerNode next;

    public IntegerNode(int value, IntegerNode next){
        this.value = value;
        this.next = next;
    }
}
