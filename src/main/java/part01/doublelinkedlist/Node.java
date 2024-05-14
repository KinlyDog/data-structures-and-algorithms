package part01.doublelinkedlist;

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
