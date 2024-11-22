package at.fh_burgenland.bswe.algo;

/**
 * Represents a node in a binary tree.
 * value stores the nodes value
 * left and right are references to the left and right child nodes
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    /**
     * Constructor for a TreeNode
     * @param value the value to store in the node
     */
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
