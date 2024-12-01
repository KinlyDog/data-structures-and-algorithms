package part01.stack;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> list;
    private int size;

    public Stack() {
        this.list = new LinkedList<>();
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public T pop() {
        if (this.size == 0) {
            return null;
        }

        this.size--;

        return list.removeLast();
    }

    public void push(T val) {
        this.list.add(val);
        this.size++;
    }

    public T peek() {
        if (this.size == 0) {
            return null;
        }

        return list.peekLast();
    }
}
