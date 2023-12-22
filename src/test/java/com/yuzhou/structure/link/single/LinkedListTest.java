package com.yuzhou.structure.link.single;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    public void should_add_items_successful() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        assertEquals("5 4 3 2 1", linkedList.string());
    }

    @Test
    public void should_get_given_item() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        var actual = linkedList.get(4);

        assertEquals(4, actual);
        assertNull(linkedList.get(9));
    }

    @Test
    public void should_throw_exception_if_link_is_empty_when_deleting_item_by_value() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        Exception ex = assertThrows(Exception.class, () -> linkedList.deleteByValue(1));

        assertEquals("no item exists in link", ex.getMessage());
    }

    @Test
    public void should_throw_exception_if_link_is_empty_when_deleting_item_by_index() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        Exception ex = assertThrows(Exception.class, () -> linkedList.deleteByIndex(1));

        assertEquals("no item exists in link", ex.getMessage());
    }

    @Test
    public void should_delete_item_by_value() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.deleteByValue(1);

        assertEquals("5 4 3 2", linkedList.string());
    }

    @Test
    public void should_delete_item_by_index() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.deleteByIndex(0);
        assertEquals("4 3 2 1", linkedList.string());
    }

    @Test
    public void should_throw_exception_if_index_out_of_bound_when_delete_item_by_index() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        Exception ex = assertThrows(Exception.class, () -> linkedList.deleteByIndex(5));

        assertEquals("out of index", ex.getMessage());
    }

    @Test
    public void should_reverse_link_list() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.reverse();

        assertEquals("1 2 3 4 5", linkedList.string());
    }
}