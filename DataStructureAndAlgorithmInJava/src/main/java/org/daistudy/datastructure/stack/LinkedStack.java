package org.daistudy.datastructure.stack;

import org.daistudy.common.Node;

import java.util.Objects;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;

    private int length;

    public LinkedStack(){
        this.top = null;
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0 && this.top == null;
    }

    @Override
    public void clear() {
        this.top = null;
        this.length = 0;
    }

    @Override
    public T getTop() {
        return this.top != null ? this.top.getElement() : null;
    }

    @Override
    public boolean push(T element) {
        if(Objects.isNull(element)){
            return false;
        }
        Node node = new Node(element, this.top);
        this.top = node;
        this.length++;
        return true;
    }

    @Override
    public T pop() {
        if(this.length == 0){
            return null;
        }
        T r = this.top.getElement();
        this.top = this.top.getNext();
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
        Node<T> p = this.top;
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
