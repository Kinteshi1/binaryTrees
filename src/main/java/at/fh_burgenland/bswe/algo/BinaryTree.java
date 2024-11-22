package at.fh_burgenland.bswe.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents and handles the Binary trees operations.
 */
public class BinaryTree {
    private TreeNode root;

    /**
     * Inserts a value into the binary tree.
     * @param value the value to insert
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    /**
     * Inserts a value into the binary tree recursively.
     * @param node the current node
     * @param value the value to insert
     * @return the new node
     */
    private TreeNode insertRec(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    /**
     * Checks if the binary tree is balanced according to AVL rules.
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalanced() {
        return isBalancedRec(root) != -1;
    }

    /**
     * Checks if the binary tree is balanced according to AVL rules recursively.
     * @param node the current node
     * @return  the height of the tree if it is balanced, -1 otherwise
     */
    private int isBalancedRec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = isBalancedRec(node.left);
        int rightHeight = isBalancedRec(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


    /**
     * Preorder traversal of the binary tree.
     */
    public void preorderTraversal() {
        preorderRec(root);
        System.out.println();
    }

    /**
     * Preorder traversal of the binary tree recursively.
     * @param node the current node
     */
    private void preorderRec(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    /**
     * Level order traversal of the binary tree.
     */
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    /**
     * Displays the binary tree structure.
     */
    public void displayTree() {
        displayTreeRec(root, 0);
    }

    /**
     * Displays the binary tree structure recursively.
     * @param node the current node
     * @param level the current level
     */
    private void displayTreeRec(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        displayTreeRec(node.right, level + 1);
        System.out.println(" ".repeat(level * 4) + node.value);
        displayTreeRec(node.left, level + 1);
    }
}