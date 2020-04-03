package org.daistudy.Array;

import org.junit.jupiter.api.*;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("自定义数组")
class IntegerArrayTest {
    private IntegerArray integerArray;

    @BeforeEach
    void setUp() {
        integerArray  = new IntegerArray(13, new int[]{2,3,4,5,6,4,5,6});
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("初始化")
    @Test
    void init(){
        assertArrayEquals(integerArray.getData(), new int[]{2,3,4,5,6,4,5,6});
        assertThrows(IllegalArgumentException.class, () -> new IntegerArray(-1, new int[]{2,3,4}));
        assertThrows(IllegalArgumentException.class, () -> new IntegerArray(1, new int[]{2,3,4}));
        assertThrows(IllegalArgumentException.class, () -> new IntegerArray(-1));
        assertArrayEquals(new IntegerArray(10).getData(), new int[0]);
    }

    @DisplayName("插入")
    @Test
    void insert() throws OperationNotSupportedException {
        assertTrue(this.integerArray.insert(7,1));
        assertTrue(this.integerArray.insert(8,3));
        assertTrue(this.integerArray.insert(9,5));
        assertArrayEquals(integerArray.getData(), new int[]{2,7,3,8,4,9,5,6,4,5,6});

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> this.integerArray.insert(10, 13));
        assertEquals("index is invalid.", thrown.getMessage());
    }

    @DisplayName("附加")
    @Test
    void append() throws OperationNotSupportedException {
        assertTrue(this.integerArray.append(7));
        assertTrue(this.integerArray.append(8));
        assertTrue(this.integerArray.append(9));
        assertTrue(this.integerArray.append(10));
        assertTrue(this.integerArray.append(11));
        assertArrayEquals(integerArray.getData(), new int[]{2,3,4,5,6,4,5,6,7,8,9,10,11});
        OperationNotSupportedException thrown = assertThrows(OperationNotSupportedException.class, () -> this.integerArray.append(12));
        assertEquals("invalid operation.", thrown.getMessage());
    }

    @DisplayName("删除第一个")
    @Test
    void deleteFirstLeft() {
        assertTrue(this.integerArray.deleteFirstLeft(4));
        assertArrayEquals(integerArray.getData(), new int[]{2,3,5,6,4,5,6});
        assertFalse(this.integerArray.deleteFirstLeft(10));
    }

    @DisplayName("更新第一个")
    @Test
    void updateFirstLeft() {
        assertTrue(this.integerArray.updateFirstLeft(4, 8));
        assertArrayEquals(integerArray.getData(), new int[]{2,3,8,5,6,4,5,6});
        assertFalse(this.integerArray.updateFirstLeft(10, 0));
    }

    @DisplayName("删除所有")
    @Test
    void delete() {
        assertTrue(this.integerArray.delete(4));
        assertArrayEquals(integerArray.getData(), new int[]{2,3,5,6,5,6});
        assertFalse(this.integerArray.delete(10));
    }

    @DisplayName("更新所有")
    @Test
    void update() {
        assertTrue(this.integerArray.update(4, 8));
        assertArrayEquals(integerArray.getData(), new int[]{2,3,8,5,6,8,5,6});
        assertFalse(this.integerArray.update(10,0));
    }

    @DisplayName("查找")
    @Test
    void find() {
        assertArrayEquals(new int[]{2,5}, this.integerArray.find(4));
    }

    @Test
    void showAll(){
        assertEquals("array:[2,3,4,5,6,4,5,6]\ncapacity:13", this.integerArray.showAll());
    }
}