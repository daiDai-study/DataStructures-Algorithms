package org.daistudy.common;

public class Node<T> {
    /**
     * 结点元素（数据域）
     */
    private T element;

    /**
     * 下一个结点（指针域），直接后继结点
     */
    private Node<T> next;

    public T getElement() {
        return element;
    }

//    public void setElement(T element) {
//        this.element = element;
//    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node(T element){
        this.element = element;
    }

    public Node(T element, Node<T> next){
        this.element = element;
        this.next = next;
    }
}
