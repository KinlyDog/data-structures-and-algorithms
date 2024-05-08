package part01;

import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) {
            this.head = item;
        } else {
            this.tail.next = item;
        }

        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;

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
        Node node = this.head;

        if (node.value == value) {
            head = head.next;

            return true;
        }

        Node prev = node;

        while (node != null) {
            if (node.value == value) {
                prev.next = node.next;
                return true;
            }

            prev = node;
            node = node.next;
        }

        return false;
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
        int count = 0;
        Node node = this.head;

        while (node != null) {
            count++;
        }

        return count;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert) {
        if (nodeAfter == null) {
            nodeToInsert.next = head;
            head = nodeToInsert;
        }

        Node node = find(nodeAfter.value);
        nodeToInsert.next = node.next;
        node.next = nodeToInsert;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
