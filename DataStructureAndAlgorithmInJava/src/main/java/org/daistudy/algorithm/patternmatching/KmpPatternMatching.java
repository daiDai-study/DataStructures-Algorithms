package org.daistudy.algorithm.patternmatching;

import com.sun.istack.internal.NotNull;
import org.apache.commons.lang3.StringUtils;

/**
 * KMP模式匹配算法及其改进
 */
public class KmpPatternMatching {

    /**
     * next
     * @param src 字符串
     * @return 返回给定字符串的 next 数组
     */
    public static int[] getNext(@NotNull String src){
        if(StringUtils.isEmpty(src)){
            throw new IllegalArgumentException();
        }
        int srcLength = src.length();
        int[] next = new int[srcLength];
        next[0] = -1;
        int i = 0, j = -1;
        while(i < srcLength - 1){
            if(j == -1 || src.charAt(i) == src.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 改进的 next
     * @param src 字符串
     * @return 返回给定字符串的 next 数组
     */
    public static int[] getNextImproved(@NotNull String src){
        if(StringUtils.isEmpty(src)){
            throw new IllegalArgumentException();
        }
        int srcLength = src.length();
        int[] next = new int[srcLength];
        next[0] = -1;
        int i = 0, j = -1;
        while(i < srcLength - 1){
            if(j == -1 || src.charAt(i) == src.charAt(j)){
                i++;
                j++;
                if(src.charAt(i) != src.charAt(j)){
                    next[i] = j;
                }else{
                    next[i] = next[j];
                }
            }else{
                j = next[j];
            }
        }
        return next;
    }

    public static int indexOf(String src, String sub, int start){
        int srcLength = src.length();
        int subLength = sub.length();
        if(start < 0 || srcLength - start < subLength){
            return -1;
        }
        int i = start;
        int j = 0;
        int[] next = getNext(sub);
        while(i < srcLength && j < subLength){
            if(j == -1 || src.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j]; // j 退回到合适位置，i 不变
            }
        }
        if(j == subLength){
            return i-j;
        }
        return -1;
    }
}
