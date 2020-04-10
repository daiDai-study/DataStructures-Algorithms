package org.daistudy.datastructure.linearlist;

import org.daistudy.common.Util;

import java.util.Objects;

/**
 * 线性表的顺序存储结构（顺序表）
 * @param <T>
 */
public class SequenatialList<T> implements LinearList<T> {
    private T[] data;
    private int capacity;
    private int length;

    public SequenatialList(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException();
        }
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

    public T getElement(int serial) {
        Util.checkSerial(serial, 1, this.length);
        int index = this.serialT2Index(serial);
        return data[index];
    }

    public int locateElement(T element) {
        if (Objects.isNull(element)) {
            return 0;
        }
        for (int i = 0; i < this.length; i++) {
            if(element.equals(data[i])){
                return this.index2Serial(i);
            }
        }
        return 0;
    }

    // 插入位置及其后继元素逐个向后移动一位
    public boolean insert(int serial, T element) {
        if (Objects.isNull(element) || this.length >= this.capacity) {
            return false;
        }
        Util.checkSerial(serial, 1, this.length + 1);
        int index = this.serialT2Index(serial);
        for (int i = this.length-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = element;
        this.length++;
        return true;
    }

    public boolean append(T element) {
        return this.insert(this.length + 1, element);
    }

    // 删除位置的后继元素逐个向前移动一位
    public T delete(int serial) {
        T element = this.getElement(serial);
        int index = this.serialT2Index(serial);
        for (int i = index+1; i < this.length; i++) {
            data[i-1] = data[i];
        }
        data[this.length-1] = null; // 置空，去除无用引用
        this.length--;
        return element;
    }

    public int getLength() {
        return this.length;
    }

    /**
     * 序号转成数组下标
     * @param serial 序号
     * @return 数组下标
     */
    private int serialT2Index(int serial){
        return serial-1;
    }

    /**
     * 数组下表转成序号
     * @param index 数组下标
     * @return 序号
     */
    private int index2Serial(int index){
        return index+1;
    }

    @Override
    public String show() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.length-1; i++) {
            builder.append(data[i]).append(",");
        }
        if(this.length>0){
            builder.append(data[this.length-1]);
        }
        builder.append("]");
        return builder.toString();
    }


}
