package part01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    void addInTail() {
        list.addInTail(nodes.get(0));
        list.addInTail(nodes.get(1));
        list.addInTail(nodes.get(2));

        assertSame(list.head, list.find(0));
        assertSame(list.tail, list.find(2));
    }

    @Test
    void removeOne() {
        list.addInTail(nodes.get(0));
        list.addInTail(nodes.get(1));
        list.addInTail(nodes.get(2));

        list.remove(1);
        assertEquals(2, list.count());
        assertSame(list.head, list.find(0));
    }

}