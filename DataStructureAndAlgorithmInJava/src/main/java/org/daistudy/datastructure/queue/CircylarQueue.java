package org.daistudy.datastructure.queue;

/**
 * 循环队列
 * @param <T>
 */
public class CircylarQueue<T> implements Queue<T> {
    private T[] data;

    private int front; // 只想队头

    private int rear; // 指向队尾的下一个位置

    private int capacity;

    public CircylarQueue(int capacity){
        if(capacity < 1){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity + 1; // 为区分队空和队满两种情况，默认保留一个空闲单元
        this.rear = this.front = 0;
        this.data = (T[]) new Object[this.capacity];
    }

    @Override
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    @Override
    public void clear() {
        this.data = (T[]) new Object[capacity];
        this.rear = this.front = 0;
    }

    @Override
    public boolean enQueue(T element) {
        if(element == null || (this.rear + 1) % capacity == this.front){
            return false;
        }
        data[rear] = element;
        this.rear++;
        return true;
    }

    @Override
    public T deQueue() {
        if(this.rear == this.front){
            return null;
        }
        T r = data[front];
        data[front] = null;
        front++;
        return r;
    }

    @Override
    public int getLength() {
        return (this.rear - this.front + this.capacity) % this.capacity;
    }

    @Override
    public String show() {
        StringBuilder builder = new StringBuilder("[");
        if(!this.isEmpty()){
            int index;
            for (int i = 0; i < this.getLength() - 1; i++) {
                index = (front + i) % capacity;
                builder.append(data[index]).append(",");
            }
            index = (rear - 1 + capacity) % capacity;
            builder.append(data[index]);
        }
        builder.append("]");
        return builder.toString();
    }
}
