package at.fh_burgenland.bswe.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Represents and handles the Binary trees operations.
 */
public class BinaryTree {
    private TreeNode root;

    /**
     * Inserts a value into the binary tree.
     *
     * @param value the value to insert
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    /**
     * Inserts a value into the binary tree recursively.
     *
     * @param node  the current node
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
     *
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalanced() {
        return isBalancedRec(root) != -1;
    }

    /**
     * Checks if the binary tree is balanced according to AVL rules recursively.
     *
     * @param node the current node
     * @return the height of the tree if it is balanced, -1 otherwise
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
     *
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

    public void displayTree() {
        if (root == null) {
            return;
        }

        List<List<String>> lines = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(n.value);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a node
                System.out.print(" ".repeat(gap1) + f + " ".repeat(gap2));
            }
            System.out.println();

            perpiece /= 2;
        }
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        /**
         * Constructor for a TreeNode
         *
         * @param value the value to store in the node
         */
        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}