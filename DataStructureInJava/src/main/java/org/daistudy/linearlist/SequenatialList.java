package org.daistudy.linearlist;

public class SequenatialList<T> implements LinearList<T> {
    private T[] data;
    private int capacity;
    private int length;

    public SequenatialList(int capacity){
        this.data = (T[]) new Object[capacity];
        this.length = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void clear() {
        this.data = (T[]) new Object[capacity];
        this.length = 0;
    }

    public T getElement(int i) {
        return null;
    }

    public int locateElement(T element) {
        return 0;
    }

    public void insert(int i, T element) {

    }

    public T delete(int i) {
        return null;
    }

    public int getLength() {
        return this.length;
    }
}
