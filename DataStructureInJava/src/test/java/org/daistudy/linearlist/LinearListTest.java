package org.daistudy.linearlist;

import org.daistudy.common.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("线性表")
class LinearListTest {
    @DisplayName("顺序表")
    @Test
    void testSequenatialListInteger(){
        LinearList<Integer> sequenatialList = new SequenatialList<>(10);
        this.testInteger(sequenatialList);
    }

    @DisplayName("单链表")
    @Test
    void testSinglyLinkedListInteger(){
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedListWithoutRear<>();
        this.testInteger(singlyLinkedList);
        int length = singlyLinkedList.getLength();
        int length1 = singlyLinkedList.getLengthWithTraverseCurrentNode();
        int length2 = singlyLinkedList.getLengthWithTraverseNextNode();
        assertTrue( length == length1 && length == length2);
    }

    @DisplayName("单链表（带尾结点）")
    @Test
    void testSinglyLinkedListWithRearInteger(){
        LinearList<Integer> singlyLinkedListWithRear = new SinglyLinkedListWithRear<>();
        this.testInteger(singlyLinkedListWithRear);
    }

    @DisplayName("单链表获取指定位置结点")
    @Test
    void testGetNode(){
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedListWithoutRear<>();
        assertTrue(singlyLinkedList.isEmpty());
        assertNull(singlyLinkedList.getNode(0));
        assertNull(singlyLinkedList.getNode(1));

        assertTrue(singlyLinkedList.append(1));
        assertNull(singlyLinkedList.getNode(0));
        assertNotNull(singlyLinkedList.getNode(1));
        assertNull(singlyLinkedList.getNode(2));

        assertTrue(singlyLinkedList.append(2));
        assertTrue(singlyLinkedList.append(3));
        assertEquals("[1,2,3]", singlyLinkedList.show());
        assertNull(singlyLinkedList.getNode(0));
        assertNotNull(singlyLinkedList.getNode(1));
        assertNotNull(singlyLinkedList.getNode(2));
        assertNotNull(singlyLinkedList.getNode(3));
        assertNull(singlyLinkedList.getNode(4));
        assertNull(singlyLinkedList.getNode(5));
    }


    void testInteger(LinearList<Integer> linearList){
        assertTrue(linearList.isEmpty());
        assertTrue(linearList.append(1));
        assertTrue(linearList.append(2));
        assertTrue(linearList.append(3));
        assertEquals("[1,2,3]", linearList.show());

        assertFalse(linearList.isEmpty());
        assertEquals(3, linearList.getLength());
        assertEquals(1, linearList.getElement(1));
        assertEquals(2, linearList.getElement(2));
        assertEquals(3, linearList.getElement(3));
        assertThrows(IllegalArgumentException.class, ()->linearList.getElement(0));
        assertThrows(IllegalArgumentException.class, ()->linearList.getElement(4));

        assertEquals(1, linearList.locateElement(1));
        assertEquals(2, linearList.locateElement(2));
        assertEquals(3, linearList.locateElement(3));
        assertEquals(0, linearList.locateElement(4));
        assertEquals(0, linearList.locateElement(null));

        assertTrue(linearList.insert(2,4));
        assertTrue(linearList.insert(3,5));
        assertTrue(linearList.insert(6,6));
        assertEquals("[1,4,5,2,3,6]", linearList.show());
        assertThrows(IllegalArgumentException.class, ()->linearList.insert(8,7));
        assertEquals(6, linearList.getLength());
        assertTrue(linearList.insert(4,7));
        assertTrue(linearList.insert(4,8));
        assertTrue(linearList.insert(4,9));
        assertTrue(linearList.insert(4,10));
        assertEquals("[1,4,5,10,9,8,7,2,3,6]", linearList.show());
//        assertFalse(linearList.insert(4,11));
//        assertFalse(linearList.append(12));
        assertFalse(linearList.insert(4,null));
        assertFalse(linearList.append(null));
        assertEquals(10, linearList.getLength());

        assertEquals(10, linearList.delete(4));
        assertEquals("[1,4,5,9,8,7,2,3,6]", linearList.show());
        assertEquals(9, linearList.getLength());
        assertThrows(IllegalArgumentException.class, ()->linearList.delete(10));
//        linearList.clear();
//        assertTrue(linearList.isEmpty());
    }
}