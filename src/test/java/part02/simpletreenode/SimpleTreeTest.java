package part02.simpletreenode;

import com.sun.source.doctree.SnippetTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static part02.simpletreenode.SimpleTree.*;
import static part02.simpletreenode.SimpleTreeNode.*;

class SimpleTreeTest {
    SimpleTreeNode root;
    SimpleTree tree;

    @BeforeEach
    void setUp() {
        root = new SimpleTreeNode<>(0, null);
        tree = new SimpleTree<>(root);
    }

    @Test
    void addChildTest() {
        SimpleTreeNode node1 = new SimpleTreeNode(101, null);
        SimpleTreeNode node2 = new SimpleTreeNode(102, null);
        SimpleTreeNode node3 = new SimpleTreeNode(103, null);

        tree.addChild(root, node1);
        tree.addChild(node1, node2);
        tree.addChild(node2, node3);

        assertTrue(tree.root.children.contains(node1));
        assertEquals(root, node1.parent);
        assertEquals(node2, node3.parent);
        assertTrue(node2.children.contains(node3));
        assertNull(node3.children);
    }

    @Test
    void deleteNodeTest() {
        List<SimpleTreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        for (int i = 1; i < 10; i++) {
            SimpleTreeNode node = new SimpleTreeNode(i, null);

            nodes.add(node);
            tree.addChild(root, node);
        }

        assertEquals(10, tree.count());
        assertTrue(root.children.contains(nodes.get(5)));
        tree.deleteNode(nodes.get(5));
        assertFalse(root.children.contains(nodes.get(5)));

        for (int i = 1; i < nodes.size(); i++) {
            tree.deleteNode(nodes.get(i));
        }

        assertEquals(1, tree.count());
    }

    @Test
    void deleteRootTest() {
        assertNotNull(tree.root);

        for (int i = 1; i < 10; i++) {
            SimpleTreeNode node = new SimpleTreeNode(i, null);
            tree.addChild(root, node);
        }

        tree.deleteNode(root);
        assertNull(tree.root);
    }

    @Test
    void getAllNodesTest(){
        assertEquals(1, tree.getAllNodes().size());

        List<SimpleTreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        for (int i = 1; i < 15; i++) {
            SimpleTreeNode node = new SimpleTreeNode(i, null);

            nodes.add(node);
            tree.addChild(root, node);
        }

        List<SimpleTreeNode> allNodes = tree.getAllNodes();

        assertTrue(allNodes.containsAll(nodes));
    }

    @Test
    void findNodesByValueTest() {
        SimpleTreeNode node1 = new SimpleTreeNode(101, null);
        SimpleTreeNode node2 = new SimpleTreeNode(102, null);
        SimpleTreeNode node3 = new SimpleTreeNode(103, null);
        SimpleTreeNode node4 = new SimpleTreeNode(104, null);
        SimpleTreeNode node5 = new SimpleTreeNode(105, null);
        SimpleTreeNode node6 = new SimpleTreeNode(106, null);

        tree.addChild(root, node1);
        tree.addChild(root, node2);
        tree.addChild(root, node3);
        tree.addChild(root, node4);
        tree.addChild(root, node5);
        tree.addChild(root, node6);

        List<SimpleTreeNode> nodesByValue = tree.findNodesByValue(102);
        assertTrue(nodesByValue.contains(node2));

        tree.addChild(node4, new SimpleTreeNode<>(777, null));
        tree.addChild(node5, new SimpleTreeNode<>(777, null));
        tree.addChild(node6, new SimpleTreeNode<>(777, null));

        nodesByValue = tree.findNodesByValue(777);

        assertEquals(3, nodesByValue.size());
        assertEquals(0, tree.findNodesByValue(666).size());
    }

    @Test
    void moveNodeTest() {
        SimpleTreeNode node1 = new SimpleTreeNode(101, null);
        SimpleTreeNode node2 = new SimpleTreeNode(102, null);
        SimpleTreeNode node3 = new SimpleTreeNode(103, null);
        SimpleTreeNode node4 = new SimpleTreeNode(104, null);
        SimpleTreeNode node5 = new SimpleTreeNode(105, null);
        SimpleTreeNode node6 = new SimpleTreeNode(106, null);

        tree.addChild(root, node1);
        tree.addChild(root, node2);
        tree.addChild(root, node3);
        tree.addChild(root, node4);
        tree.addChild(root, node5);
        tree.addChild(root, node6);
        assertEquals(6, root.children.size());

        tree.moveNode(node4, node6);
        tree.moveNode(node5, node6);
        assertTrue(node6.children.contains(node4));
        assertSame(node4.parent, node6);
        assertSame(node5.parent, node6);
        assertEquals(4, root.children.size());
        assertEquals(2, node6.children.size());
    }

    @Test
    void countTest() {
        SimpleTree tree1 = new SimpleTree(null);
        assertEquals(0, tree1.count());

        assertEquals(1, tree.count());

        for (int i = 0; i < 100; i++) {
            tree.addChild(root, new SimpleTreeNode<>(i + 1, null));
        }

        assertEquals(101, tree.count());

        tree.deleteNode(root);
        assertEquals(0, tree.count());
    }

    @Test
    void leafCountTest() {
        assertEquals(1, tree.leafCount());

        SimpleTreeNode node1 = new SimpleTreeNode(101, null);
        SimpleTreeNode node2 = new SimpleTreeNode(102, null);
        SimpleTreeNode node3 = new SimpleTreeNode(103, null);
        SimpleTreeNode node4 = new SimpleTreeNode(104, null);
        SimpleTreeNode node5 = new SimpleTreeNode(105, null);
        SimpleTreeNode node6 = new SimpleTreeNode(106, null);

        tree.addChild(root, node1);
        tree.addChild(root, node2);
        assertEquals(2, tree.leafCount());

        tree.addChild(node1, node3);
        tree.addChild(node2, node4);
        tree.addChild(root, node5);
        tree.addChild(root, node6);
        assertEquals(4, tree.leafCount());
    }
}
