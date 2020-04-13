package org.daistudy.datastructure.queue;

import org.daistudy.common.Node;

/**
 * 链队列
 * @param <T>
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front; // 头结点
    private Node<T> rear; // 尾结点
    private int length; // 队列长度

    public LinkedQueue(){
        this.front = this.rear = null;
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0 && this.front == null && this.rear == null;
    }

    @Override
    public void clear() {
        this.front = this.rear = null;
        this.length = 0;
    }

    @Override
    public boolean enQueue(T element) {
        if(element == null){
            return false;
        }
        Node<T> node = new Node<>(element, null);
        if(this.isEmpty()){ // 队列空
            this.front = this.rear = node;
        } else{
            this.rear.setNext(node);
            this.rear = node;
        }

        this.length++;
        return true;
    }

    @Override
    public T deQueue() {
        if(this.isEmpty()){
            return null;
        }
        T r = this.front.getElement();
        this.front = this.front.getNext();
        if(this.front == null){ // 删除了最后一个元素，需要将rear也置空
            this.rear = null;
        }
        this.length--;
        return r;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public String show() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> p = this.front;
        while(p != null){
            builder.append(p.getElement()).append(",");
            p = p.getNext();
        }
        if(!this.isEmpty()){
            builder.deleteCharAt(builder.lastIndexOf(","));
        }
        builder.append("]");
        return builder.toString();
    }
}
