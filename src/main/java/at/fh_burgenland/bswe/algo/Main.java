package at.fh_burgenland.bswe.algo;

import lombok.extern.log4j.Log4j2;
import java.util.Scanner;

@Log4j2
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.println("Enter numbers to insert into the tree (type 'done' to finish):");
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            tree.insert(number);
        }

        System.out.println("Tree structure:");
        tree.displayTree();

        System.out.println("Preorder traversal:");
        tree.preorderTraversal();

        System.out.println("Level order traversal:");
        tree.levelOrderTraversal();

        if (tree.isBalanced()) {
            System.out.println("The tree is balanced according to AVL rules.");
        } else {
            System.out.println("The tree is not balanced according to AVL rules.");
        }
    }
}