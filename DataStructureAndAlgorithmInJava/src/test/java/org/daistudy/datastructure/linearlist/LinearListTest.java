package org.daistudy.datastructure.linearlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("线性表")
class LinearListTest {
    @Test
    void test(){
        double[] a = {329.0,
            330.0,
            288.0,
            288.0,
            288.0,
            288.0,
            281.33334,
            280.0,
            280.0,
            280.0,
            330.6667,
            288.0,
            288.0,
            288.0,
            288.0,
            336.0,
            240.0,
            336.0,
            336.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0,
            288.0};
        double sum = Arrays.stream(a).sum();
        System.out.println(sum);
    }

    @DisplayName("ArrayList测试")
    @Test
    void testArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @DisplayName("顺序表")
    @Test
    void testSequenatialListInteger() {
        LinearList<Integer> sequenatialList = new SequenatialList<>(10);
        this.testInteger(sequenatialList);
    }

    @DisplayName("单链表")
    @Test
    void testSinglyLinkedListInteger() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedListWithoutRear<>();
        this.testInteger(singlyLinkedList);
        int length = singlyLinkedList.getSize();
        int length1 = singlyLinkedList.getLengthWithTraverseCurrentNode();
        int length2 = singlyLinkedList.getLengthWithTraverseNextNode();
        assertTrue(length == length1 && length == length2);
    }

    @DisplayName("单链表（带尾结点）")
    @Test
    void testSinglyLinkedListWithRearInteger() {
        LinearList<Integer> singlyLinkedListWithRear = new SinglyLinkedListWithRear<>();
        this.testInteger(singlyLinkedListWithRear);
    }

    @DisplayName("单链表获取指定位置结点")
    @Test
    void testGetNode() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedListWithoutRear<>();
        assertTrue(singlyLinkedList.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.getNode(0));
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.getNode(1));

        assertTrue(singlyLinkedList.append(1));
        assertNotNull(singlyLinkedList.getNode(0));
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.getNode(1));
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.getNode(2));

        assertTrue(singlyLinkedList.append(2));
        assertTrue(singlyLinkedList.append(3));
        assertEquals("[1,2,3]", singlyLinkedList.show());
        assertNotNull(singlyLinkedList.getNode(0));
        assertNotNull(singlyLinkedList.getNode(1));
        assertNotNull(singlyLinkedList.getNode(2));
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.getNode(3));
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.getNode(4));
        assertThrows(IllegalArgumentException.class, () -> singlyLinkedList.getNode(5));
    }


    void testInteger(LinearList<Integer> linearList) {
        assertTrue(linearList.isEmpty());
        assertTrue(linearList.append(1));
        assertTrue(linearList.append(2));
        assertTrue(linearList.append(3));
        assertEquals("[1,2,3]", linearList.show());

        assertFalse(linearList.isEmpty());
        assertEquals(3, linearList.getSize());
        assertEquals(1, linearList.getElement(0));
        assertEquals(2, linearList.getElement(1));
        assertEquals(3, linearList.getElement(2));
        assertThrows(IllegalArgumentException.class, () -> linearList.getElement(-1));
        assertThrows(IllegalArgumentException.class, () -> linearList.getElement(3));

        assertEquals(0, linearList.locateElement(1));
        assertEquals(1, linearList.locateElement(2));
        assertEquals(2, linearList.locateElement(3));
        assertEquals(-1, linearList.locateElement(4));
        assertEquals(-1, linearList.locateElement(null));

        assertTrue(linearList.insert(1, 4));
        assertTrue(linearList.insert(2, 5));
        assertTrue(linearList.insert(5, 6));
        assertEquals("[1,4,5,2,3,6]", linearList.show());
        assertThrows(IllegalArgumentException.class, () -> linearList.insert(8, 7));
        assertEquals(6, linearList.getSize());
        assertTrue(linearList.insert(3, 7));
        assertTrue(linearList.insert(3, 8));
        assertTrue(linearList.insert(3, 9));
        assertTrue(linearList.insert(3, 10));
        assertEquals("[1,4,5,10,9,8,7,2,3,6]", linearList.show());
//        assertFalse(linearList.insert(4,11));
//        assertFalse(linearList.append(12));
        assertFalse(linearList.insert(4, null));
        assertFalse(linearList.append(null));
        assertEquals(10, linearList.getSize());

        assertEquals(10, linearList.delete(3));
        assertEquals("[1,4,5,9,8,7,2,3,6]", linearList.show());
        assertEquals(9, linearList.getSize());
        assertThrows(IllegalArgumentException.class, () -> linearList.delete(10));
//        linearList.clear();
//        assertTrue(linearList.isEmpty());
    }
}