package part01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList list;

    @BeforeEach
    void prepare() {
        list = new LinkedList();
    }

    @Test
    void addInTail() {
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));


    }

}