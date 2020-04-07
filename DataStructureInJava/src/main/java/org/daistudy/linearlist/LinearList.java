package org.daistudy.linearlist;

public interface LinearList<T> {
    /**
     * 判断线性表是否为空
     * @return 线性表为空是返回true
     */
    boolean isEmpty();

    /**
     * 清空线性表
     */
    void clear();

    /**
     * 获取指定位置的元素
     * @param i 线性表中的位置，从1开始（不从0开始）
     * @return 返回线性表中的第i个位置元素的值，未找到返回NULL
     */
    T getElement(int i);

    /**
     * 查找给定元素
     * @param element 给定元素
     * @return 返回给定元素在线性表中的位置序号，从1开始，未找到返回0
     */
    int locateElement(T element);

    /**
     * 插入新元素
     * @param i 插入的位置序号
     * @param element 插入的新元素
     */
    void insert(int i, T element);

    /**
     * 删除元素
     * @param i 删除元素的位置序号
     * @return 返回删除元素的值
     */
    T delete(int i);

    /**
     * 获取线性表长度
     * @return 返回线性表中元素个数
     */
    int getLength();
}
