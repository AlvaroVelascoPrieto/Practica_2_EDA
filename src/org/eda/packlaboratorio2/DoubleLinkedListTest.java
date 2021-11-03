package org.eda.packlaboratorio2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {
    DoubleLinkedList<Integer> l1;
    @Before
    public void setUp() throws Exception {
        l1=new DoubleLinkedList<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        l1=null;
    }

    @Test
    public void setDescr() {
        l1.setDescr("AAA");
        assertTrue(l1.getDescr().equals("AAA"));
    }

    @Test
    public void getDescr() {
        l1.setDescr("AAA");
        assertTrue(l1.getDescr().equals("AAA"));
    }
}