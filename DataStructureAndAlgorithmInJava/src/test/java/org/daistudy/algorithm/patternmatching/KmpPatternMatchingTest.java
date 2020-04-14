package org.daistudy.algorithm.patternmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("KMP模式匹配算法")
class KmpPatternMatchingTest {

    @DisplayName("next数组测试")
    @Test
    void getNext() {
        assertThrows(IllegalArgumentException.class, () -> KmpPatternMatching.getNext(null));
        assertThrows(IllegalArgumentException.class, () -> KmpPatternMatching.getNext(""));
        assertArrayEquals(new int[]{-1, 0, 0, 0, 0, 0}, KmpPatternMatching.getNext("abcdex"));
        assertArrayEquals(new int[]{-1, 0, 0, 0, 1, 2}, KmpPatternMatching.getNext("abcabx"));
        assertArrayEquals(new int[]{-1, 0, 0, 1, 2, 3, 1, 1, 2}, KmpPatternMatching.getNext("ababaaaba"));
    }

    @DisplayName("匹配测试")
    @Test
    void indexOf() {
        assertEquals(1, KmpPatternMatching.indexOf("abcd", "bc", 0));
        assertEquals(1, KmpPatternMatching.indexOf("abcd", "bc", 1));
        assertEquals(-1, KmpPatternMatching.indexOf("abcd", "bc", 2));
        assertEquals(0, KmpPatternMatching.indexOf("abcabcd", "abc", 0));
        assertEquals(3, KmpPatternMatching.indexOf("abcabcd", "abc", 1));
    }
}