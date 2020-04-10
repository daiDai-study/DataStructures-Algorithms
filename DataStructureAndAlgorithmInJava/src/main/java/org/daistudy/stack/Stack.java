package org.daistudy.stack;

public interface Stack<T> {
    /**
     * 判断栈是否为空
     * @return 栈为空是返回true
     */
    boolean isEmpty();

    /**
     * 清空栈
     */
    void clear();

    /**
     * 获取栈顶元素
     * @return 返回栈顶元素的值，如果为空表，返回null
     */
    T getTop();

    /**
     * 进栈
     * @param element 附加的新元素，给定元素为null时返回false
     * @return 返回附加成功与否，如果成功，返回true，[针对顺序表，栈满员时返回false]
     */
    boolean push(T element);

    /**
     * 删除栈顶元素
     * @return 返回出栈元素的值，如果为空表，返回null
     */
    T pop();

    /**
     * 获取栈长度
     * @return 返回栈中元素个数
     */
    int getLength();

    /**
     * 显示栈中的元素
     * @return 元素列表字符串，如[1,2,3]或['string','java','c#']
     */
    String show();
}
