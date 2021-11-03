package org.eda.packlaboratorio2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UnorderedDoubleLinkedListTest {
    UnorderedDoubleLinkedList<Integer> l1;
    @Before
    public void setUp() throws Exception {
        l1= new UnorderedDoubleLinkedList<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        l1=null;
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


}
