package part01.queue;

import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> list;
    private int size;

    public Queue() {
        this.list = new LinkedList<>();
        this.size = 0;
    }

    public void enqueue(T item) {
        this.list.addLast(item);
        this.size++;
    }

    public T dequeue() {
        if (size() == 0) {
            return null;
        }

        this.size--;

        return this.list.removeFirst();
    }

    public int size() {
        return this.size;
    }
}
