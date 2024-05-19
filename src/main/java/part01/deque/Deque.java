package part01.deque;

import java.util.LinkedList;

public class Deque<T> {
    private LinkedList<T> list;

    public Deque() {
        this.list = new LinkedList();
    }

    public void addFront(T item) {
        list.addFirst(item);
    }

    public void addTail(T item) {
        list.addLast(item);
    }

    public T removeFront() {
        if (list.isEmpty()) {
            return null;
        }

        return list.removeFirst();
    }

    public T removeTail() {
        if (list.isEmpty()) {
            return null;
        }

        return list.removeLast();
    }

    public int size() {
        return list.size();
    }
}
