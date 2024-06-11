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
        if (nodeToDelete.equals(this.root)) {
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

        List<SimpleTreeNode<T>> expand = new ArrayList<>();
        expand.add(root);

        return getAllNodesRec(allNodes, expand);
    }

    private List<SimpleTreeNode<T>> getAllNodesRec(List<SimpleTreeNode<T>> allNodes, List<SimpleTreeNode<T>> expand) {
        if (expand.isEmpty()) {
            return allNodes;
        }

        allNodes.addAll(expand);
        List<SimpleTreeNode<T>> expandCopy = List.copyOf(expand);
        expand.clear();

        for (SimpleTreeNode<T> node : expandCopy) {
            if (node.children != null) {
                expand.addAll(node.children);
            }
        }

        return getAllNodesRec(allNodes, expand);
    }

    public List<SimpleTreeNode<T>> findNodesByValue(T value) {
        List<SimpleTreeNode<T>> allNodes = getAllNodes();
        List<SimpleTreeNode<T>> nodesByValue = new ArrayList<>();

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

        if (newParent.children == null) {
            newParent.children = new ArrayList<>();
        }

        newParent.children.add(originalNode);
        originalNode.parent = newParent;
    }

    public int count() {
        return getAllNodes().size();
    }

    public int leafCount() {
        int count = 0;
        List<SimpleTreeNode<T>> allNodes = getAllNodes();

        for (SimpleTreeNode<T> node : allNodes) {
            if (node.children == null) {
                count++;
            }
        }

        return count;
    }
}
