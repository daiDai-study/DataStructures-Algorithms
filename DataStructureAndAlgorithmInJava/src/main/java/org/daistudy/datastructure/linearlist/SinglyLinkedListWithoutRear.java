package org.daistudy.datastructure.linearlist;

import org.daistudy.common.Node;
import org.daistudy.common.Util;

import java.util.Objects;

public class SinglyLinkedListWithoutRear<T> extends SinglyLinkedList<T> {

    public SinglyLinkedListWithoutRear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.head = null;
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
            this.head = node;
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
            this.size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean append(T element) {
        if(Objects.isNull(element)){
            return false;
        }
        Node<T> tNode = new Node<>(element, null);
        if(head == null){
            head = tNode;
        }else{
            Node<T> tmp = head;
            while(tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.setNext(tNode);
        }
        this.size++;
        return true;
    }

    @Override
    public T delete(int index) {
        Util.checkSerial(index, 0, this.size - 1);
        // 上述检测，保证线性表至少有一个结点，即头结点一定不会为空
        T element = null;
        Node<T> pre = this.getNode(index - 1);
        Node<T> cur = this.getNode(index);
        if (pre == null && cur != null) { // 删除头结点
            element = cur.getElement();
            head.setNext(head.getNext());
            this.size--;
        }
        if (pre != null && cur != null) { // 删除头结点的后驱结点
            element = cur.getElement();
            pre.setNext(cur.getNext());
            this.size--;
        }
        return element;
    }
}
