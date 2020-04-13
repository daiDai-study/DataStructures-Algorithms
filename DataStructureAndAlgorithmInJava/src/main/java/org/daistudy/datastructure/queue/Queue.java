package org.daistudy.datastructure.queue;

public interface Queue<T> {
    /**
     * 判断队列是否为空
     * @return 队列为空是返回true
     */
    boolean isEmpty();

    /**
     * 清空队列
     */
    void clear();

    /**
     * 入队
     * @param element 附加的新元素，给定元素为null时返回false
     * @return 返回附加成功与否，如果成功，返回true，[针对顺序表，队列满员时返回false]
     */
    boolean enQueue(T element);

    /**
     * 出队
     * @return 返回出队元素的值，如果为空表，返回null
     */
    T deQueue();

    /**
     * 获取队列长度
     * @return 返回队列中元素个数
     */
    int getLength();

    /**
     * 显示队列中的元素
     * @return 元素列表字符串，如[1,2,3]或['string','java','c#']
     */
    String show();
}
