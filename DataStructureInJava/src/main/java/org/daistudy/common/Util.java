package org.daistudy.common;

public class Util {
    /**
     * 检查位置序号
     * @param serial 位置序号
     * @param start 范围的开始，包含开始
     * @param end 范围的结束，包括结束
     */
    public static void checkSerial(int serial, int start, int end){
        if(serial<start || serial>end){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 检查元素是否为null
     * @param element 待检查元素
     * 如果元素为null，返回true
     */
    public static boolean elementIsNull(Object element){
        return element == null;
    }
}
