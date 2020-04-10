package org.daistudy.datastructure.linearlist;

/**
 * 线性表
 * @param <T>
 */
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
     * @param serial 线性表中的位置序号，从1开始（不从0开始），位置序号超出范围（1~length）时抛出IllegalArgumentException
     * @return 返回线性表中的第serial个位置元素的值
     */
    T getElement(int serial);

    /**
     * 查找给定元素
     * @param element 给定元素，给定元素为null时，返回0
     * @return 返回给定元素在线性表中匹配的第一个元素（从左至右）的位置序号，从1开始，未找到返回0
     */
    int locateElement(T element);

    /**
     * 插入新元素
     * @param serial 插入的位置序号，位置序号超出范围(1~length+1)时抛出IllegalArgumentException
     * @param element 插入的新元素，给定元素为null时返回false
     * @return 返回插入成功与否，如果成功，返回true，[针对顺序表，线性表满员时返回false]
     */
    boolean insert(int serial, T element);

    /**
     * 在线性表的末尾附加新元素
     * @param element 附加的新元素，给定元素为null时返回false
     * @return 返回附加成功与否，如果成功，返回true，[针对顺序表，线性表满员时返回false]
     */
    boolean append(T element);

    /**
     * 删除指定位置的元素
     * @param serial 删除元素的位置序号,位置序号超出范围（1~length）时抛出IllegalArgumentException
     * @return 返回删除元素的值
     */
    T delete(int serial);

    /**
     * 获取线性表长度
     * @return 返回线性表中元素个数
     */
    int getLength();

    /**
     * 显示线性表中的元素
     * @return 元素列表字符串，如[1,2,3]或['string','java','c#']
     */
    String show();
}
