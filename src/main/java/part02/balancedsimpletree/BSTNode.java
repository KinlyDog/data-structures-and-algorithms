package part02.balancedsimpletree;

class BSTNode<T> {
    public int nodeKey; // ключ узла
    public T nodeValue; // значение в узле
    public BSTNode<T> parent; // родитель или null для корня
    public BSTNode<T> leftChild; // левый потомок
    public BSTNode<T> rightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent) {
        this.nodeKey = key;
        this.nodeValue = val;
        this.parent = parent;
        this.leftChild = null;
        this.rightChild = null;
    }
}
