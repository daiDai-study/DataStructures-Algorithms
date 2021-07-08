package org.daistudy.common;

public class Util {
    /**
     * 检查位置序号
     *
     * @param serial 位置序号
     * @param start  范围的开始，包含开始
     * @param end    范围的结束，包括结束
     */
    public static void checkSerial(int serial, int start, int end) {
        if (serial < start || serial > end) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 序号转成数组下标
     *
     * @param serial 序号
     * @return 数组下标
     */
    public static int serial2Index(int serial) {
        return serial - 1;
    }

    /**
     * 数组下表转成序号
     *
     * @param index 数组下标
     * @return 序号
     */
    public static int index2Serial(int index) {
        return index + 1;
    }
}
