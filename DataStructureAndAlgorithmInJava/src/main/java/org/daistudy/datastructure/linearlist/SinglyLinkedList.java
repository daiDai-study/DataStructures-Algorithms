package org.daistudy.datastructure.linearlist;

import org.daistudy.common.Node;
import org.daistudy.common.Util;

import java.util.Objects;

/**
 * 单链表
 *
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
    int size;

    @Override
    public abstract boolean isEmpty();

    @Override
    public abstract void clear();

    @Override
    public T getElement(int index) {
        Node<T> node = this.getNode(index);
        return node != null ? node.getElement() : null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public int getLengthWithTraverseNextNode() {
        Node<T> p = head;
        int serialTmp = 0;
        // p 一直指向下一个结点
        while (p != null) {
            serialTmp++;
            p = p.getNext();
        }
        return serialTmp;
    }

    public int getLengthWithTraverseCurrentNode() {
        if (head == null) {
            return 0;
        }
        Node<T> p = head;
        int serialTmp = 1;
        // p 一直指向当前结点
        while (p.getNext() != null) {
            serialTmp++;
            p = p.getNext();
        }
        return serialTmp;
    }

    /**
     * 找到指定位置序号的结点
     *
     * @param index 位置序号
     * @return 结点
     */
    public Node<T> getNode(int index) {
        Util.checkSerial(index, 0, this.size - 1);
        Node<T> p = head;
        int indexTmp = 0;
        while (p != null && indexTmp < index){
            indexTmp++;
            p = p.getNext();
        }
        return p;
    }

    @Override
    public int locateElement(T element) {
        if (Objects.isNull(element) || this.size == 0) {
            return -1;
        }
        Node<T> p = head;
        int indexTmp = 0;
        while (p != null && !element.equals(p.getElement())) {
            indexTmp++;
            p = p.getNext();
        }
        if (p == null) {
            indexTmp = -1;
        }
        return indexTmp;
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
        while (p != null) {
            builder.append(p.getElement()).append(",");
            p = p.getNext();
        }
        if (head != null) {
            builder.deleteCharAt(builder.lastIndexOf(","));
        }
        builder.append("]");
        return builder.toString();
    }
}
