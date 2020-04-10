package org.daistudy.datastructure.linearlist;

import org.daistudy.common.Node;
import org.daistudy.common.Util;

import java.util.Objects;

public class SinglyLinkedListWithRear<T> extends SinglyLinkedList<T> {
    /**
     * 尾结点
     */
    private Node<T> rear;

    public SinglyLinkedListWithRear(){
        this.head = this.rear = null;
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public void clear() {
        this.head = this.rear = null;
        this.length = 0;
    }

    @Override
    public boolean insert(int serial, T element) {
        if (Objects.isNull(element)) {
            return false;
        }
        Util.checkSerial(serial, 1, this.length + 1);
        Node<T> pre = this.getNode(serial - 1);
        Node<T> cur = this.getNode(serial);
        Node<T> node = new Node<>(element);
        if(pre == null && cur == null){ // 空表，且插入到头结点
            node.setNext(null);
            this.head = this.rear = node;
            this.length++;
            return true;
        }
        if(pre == null && cur != null){ // 插入到头结点
            node.setNext(head);
            this.head = node;
            this.length++;
            return true;
        }
        if(pre != null){ // 插入到头结点的后驱结点或插入到链表末尾
            node.setNext(cur);
            pre.setNext(node);
            if(cur == null){ // 插入到链表末尾
                this.rear = node;
            }
            this.length++;
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
        if(this.rear == null){
            this.head = this.rear = node;
        }else{
            this.rear.setNext(node);
            this.rear = node;
        }
        this.length++;
        return true;
    }

    @Override
    public T delete(int serial) {
        Util.checkSerial(serial, 1, this.length);
        // 上述检测，保证线性表至少有一个结点，即头结点一定不会为空
        T element = null;
        if(serial==1){
            element = head.getElement();
            head = head.getNext();
            if(serial == this.length){
                rear = null;
            }
            this.length--;
        }else{
            Node<T> pre = head;
            Node<T> p = head.getNext();
            int count = 2;
            while(p != null && count < serial){
                count++;
                pre = p;
                p = p.getNext();
            }
            element = p.getElement();
            pre.setNext(p.getNext());
            if(serial == this.length){
                rear = p;
            }
            this.length--;
        }

        return element;
    }
}
