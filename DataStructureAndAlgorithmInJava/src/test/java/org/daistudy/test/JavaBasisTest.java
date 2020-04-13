package org.daistudy.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testSetInteger(){
        Object[] integers = new Object[2];
        integers[0] = 2;
        assertEquals(2, integers[0]);
    }
}
