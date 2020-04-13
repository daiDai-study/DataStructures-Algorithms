package org.daistudy.datastructure.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("队列")
class QueueTest {

    @DisplayName("循环队列")
    @Test
    void testCircylarQueue(){
        Queue<Integer> queue = new CircylarQueue<>(5);
        test(queue);
    }

    @DisplayName("链队列")
    @Test
    void testLinkedQueue(){
        Queue<Integer> queue = new LinkedQueue<>();
        test(queue);
    }

    void test(Queue<Integer> queue){
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getLength());

        assertTrue(queue.enQueue(1));
        assertTrue(queue.enQueue(2));
        assertTrue(queue.enQueue(3));
        assertTrue(queue.enQueue(4));
        assertTrue(queue.enQueue(5));
        assertFalse(queue.enQueue(null));
        assertEquals(5, queue.getLength());
        assertEquals("[1,2,3,4,5]", queue.show());
        assertEquals(1, queue.deQueue());
        assertEquals(2, queue.deQueue());
        assertEquals("[3,4,5]", queue.show());
        queue.clear();
//        assertEquals(3, queue.deQueue());
//        assertEquals(4, queue.deQueue());
//        assertEquals(5, queue.deQueue());
        assertNull(queue.deQueue());
        assertTrue(queue.isEmpty());
    }

    @DisplayName("循环队列队满测试")
    @Test
    void testOverflow(){
        Queue<Integer> queue = new CircylarQueue<>(2);
        assertTrue(queue.enQueue(1));
        assertTrue(queue.enQueue(2));
        assertFalse(queue.enQueue(3));
    }

    @DisplayName("循环队列容量初始化测试")
    @Test
    void testCapacity(){
        assertThrows(IllegalArgumentException.class, () -> new CircylarQueue<>(0));
    }
}