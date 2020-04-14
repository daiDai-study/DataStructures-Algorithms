package org.daistudy.algorithm.patternmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("朴素模式匹配算法")
class PlainPatternMatchingTest {

    @DisplayName("匹配测试")
    @Test
    void indexOf() {
        assertEquals(1, PlainPatternMatching.indexOf("abcd", "bc", 0));
        assertEquals(1, PlainPatternMatching.indexOf("abcd", "bc", 1));
        assertEquals(-1, PlainPatternMatching.indexOf("abcd", "bc", 2));
        assertEquals(0, PlainPatternMatching.indexOf("abcabcd", "abc", 0));
        assertEquals(3, PlainPatternMatching.indexOf("abcabcd", "abc", 1));
    }
}