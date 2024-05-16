package part01.doublelinkedlist;

import java.util.ArrayList;

// todo сделать реализацию с фиктивным/пустым (dummy) узлом

public class DoubleLinkedList {
    public Node head;
    public Node tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) {
            this.head = item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = item;
            item.prev = tail;
        }

        this.tail = item;
    }

    public Node find(int value) {
        Node node = head;

        while (node != null) {
            if (node.value == value) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    public ArrayList<Node> findAll(int value) {
        ArrayList<Node> nodes = new ArrayList<>();

        Node node = this.head;

        while (node != null) {
            if (node.value == value) {
                nodes.add(node);
            }

            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int value) {
        if (this.head == null) {
            return false;
        }

        if (this.head.value == value) {
            return removeHead();
        }

        Node node = find(value);

        if (node == null) {
            return false;
        }

        if (node == this.tail) {
            node.prev.next = null;
            this.tail = node.prev;
            return true;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        return true;
    }

    private boolean removeHead() {
        if (this.count() == 1) {
            clear();

            return true;
        }

        this.head.next.prev = null;
        this.head = this.head.next;

        return true;
    }

    public void removeAll(int value) {
        while (remove(value)) {
            // without body
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert) {
        if (nodeAfter == null) {
            insertFirst(nodeToInsert);
            return;
        }

        if (nodeAfter == this.tail) {
            addInTail(nodeToInsert);
            return;
        }

        if (find(nodeAfter.value) == null) {
            return;
        }

        Node node = this.head;

        while (node != nodeAfter) {
            node = node.next;
        }

        node.next.prev = nodeToInsert;
        nodeToInsert.next = node.next;
        node.next = nodeToInsert;
        nodeToInsert.prev = node;
    }

    private void insertFirst(Node nodeToInsert) {
        this.head.prev = nodeToInsert;
        nodeToInsert.next = this.head;
        this.head = nodeToInsert;

        if (count() == 1) {
            this.tail = nodeToInsert;
        }
    }
}
