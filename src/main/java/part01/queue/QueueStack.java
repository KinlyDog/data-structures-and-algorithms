package part01.queue;

import part01.stack.Stack;

public class QueueStack<T> {
    private Stack<T> stackFirst;
    private Stack<T> stackSecond;

    QueueStack() {
        this.stackFirst = new Stack<>();
        this.stackSecond = new Stack<>();
    }

    public void enqueue(T item) {
        stackFirst.push(item);
    }

    public T dequeue() {
        if (stackSecond.size() == 0) {
            stackTransfer();
        }

        return stackSecond.pop();
    }

    public int size() {
        return stackFirst.size() + stackSecond.size();
    }

    private void stackTransfer() {
        while (stackFirst.size() > 0) {
            stackSecond.push(stackFirst.pop());
        }
    }
}
