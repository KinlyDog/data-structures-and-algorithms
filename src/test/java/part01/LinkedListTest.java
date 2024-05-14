package part01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part01.linkedlist.LinkedList;
import part01.linkedlist.Node;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static part01.linkedlist.Function.*;

class LinkedListTest {
    LinkedList list;
    ArrayList<Node> nodes;

    @BeforeEach
    void prepare() {
        list = new LinkedList();
        nodes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            nodes.add(new Node(i));
        }
    }

    @Test
    void count() {
        for (int i = 0; i < 6; i++) {
            list.addInTail(nodes.get(i));
        }

        assertEquals(6, list.count());
    }

    @Test
    void countIfListIsEmpty() {
        assertEquals(0, list.count());
    }

    @Test
    void clear() {
        for (Node node : nodes) {
            list.addInTail(node);
        }

        assertEquals(list.count(), nodes.size());

        list.clear();
        assertTrue(list.head == null && list.tail == null);
        assertEquals(0, list.count());
    }

    @Test
    void addInTailInEmptyList() {
        list.addInTail(nodes.getFirst());

        assertSame(list.head, list.find(0));
        assertSame(list.tail, list.find(0));
    }

    @Test
    void addInTail() {
        list.addInTail(nodes.get(0));
        list.addInTail(nodes.get(1));
        list.addInTail(nodes.get(2));

        assertSame(list.head, list.find(0));
        assertSame(list.tail, list.find(2));
        assertEquals(3, list.count());
    }

    @Test
    void removeOne() {
        list.addInTail(nodes.get(0));
        list.addInTail(nodes.get(1));
        list.addInTail(nodes.get(2));

        assertTrue(list.remove(1));
        assertFalse(list.remove(1));

        assertEquals(2, list.count());
        assertSame(list.head, list.find(0));
    }

    @Test
    void removeInEmptyList() {
        assertFalse(list.remove(5));
    }

    @Test
    void find() {
        for (Node node : nodes) {
            list.addInTail(node);
        }

        assertEquals(5, list.find(5).value);
    }

    @Test
    void findForMissing() {
        for (Node node : nodes) {
            list.addInTail(node);
        }

        assertNull(list.find(12));
    }

    @Test
    void findAll() {
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.addInTail(new Node(2));
        list.addInTail(new Node(4));
        list.addInTail(new Node(5));

        ArrayList<Node> two = list.findAll(2);
        assertEquals(3, two.size());

        for (Node node : two) {
            assertEquals(2, node.value);
        }
    }

    @Test
    void insertAfter() {
        for (Node node : nodes) {
            list.addInTail(node);
        }

        assertEquals(9, list.tail.value);

        Node node = list.find(9);
        list.insertAfter(node, new Node(16));

        assertEquals(16, list.tail.value);
        assertEquals(11, list.count());
    }

    @Test
    void insertAfterInEmptyList() {
        list.insertAfter(new Node(5), new Node(10));
        assertEquals(0, list.count());
    }

    @Test
    void insertAfterIfNodeIsNull() {
        for (Node node : nodes) {
            list.addInTail(node);
        }

        list.insertAfter(null, new Node(16));

        assertEquals(16, list.head.value);
        assertEquals(11, list.count());
    }

    @Test
    void sumOfList() {
        LinkedList list2 = new LinkedList();

        for (Node node : nodes) {
            list.addInTail(node);
            list2.addInTail(node);
        }

        LinkedList sum = sumOfLists(list, list2);

        assertEquals(0, sum.head.value);
        assertEquals(18, sum.tail.value);
    }
}
