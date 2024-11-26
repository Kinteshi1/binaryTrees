package at.fh_burgenland.bswe.algo;

import lombok.extern.log4j.Log4j2;
import java.util.Scanner;

@Log4j2
public class Main {
    public static void main(String[] args) {
        // Create a binary tree
        BinaryTree tree = new BinaryTree();
        tree.createTree();

        // Display the tree structure
        System.out.println("Tree structure:");
        tree.displayTree();

        // Display the Nodes according to Preorder rules
        System.out.println("PKZ: 2310859039 - Preorder & Level Order");
        System.out.println("Preorder traversal:");
        tree.preorderTraversal();

        //display the Nodes according to Level order rules
        System.out.println("Level order traversal:");
        tree.levelOrderTraversal();

        //check if tree is balanced or not
        if (tree.isBalanced()) {
            System.out.println("The tree is balanced according to AVL rules.");
        } else {
            System.out.println("The tree is not balanced according to AVL rules.");
        }
    }
}