package part01.doublelinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    DoubleLinkedList list;
    ArrayList<Node> nodes;

    @BeforeEach
    void prepare() {
        list = new DoubleLinkedList();
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
        assertSame(list.head.next, list.tail);
        assertSame(list.tail.prev, list.head);
    }

    @Test
    void removeHead() {
        list.addInTail(nodes.get(0));
        list.addInTail(nodes.get(1));
        list.addInTail(nodes.get(2));

        assertTrue(list.remove(0));
        assertNull(list.head.prev);
    }

    @Test
    void removeHeadIfOneNodeInList() {
        list.addInTail(nodes.getFirst());

        assertTrue(list.remove(0));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeTail() {
        list.addInTail(nodes.get(0));
        list.addInTail(nodes.get(1));
        list.addInTail(nodes.get(2));

        assertTrue(list.remove(2));
        assertEquals(1, list.tail.value);
        assertEquals(0, list.tail.prev.value);
        assertNull(list.tail.next);
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
        assertEquals(8, list.tail.prev.value);
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

        Node node = list.find(5);
        list.insertAfter(node, new Node(777));

        assertEquals(node, node.prev.next);
        assertEquals(node, node.next.prev);
        assertEquals(11, list.count());
    }

    @Test
    void insertAfterTail() {
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
    void insertAfterIsNullInEmptyList() {
        list.insertAfter(null, new Node(10));
        assertEquals(1, list.count());
    }

    @Test
    void insertAfterIfNodeAfterIsNull() {
        for (Node node : nodes) {
            list.addInTail(node);
        }

        list.insertAfter(null, new Node(16));

        assertEquals(16, list.head.value);
        assertEquals(11, list.count());
        assertNull(list.head.prev);
        assertEquals(0, list.head.next.value);
        assertEquals(list.head, list.head.next.prev);
    }
}
