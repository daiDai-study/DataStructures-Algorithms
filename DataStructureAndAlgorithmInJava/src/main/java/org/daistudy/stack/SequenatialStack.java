package org.daistudy.stack;

import javafx.util.Builder;
import org.daistudy.common.Util;

import java.util.Objects;

/**
 * 顺序栈
 * @param <T>
 */
public class SequenatialStack<T> implements Stack<T> {
    private T[] data;

    private int capacity;

    private int length;

    public SequenatialStack(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException();
        }
        this.length = 0;
        this.data = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public void clear() {
        this.length = 0;
        this.data = (T[]) new Object[capacity];
    }

    @Override
    public T getTop() {
        if(this.length == 0){
            return null;
        }
        return this.data[this.length-1];
    }

    @Override
    public boolean push(T element) {
        if(Objects.isNull(element) || this.length >= this.capacity){
            return false;
        }
        this.data[this.length++] = element;
        return true;
    }

    @Override
    public T pop() {
        if(this.length == 0){
            return null;
        }
        T r = this.data[this.length - 1];
        this.data[this.length - 1] = null;
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
        for (int i = 0; i < this.length - 1; i++) {
            builder.append(this.data[i]).append(",");
        }
        if(this.length != 0){
            builder.append(this.data[this.length-1]);
        }
        builder.append("]");
        return builder.toString();
    }
}
