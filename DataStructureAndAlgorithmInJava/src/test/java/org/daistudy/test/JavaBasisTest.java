package org.daistudy.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Java基础语法测试")
public class JavaBasisTest {

    @DisplayName("引用对象置空")
    @Test
    void testSetNull(){
        Integer integer = new Integer(200);
        Integer integerCopy = integer;
        integer = null;
        assertEquals(200, integerCopy);
    }

    @DisplayName("Object对象强制转型，并设置")
    @Test
    void testSetInteger() {
        Object[] integers = new Object[2];
        integers[0] = 2;
        assertEquals(2, integers[0]);
    }

    @DisplayName("正则表达式测试")
    @Test
    void testRegular(){
        Pattern pattern = Pattern.compile("(\\d{2})\\:(\\d{2})\\:(\\d{2})");
        Matcher matcher = pattern.matcher("23:59:59");
        assertTrue(matcher.matches());
        assertEquals("时:23,分:59,秒:59", "时:"+matcher.group(1) + ",分:"+matcher.group(2)+",秒:"+matcher.group(3));

        String[] split = "a b  c".split("\\s");

        StringBuilder stringBuilder = new StringBuilder("123");
        assertEquals(0, stringBuilder.toString().indexOf('1'));
        assertEquals(0, stringBuilder.indexOf(new String(new char[]{'1'})));
    }
}
