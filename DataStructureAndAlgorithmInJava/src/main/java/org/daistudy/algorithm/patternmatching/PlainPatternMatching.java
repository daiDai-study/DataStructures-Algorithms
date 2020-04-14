package org.daistudy.algorithm.patternmatching;

/**
 * 朴素模式匹配算法
 */
public class PlainPatternMatching {
    /**
     * 返回子串 sub 在主串 src 中从 start 及其之后位置中匹配的位置。
     * @param src 主串，长度n
     * @param sub 子串，长度m，m<=n
     * @param start 主串中开始匹配的位置，0<=start && n-start>=m
     * @return 第一个完全匹配的位置，如不存在，返回-1
     */
    public static int indexOf(String src, String sub, int start){
        int srcLength = src.length();
        int subLength = sub.length();
        if(start<0 || subLength>srcLength-start){
            return -1;
        }

        int i = start;
        int j = 0;
        while(i<srcLength && j<subLength){
            if(src.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }else{
                i=i-j+1; // i 退回到上次匹配首位的下一位
                j=0; // j 退回到子串的首位
            }
        }
        if(j==subLength){
            return i-j; // 返回上次匹配的首位
        }
        return -1;
    }
}
