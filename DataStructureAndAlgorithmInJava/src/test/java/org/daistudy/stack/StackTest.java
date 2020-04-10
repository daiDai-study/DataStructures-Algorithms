package org.daistudy.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("栈")
class StackTest {
    @DisplayName("顺序栈")
    @Test
    void testSequenatialStack(){
        Stack<Integer> sequenatialStack = new SequenatialStack<>(5);
        testCapacity(sequenatialStack, true);
        testPushAndPop(sequenatialStack);
        testClear(sequenatialStack);
    }

    @DisplayName("链栈")
    @Test
    void testLinkedStack(){
        Stack<Integer> linkedStack = new LinkedStack<>();
        testCapacity(linkedStack, false);
        testPushAndPop(linkedStack);
        testClear(linkedStack);
    }

    void testPushAndPop(Stack<Integer> stack){
        assertTrue(stack.isEmpty());
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertTrue(stack.push(4));
        assertTrue(stack.push(5));
        assertFalse(stack.push(null));
        assertEquals(5, stack.getLength());
        assertEquals(5, stack.getTop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.getLength());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
        assertNull(stack.getTop());
        assertTrue(stack.isEmpty());
    }

    void testClear(Stack<Integer> stack){
        assertTrue(stack.isEmpty());
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertTrue(stack.push(4));
        assertTrue(stack.push(5));
        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    void testCapacity(Stack<Integer> stack, boolean isSequenatial){
        assertTrue(stack.isEmpty());
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertTrue(stack.push(4));
        assertTrue(stack.push(5));

        if(isSequenatial){
            // 针对顺序栈（capacity:5）
            assertEquals("[1,2,3,4,5]", stack.show());
            assertFalse(stack.push(6));
        }
        else{
            // 针对链栈
            assertEquals("[5,4,3,2,1]", stack.show());
            assertTrue(stack.push(6));
            assertEquals("[6,5,4,3,2,1]", stack.show());
        }
        stack.clear();
        assertTrue(stack.isEmpty());
    }
}