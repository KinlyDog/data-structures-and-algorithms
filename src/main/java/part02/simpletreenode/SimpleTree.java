package part02.simpletreenode;

import java.util.ArrayList;
import java.util.List;

public class SimpleTree<T> {
    public SimpleTreeNode<T> root;

    public SimpleTree(SimpleTreeNode<T> root) {
        this.root = root;
    }

    public void addChild(SimpleTreeNode<T> parentNode, SimpleTreeNode<T> newChild) {
        if (parentNode.children == null) {
            parentNode.children = new ArrayList<>();
        }

        parentNode.children.add(newChild);
        newChild.parent = parentNode;
    }

    public void deleteNode(SimpleTreeNode<T> nodeToDelete) {
        if (nodeToDelete == this.root) {
            this.root = null;
            return;
        }

        if (nodeToDelete.parent == null) {
            return;
        }

        SimpleTreeNode<T> parent = nodeToDelete.parent;

        parent.children.remove(nodeToDelete);

        if (parent.children.isEmpty()) {
            parent.children = null;
        }

        nodeToDelete.parent = null;
    }

    public List<SimpleTreeNode<T>> getAllNodes() {
        List<SimpleTreeNode<T>> allNodes = new ArrayList<>();

        if (this.root == null) {
            return allNodes;
        }

        return getAllNodesRec(root, allNodes);
    }

    private List<SimpleTreeNode<T>> getAllNodesRec(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> listNodes) {
        listNodes.add(node);

        if (node.children == null) {
            return listNodes;
        }

        for (SimpleTreeNode<T> child : node.children) {
            getAllNodesRec(child, listNodes);
        }

        return listNodes;
    }

    public List<SimpleTreeNode<T>> findNodesByValue(T value) {
        List<SimpleTreeNode<T>> allNodes = getAllNodes();
        List<SimpleTreeNode<T>> nodesByValue = new ArrayList<>();

        if (this.root == null) {
            return nodesByValue;
        }

        for (SimpleTreeNode<T> node : allNodes) {
            if (node.nodeValue.equals(value)) {
                nodesByValue.add(node);
            }
        }

        return nodesByValue;
    }

    public void moveNode(SimpleTreeNode<T> originalNode, SimpleTreeNode<T> newParent) {
        SimpleTreeNode<T> parent = originalNode.parent;
        parent.children.remove(originalNode);

        if (parent.children.isEmpty()) {
            parent.children = null;
        }

        addChild(newParent, originalNode);
    }

    public int count() {
        return getAllNodes().size();
    }

    public int leafCount() {
        if (this.root == null) {
            return 0;
        }

        return leafCountRec(root);
    }

    private int leafCountRec(SimpleTreeNode<T> node) {
        if (node.children == null) {
            return 1;
        }

        int leafCount = 0;
        for (SimpleTreeNode<T> child : node.children) {
            leafCount += leafCountRec(child);
        }

        return leafCount;
    }
}
