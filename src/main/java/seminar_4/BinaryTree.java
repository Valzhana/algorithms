package seminar_4;

public class BinaryTree <V extends Comparable<V>>{
    private Node root;
    private class Node {
        private int value;
        private Node left;
        private Node right;

    }
    private boolean search(Node node, int value) {
        if (node.value == value) {
            return true;
        } else {
            if (value < node.value) {
                search(node.left, value);
            } else if (value > node.value) {
                search(node.right, value);
            }
        }
        return false;
    }
}
