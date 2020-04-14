package org.daistudy.datastructure.linearlist;

import org.daistudy.common.Node;
import org.daistudy.common.Util;

import java.util.Objects;

/**
 * 单链表
 * @param <T>
 */
public abstract class SinglyLinkedList<T> implements LinearList<T> {
    /**
     * 头结点
     */
    Node<T> head;

    /**
     * 链表长度
     */
    int length;

    SinglyLinkedList(){
        this.head = null;
        this.length = 0;
    }

    @Override
    public abstract boolean isEmpty();

    @Override
    public abstract void clear();

    @Override
    public T getElement(int serial) {
        Util.checkSerial(serial, 1, this.length);
        // 上述检测，保证线性表至少有一个结点，即头结点一定不会为空
        Node<T> p = head;
        int count = 1;
        while(p.getNext() != null && count<serial){
            count++;
            p = p.getNext();
        }

        return p.getElement();
    }

    @Override
    public int getLength() {
        return this.length;
    }

    public int getLengthWithTraverseNextNode(){
        Node<T> p = head;
        int count = 0;
        // p 一直指向下一个结点
        while(p != null){
            count++;
            p = p.getNext();
        }
        return count;
    }

    public int getLengthWithTraverseCurrentNode(){
        if(head == null){
            return 0;
        }
        Node<T> p = head;
        int count = 1;
        // p 一直指向当前结点
        while(p.getNext() != null){
            count++;
            p = p.getNext();
        }
        return count;
    }

    /**
     * 找到指定位置序号的结点
     * @param serial 位置序号
     * @return 结点
     */
    public Node<T> getNode(int serial){
        if(head == null || serial < 1 || serial > this.length){
            return null;
        }
        Node<T> p = head;
        int count = 1;
        // p 一直指向当前结点
        while(p.getNext() != null && count < serial){
            count++;
            p = p.getNext();
        }
        return p;
    }

    @Override
    public int locateElement(T element) {
        if (Objects.isNull(element) || this.length == 0) {
            return 0;
        }
        Node<T> p = head;
        int count = 1;
        while(p.getNext() != null && !element.equals(p.getElement())){
            count++;
            p = p.getNext();
        }
        if(!element.equals(p.getElement())){
            count = 0;
        }
        return count;
    }

    @Override
    public abstract boolean insert(int serial, T element);

    @Override
    public abstract boolean append(T element);

    @Override
    public abstract T delete(int serial);

    @Override
    public String show() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> p = head;
        while(p != null){
            builder.append(p.getElement()).append(",");
            p = p.getNext();
        }
        if(head != null){
            builder.deleteCharAt(builder.lastIndexOf(","));
        }
        builder.append("]");
        return builder.toString();
    }
}
