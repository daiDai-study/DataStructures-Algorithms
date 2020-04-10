package org.daistudy.datastructure.stack;

import org.omg.CORBA.Object;

import java.lang.reflect.Array;

public class SequenatialSharedStack<T> {
    private T[] data;
    
    private int capacity;
    
    private int top1; // 栈1
    private int top2; // 栈2
    
    public SequenatialSharedStack(Class<T> type, int capacity){
        this.capacity = capacity;
        this.data = (T[]) Array.newInstance(type, capacity);
        this.top1 = -1;
        this.top2 = capacity;
    }

    
    public boolean isEmpty(int stackNo) {
        if(stackNo == 1){ // 栈1
            return this.top1 == -1;
        }
        // 栈2
        return this.top2 == capacity;
    }

    
    public T getTop(int stackNo) {
        if(stackNo == 1){ // 栈1
            if(isEmpty(stackNo)){
                return null;
            }
            return this.data[this.top1];
        }
        // 栈2
        if(isEmpty(stackNo)){
            return null;
        }
        return this.data[this.top2];
    }

    
    public boolean push(T element, int stackNo) {
        // 栈满：top1 = top2 - 1
        if(top1 == top2 - 1 || element == null){
            return false;
        }
        if(stackNo == 1){
            ++this.top1;
            this.data[this.top1] = element;
            return true;
        }
        --this.top2;
        this.data[this.top2] = element;
        return true;
    }

    
    public T pop(int stackNo) {
        if(stackNo == 1){ // 栈1
            if(isEmpty(stackNo)){
                return null;
            }
            T r = this.data[this.top1];
            this.data[this.top1] = null;
            this.top1--;
            return r;
        }
        // 栈2
        if(isEmpty(stackNo)){
            return null;
        }
        T r = this.data[this.top2];
        this.data[this.top2] = null;
        this.top2++;
        return r;
    }


    public int getLength(int stackNo) {
        if(stackNo == 1){
            return this.top1+1;
        }
        return this.capacity - this.top2;
    }

    
    public String show(int stackNo) {
        StringBuilder builder = new StringBuilder("[");
        if(stackNo == 1){
            for (int i = 0; i < this.top1; i++) {
                builder.append(this.data[i]).append(",");
            }
            if(!this.isEmpty(stackNo)){
                builder.append(this.data[this.top1]);
            }
        }
        else{
            for (int i = this.capacity - 1; i > this.top2; i--) {
                builder.append(this.data[i]).append(",");
            }
            if(!this.isEmpty(stackNo)){
                builder.append(this.data[this.top2]);
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
