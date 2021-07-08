package org.daistudy.datastructure.linearlist;

import org.daistudy.common.Node;
import org.daistudy.common.Util;

import java.util.Objects;

public class SinglyLinkedListWithRear<T> extends SinglyLinkedList<T> {
    /**
     * 尾结点
     */
    private Node<T> rear;

    public SinglyLinkedListWithRear() {
        this.head = this.rear = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.head = this.rear = null;
        this.size = 0;
    }

    @Override
    public boolean insert(int index, T element) {
        if (Objects.isNull(element)) {
            return false;
        }
        Util.checkSerial(index, 0, this.size);

        Node<T> pre = null, cur = null;
        if(index != 0){
            pre = this.getNode(index - 1);
        }
        if(index != this.size){
            cur = this.getNode(index);
        }
        Node<T> node = new Node<>(element);
        if (pre == null && cur == null) { // 空表，且插入到头结点
            node.setNext(null);
            this.head = this.rear = node;
            this.size++;
            return true;
        }
        if (pre == null && cur != null) { // 插入到头结点
            node.setNext(head);
            this.head = node;
            this.size++;
            return true;
        }
        if (pre != null) { // 插入到头结点的后驱结点或插入到链表末尾
            node.setNext(cur);
            pre.setNext(node);
            if (cur == null) { // 插入到链表末尾
                this.rear = node;
            }
            this.size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean append(T element) {
        if (Objects.isNull(element)) {
            return false;
        }
        Node<T> node = new Node<>(element, null);
        if (this.rear == null) {
            this.head = this.rear = node;
        } else {
            this.rear.setNext(node);
            this.rear = node;
        }
        this.size++;
        return true;
    }

    @Override
    public T delete(int index) {
        Util.checkSerial(index, 0, this.size - 1);
        // 上述检测，保证线性表至少有一个结点，即头结点一定不会为空
        T element = null;
        if (index == 0) {
            element = head.getElement();
            head = head.getNext();
            if (index == this.size - 1) {
                rear = null;
            }
            this.size--;
        } else {
            Node<T> pre = head;
            Node<T> p = head.getNext();
            int count = 1;
            while (p != null && count < index) {
                count++;
                pre = p;
                p = p.getNext();
            }
            element = p.getElement();
            pre.setNext(p.getNext());
            if (index == this.size - 1) {
                rear = pre;
            }
            this.size--;
        }

        return element;
    }
}
