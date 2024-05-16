package part01.queue;

public class Functions {
    public static void rotateQueue(Queue queue, int n) {
        if (n >= queue.size()) {
            n -= queue.size();
        }

        for (int i = 0; i < n; i++) {
            queue.enqueue(queue.dequeue());
        }
    }
}
