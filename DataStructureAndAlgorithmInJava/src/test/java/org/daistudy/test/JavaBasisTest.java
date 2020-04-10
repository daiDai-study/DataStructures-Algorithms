package org.daistudy.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
