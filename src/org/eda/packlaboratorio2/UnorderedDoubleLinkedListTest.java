package org.eda.packlaboratorio2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

public class UnorderedDoubleLinkedListTest {
    UnorderedDoubleLinkedList<Integer> l1;
    UnorderedDoubleLinkedList<Integer> l2;
    @Before
    public void setUp() throws Exception {
        l1= new UnorderedDoubleLinkedList<Integer>();
        l2= new UnorderedDoubleLinkedList<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        l1=null;
        l2=null;
    }

    @Test
    public void testAddToFront(){
        l1.addToFront(1);
        assertEquals(l1.count,1);
        assertTrue(l1.last.data.equals(1));
        l1.addToFront(23);
        assertEquals(l1.count,2);
        assertTrue(l1.last.data.equals(1));
        assertTrue(l1.last.next.data.equals(23));

    }

    @Test
    public void testAddToRear(){
        l1.addToRear(1);
        assertEquals(l1.count,1);
        assertTrue(l1.last.data.equals(1));
        l1.addToRear(23);
        assertEquals(l1.count,2);
        assertTrue(l1.last.data.equals(23));
        assertTrue(l1.last.next.data.equals(1));
    }

    @Test
    public void testAddAfter(){
        l1.addAfter(3,1);
        assertEquals(l1.count,0);
        l1.addToRear(1);
        assertEquals(l1.count,1);
        assertTrue(l1.last.data.equals(1));
        l1.addAfter(23,1);
        assertEquals(l1.count,2);
        assertTrue(l1.last.data.equals(23));
        assertTrue(l1.last.next.data.equals(1));
    }

    @Test
    public void removeFirst() {
        l1.addToRear(1);
        l1.addToRear(2);
        l1.addToRear(3);
        l1.addToRear(4);
        l1.removeFirst();
        assertFalse(l1.contains(1));
        l2.addToRear(1);
        l2.removeFirst();
        assertFalse(l2.contains(1));
    }

    @Test
    public void removeLast() {
        l1.addToRear(1);
        l1.addToRear(2);
        l1.addToRear(3);
        l1.addToRear(4);
        l1.removeLast();
        assertFalse(l1.contains(4));
        l2.addToRear(1);
        l2.removeLast();
        assertFalse(l2.contains(1));
    }

    @Test
    public void remove() {
        l1.addToRear(1);
        l1.addToRear(2);
        l1.addToRear(3);
        l1.addToRear(4);
        l1.remove(3);
        assertFalse(l1.contains(3));
        l2.addToRear(1);
        l2.remove(1);
        assertFalse(l2.contains(1));
    }

    @Test
    public void first() {
        l1.addToRear(1);
        l1.addToRear(2);
        l1.addToRear(3);
        l1.addToRear(4);
        assertTrue(l1.first().equals(1));
        l2.addToRear(1);
        assertTrue(l2.first().equals(1));
    }

    @Test
    public void last() {
        l1.addToRear(1);
        l1.addToRear(2);
        l1.addToRear(3);
        l1.addToRear(4);
        assertTrue(l1.last().equals(4));
        l2.addToRear(1);
        assertTrue(l2.last().equals(1));
    }

    @Test
    public void contains() {
        l1.addToRear(1);
        l1.addToRear(2);
        l1.addToRear(3);
        l1.addToRear(4);
        assertTrue(l1.contains(1));
        assertTrue(l1.contains(2));
        assertTrue(l1.contains(3));
        assertTrue(l1.contains(4));
        l2.addToRear(1);
        assertTrue(l2.contains(1));
    }

    @Test
    public void find() {
        l1.addToRear(3);
        l1.addToRear(4);
        l1.addToRear(45);
        assertTrue(l1.find(3).equals(3));
        assertTrue(l1.find(4).equals(4));
        assertTrue(l1.find(45).equals(45));
        assertNull(l2.find(9));
        l2.addToRear(4);
        assertTrue(l2.find(4).equals(4));
    }

    @Test
    public void isEmpty() {
        assertTrue(l1.isEmpty());
        l1.addToRear(3);
        assertFalse(l1.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(l1.size(),0);
        l1.addToRear(343);
        assertEquals(l1.size(), 1);
        l1.addToRear(23432);
        assertEquals(l1.size(),2);
    }


}
