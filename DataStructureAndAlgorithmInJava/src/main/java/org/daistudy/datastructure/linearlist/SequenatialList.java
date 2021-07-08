package org.daistudy.datastructure.linearlist;

import org.daistudy.common.Util;

import java.util.Objects;

/**
 * 线性表的顺序存储结构（顺序表）
 *
 * @param <T>
 */
public class SequenatialList<T> implements LinearList<T> {
    private T[] data;
    private int capacity;
    private int size;

    public SequenatialList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.data = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public T getElement(int index) {
        Util.checkSerial(index, 0, this.size - 1);
        return data[index];
    }

    public int locateElement(T element) {
        if (Objects.isNull(element)) {
            return -1;
        }
        for (int i = 0; i < this.size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // 插入位置及其后继元素逐个向后移动一位
    public boolean insert(int index, T element) {
        if (Objects.isNull(element) || this.size >= this.capacity) {
            return false;
        }
        Util.checkSerial(index, 0, this.size);
//        for (int i = this.size - 1; i >= index; i--) {
//            data[i + 1] = data[i];
//        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        this.size++;
        return true;
    }

    public boolean append(T element) {
        if (Objects.isNull(element) || this.size >= this.capacity) {
            return false;
        }
        data[this.size++] = element;
        return true;
    }

    // 删除位置的后继元素逐个向前移动一位
    public T delete(int index) {
        T element = this.getElement(index);
//        for (int i = index + 1; i < this.size; i++) {
//            data[i - 1] = data[i];
//        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[this.size - 1] = null; // 置空，去除无用引用
        this.size--;
        return element;
    }

    public int getSize() {
        return this.size;
    }



    @Override
    public String show() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.size - 1; i++) {
            builder.append(data[i]).append(",");
        }
        if (this.size > 0) {
            builder.append(data[this.size - 1]);
        }
        builder.append("]");
        return builder.toString();
    }


}
