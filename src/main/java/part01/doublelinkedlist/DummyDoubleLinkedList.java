package part01.doublelinkedlist;

import java.util.ArrayList;

public class DummyDoubleLinkedList {
    public Node dummy;

    public DummyDoubleLinkedList() {
        this.dummy = new Node(0);
        this.dummy.next = dummy;
        this.dummy.prev = dummy;
    }

    public void addInTail(Node item) {
        item.prev = dummy.prev;
        item.next = dummy;

        dummy.prev.next = item;
        dummy.prev = item;
    }

    public Node find(int value) {
        Node node = dummy.next;

        while (node != dummy) {
            if (node.value == value) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    public ArrayList<Node> findAll(int value) {
        ArrayList<Node> nodes = new ArrayList<>();

        Node node = dummy.next;

        while (node != dummy) {
            if (node.value == value) {
                nodes.add(node);
            }

            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int value) {
        Node node = find(value);

        if (node == null) {
            return false;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        return true;
    }

    public void removeAll(int value) {
        Node node = dummy.next;

        while (node != dummy) {
            if (node.value == value) {
                remove(node.value);
            }

            node = node.next;
        }
    }

    public void clear() {
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int count() {
        Node node = dummy.next;
        int count = 0;

        while (node != dummy) {
            count++;
            node = node.next;
        }

        return count;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert) {
        if (nodeAfter == null) {
            insertInHead(nodeToInsert);
            return;
        }

        if (nodeAfter == dummy.prev) {
            addInTail(nodeToInsert);
            return;
        }

        nodeToInsert.prev = nodeAfter;
        nodeToInsert.next = nodeAfter.next;

        nodeAfter.next.prev = nodeToInsert;
        nodeAfter.next = nodeToInsert;
    }

    private void insertInHead(Node node) {
        node.prev = dummy;
        node.next = dummy.next;

        dummy.next.prev = node;
        dummy.next = node;
    }
}
