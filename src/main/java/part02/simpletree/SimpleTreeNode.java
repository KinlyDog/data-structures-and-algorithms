package part02.simpletree;

import java.util.*;

public class SimpleTreeNode<T> {
    public T nodeValue;
    public SimpleTreeNode<T> parent;
    public List<SimpleTreeNode<T>> children;
    public int level;

    public SimpleTreeNode(T nodeValue, SimpleTreeNode<T> parent) {
        this.nodeValue = nodeValue;
        this.parent = parent;
        this.children = null;
        this.level = -1;
    }
}
