package org.daistudy.linearlist;

import org.daistudy.common.Node;
import org.daistudy.common.Util;

public class SinglyLinkedListWithoutRear<T> extends SinglyLinkedList<T> {

    public SinglyLinkedListWithoutRear(){
        super();
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0 && this.head == null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.length = 0;
    }

    @Override
    public boolean insert(int serial, T element) {
        if (Util.elementIsNull(element)) {
            return false;
        }
        Util.checkSerial(serial, 1, this.length + 1);
        Node<T> pre = this.getNode(serial - 1);
        Node<T> cur = this.getNode(serial);
        Node<T> node = new Node<>(element);
        if(pre == null && cur == null){ // 空表，且插入到头结点
            node.setNext(null);
            this.head = node;
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
            this.length++;
            return true;
        }
        return false;
    }

    @Override
    public boolean append(T element) {
        return insert(this.length+1, element);
    }

    @Override
    public T delete(int serial) {
        Util.checkSerial(serial, 1, this.length);
        // 上述检测，保证线性表至少有一个结点，即头结点一定不会为空
        T element = null;
        Node<T> pre = this.getNode(serial - 1);
        Node<T> cur = this.getNode(serial);
        if(pre == null && cur != null){ // 删除头结点
            element = cur.getElement();
            head.setNext(head.getNext());
            this.length--;
        }
        if(pre != null && cur != null){ // 删除头结点的后驱结点
            element = cur.getElement();
            pre.setNext(cur.getNext());
            this.length--;
        }
        return element;
    }
}
