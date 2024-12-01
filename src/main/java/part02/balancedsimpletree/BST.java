package part02.balancedsimpletree;

class BST<T> {
    BSTNode<T> root; // корень дерева, или null

    public BST(BSTNode<T> node) {
        this.root = node;
    }

    public BSTFind<T> findNodeByKey(int key) {
        BSTFind<T> bstFind = new BSTFind<>();

        if (this.root == null) {
            return bstFind;
        }

        return findNodeByKeyRec(this.root, bstFind, key);
    }

    private BSTFind<T> findNodeByKeyRec(BSTNode<T> node, BSTFind<T> bstFind, int key) {
        if (key < node.nodeKey && node.leftChild != null) {
            findNodeByKeyRec(node.leftChild, bstFind, key);
        }

        if (key >= node.nodeKey && node.rightChild != null) {
            findNodeByKeyRec(node.rightChild, bstFind, key);
        }

        bstFind.node = node;

        if (node.nodeKey == key) {
            bstFind.nodeHasKey = true;
            return bstFind;
        }

        bstFind.toLeft = false;
        bstFind.nodeHasKey = false;

        if (key < node.nodeKey) {
            bstFind.toLeft = true;
        }

        return bstFind;
    }

    public boolean addKeyValue(int key, T val) {
        BSTFind<T> bstFind = findNodeByKey(key);
        BSTNode<T> node = new BSTNode<>(key, val, null);

        if (bstFind.node == null) {
            this.root = node;
            return true;
        }

        if (bstFind.nodeHasKey) {
            return false;
        }

        bstFind.node.rightChild = node;

        if (bstFind.toLeft) {
            bstFind.node.leftChild = node;
        }

        return true;
    }

    public BSTNode<T> findMinMax(BSTNode<T> fromNode, boolean findMax) {
        if (findMax) {
            return findMaxRec(fromNode);
        }

        return findMinRec(fromNode);
    }

    private BSTNode<T> findMaxRec(BSTNode<T> node) {
        if (node.rightChild != null) {
            findMaxRec(node.rightChild);
        }

        return node;
    }

    private BSTNode<T> findMinRec(BSTNode<T> node) {
        if (node.leftChild != null) {
            findMinRec(node.leftChild);
        }

        return node;
    }

    // not complete
    public boolean deleteNodeByKey(int key) {
        BSTFind<T> bstFind = findNodeByKey(key);

        if (bstFind.node == null || !bstFind.nodeHasKey) {
            return false;
        }

        if (bstFind.node == this.root) {
            this.root = null;
        }

        // нет потомков
        if (bstFind.node.leftChild == null && bstFind.node.rightChild == null) {
            return removeLeaf(bstFind.node);
        }

        // один потомок

        // оба потомка
        boolean parentLeftChild = bstFind.node.parent.leftChild == bstFind.node;

        return deleteNodeByKeyAll(bstFind.node.parent, bstFind.node.rightChild, parentLeftChild);
    }

    private boolean removeLeaf(BSTNode<T> node) {
        if (node.parent.leftChild == node) {
            node.parent.leftChild = null;
        } else {
            node.parent.rightChild = null;
        }

        node.parent = null;
        return true;
    }

    private boolean deleteNodeByKeyAll(BSTNode<T> parent, BSTNode<T> node, boolean parentLeftChild) {
        if (node.leftChild != null) {
            deleteNodeByKeyAll(parent, node.leftChild, parentLeftChild);
        }

        node.parent = parent;

        if (node.rightChild != null) {

        }

        if (node.rightChild == null && !parentLeftChild) {
            parent.rightChild = node;
            return true;
        }

        if (node.rightChild == null && parentLeftChild) {
            parent.leftChild = node;
            return true;
        }


        return false;
    }

    public int count() {
        return countRec(this.root);
    }

    private int countRec(BSTNode<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + countRec(node.leftChild) + countRec(node.rightChild);
    }
}
