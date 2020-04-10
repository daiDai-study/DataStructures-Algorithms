package org.daistudy.application.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("四则运算")
class FourArithmeticExpressionTest {
    private FourArithmeticExpression expression;

    @BeforeEach
    void setup(){
        expression = new FourArithmeticExpression("9 + ( 3 - 1 ) * 3 + 10 / 2");
    }

    @DisplayName("中缀表达式转成后缀表达式")
    @Test
    void infix2Suffix() {
        Assertions.assertEquals("9 3 1 - 3 * + 10 2 / +", expression.getSuffixExpression());

        expression = new FourArithmeticExpression("9 + ( 3 - 1 ) * ( 3 + 10 ) / 2");
        Assertions.assertEquals("9 3 1 - 3 10 + * 2 / +", expression.getSuffixExpression());
    }

    @DisplayName("后缀表达式的计算")
    @Test
    void calculate() {
        Assertions.assertEquals(20, expression.calculate());

        expression = new FourArithmeticExpression("9 + ( 3 - 1 ) * ( 3 + 10 ) / 2");
        Assertions.assertEquals(22, expression.calculate());
    }
}