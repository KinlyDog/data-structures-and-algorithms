package part01.orderedlist;

import java.util.ArrayList;

public class OrderedList<T> {
    public Node<T> head;
    public Node<T> tail;
    public int size;
    private boolean ascending;

    public OrderedList(boolean ascending) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.ascending = ascending;
    }

    public int compare(T v1, T v2) {
        if (v1 instanceof String) {
            return compareStrings(((String) v1).trim(), ((String) v2).trim());
        }

        return Integer.compare((int) v1, (int) v2);
    }

    private int compareStrings(String v1, String v2) {
        if (v1.compareTo(v2) == 0) {
            return 0;
        }

        if (v1.compareTo(v2) < 0) {
            return -1;
        }

        return 1;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        size++;

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        Node<T> node = this.head;
        int compareResult = compare(this.head.value, newNode.value);

        if ((this.ascending && compareResult >= 0) || (!this.ascending && compareResult <= 0)) {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            return;
        }

        while (node != null) {
            compareResult = compare(node.value, newNode.value);

            if ((this.ascending && compareResult < 0) || (!this.ascending && compareResult > 0)) {
                node = node.next;
                continue;
            }

            newNode.next = node;
            newNode.prev = node.prev;
            node.prev.next = newNode;
            node.prev = newNode;
            return;
        }

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
    }

    public Node<T> find(T val) {
        Node<T> node = this.head;

        while (node != null) {
            int compareResult = compare(node.value, val);

            if ((this.ascending && compareResult > 0) || (!this.ascending && compareResult < 0)) {
                break;
            }

            if (compareResult == 0) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    public boolean delete(T value) {
        if (deleter(value)) {
            size--;
            return true;
        }

        return false;
    }

    private boolean deleter(T value) {
        if (this.head == null) {
            return false;
        }

        if (this.head.value == value) {
            return removeHead();
        }

        Node<T> node = find(value);

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
            clear(true);

            return true;
        }

        this.head.next.prev = null;
        this.head = this.head.next;

        return true;
    }

    public void clear(boolean asc) {
        this.ascending = asc;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int count() {
        return this.size;
    }

    public ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> nodes = new ArrayList<>();
        Node<T> node = head;

        while (node != null) {
            nodes.add(node);
            node = node.next;
        }

        return nodes;
    }
}
