package at.fh_burgenland.bswe.algo;

import lombok.extern.log4j.Log4j2;
import java.util.Scanner;

@Log4j2
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        getUserInput(tree);

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

    private static void getUserInput(BinaryTree tree) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers to insert into the tree (comma-separated):");
        String input = scanner.nextLine();
        String[] numbers = input.split(",");
        for (String number : numbers) {
            try {
                int value = Integer.parseInt(number.trim());
                tree.insert(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + number);
            }
        }
    }
}