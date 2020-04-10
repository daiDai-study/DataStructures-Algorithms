package org.daistudy.array;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class IntegerArray {
    /*
     * 数据
     * 默认初始化为0
     */
    private int[] data;

    /*
     * 容量
     */
    private int capacity;

    /*
     * 已存在数据的数量
     */
    private int count;

    /**
     * 构造
     * @param max 该值指定容量，必须为正整数
     */
    public IntegerArray(int max){
        if(max <= 0){
            throw new IllegalArgumentException("max must be positive.");
        }
        capacity = max;
        data = new int[max];
        count = 0;
    }

    /**
     * 构造
     * @param max 该值指定容量，必须为正整数
     * @param source 原始数据源
     */
    public IntegerArray(int max, int[] source){
        if(max <= 0 || source == null || source.length > max){
            throw new IllegalArgumentException();
        }
        capacity = max;
        data = Arrays.copyOf(source, max);
        count = source.length;
    }

    /**
     * 插入
     * 插入时，必须知道 index 的值，用户比较容易插入失败
     * 默认指定插入位置及其后面的元素依次向后移动一位
     * @param value 值
     * @param index 要插入的位置，从0开始
     * @return 插入是否成功，true为成功，false为失败
     */
    public boolean insert(int value, int index) throws OperationNotSupportedException {
        if(count == capacity){
            throw new OperationNotSupportedException("invalid operation.");
        }
        if(index < 0 || index > count){
            throw new IllegalArgumentException("index is invalid.");
        }

        for (int i = count-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = value;
        count++;
        return true;
    }

    /**
     * 附加
     * @param value 值
     * @return 附加是否成功，true为成功，false为失败
     */
    public boolean append(int value) throws OperationNotSupportedException{
        return this.insert(value, count);
    }

    /**
     * 删除
     * 删除从左到右第一个匹配的元素
     * @param value 值
     * @return 删除是否成功，true为成功，false为失败
     */
    public boolean deleteFirstLeft(int value){
        int index = this.findFirstLeft(value);
        if(index == -1){
            // TODO:没有匹配的元素，应该返回什么?
            return false;
        }
        for (int i = index+1; i < count; i++) {
            data[i-1] = data[i];
        }
        count--;
        return true;
    }

    /**
     * 更新
     * 更新从左到右第一个匹配的旧值
     * @param oldValue 旧值
     * @param newValue 新值
     * @return 更新是否成功，true为成功，false为失败
     */
    public boolean updateFirstLeft(int oldValue, int newValue){
        int index = this.findFirstLeft(oldValue);
        if(index == -1){
            return false;
        }
        data[index] = newValue;
        return true;
    }

    /**
     * 查找
     * @param value 值
     * @return 从左到右第一个匹配元素的位置，找不到返回-1
     */
    public int findFirstLeft(int value){
        for (int i = 0; i < count; i++) {
            if(value == data[i]){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除
     * 删除所有匹配的元素
     * @param value 值
     * @return 删除是否成功，true为成功，false为失败
     */
    public boolean delete(int value){
        int[] indexs = find(value);
        if(indexs == null){
            return false;
        }
        int indexCountAll = 0;
        for (int i = 0; i < count; i++) {
            boolean indexIsDelete = false;
            for (int j = 0; j < indexs.length; j++) {
                if(i == indexs[j]){
                    indexIsDelete = true;
                }
            }
            if(indexIsDelete){
                indexCountAll++;
            }else{
                data[i - indexCountAll] = data[i];
            }
        }
        count -= indexCountAll;
        return true;
    }

    /**
     * 更新
     * 更新所有的旧值
     * @param oldValue 旧值
     * @param newValue 新值
     * @return 更新是否成功，true为成功，false为失败
     */
    public boolean update(int oldValue, int newValue){
        int[] indexs = find(oldValue);
        if(indexs == null){
            return false;
        }
        for (int i = 0; i < indexs.length; i++) {
            data[indexs[i]] = newValue;
        }
        return true;
    }

    /**
     * 查找
     * @param value 值
     * @return 所有匹配元素的位置
     */
    public int[] find(int value){
        int[] indexs = new int[count];
        int indexCount = 0;
        for (int i = 0; i < count; i++) {
            if(value == data[i]){
                indexs[indexCount++] = i;
            }
        }
        if(indexCount > 0){
            return Arrays.copyOf(indexs, indexCount);
        }
        return null;
    }

    /**
     * 显示当前所有数据
     */
    public String showAll(){
        StringBuilder str = new StringBuilder("array:[");
        for (int i = 0; i < count - 1; i++) {
            str.append(data[i]).append(",");
        }
        str.append(data[count - 1]);
        str.append("]");
        str.append("\ncapacity:").append(this.capacity);
        return str.toString();
    }

    /**
     * @return 返回数组数据
     */
    public int[] getData(){
        return Arrays.copyOf(this.data, this.count);
    }
}
