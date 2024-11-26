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

    /**
     * Get user input and insert numbers into the tree.
     * @param tree  The binary tree to insert the numbers into.
     */
    private static void getUserInput(BinaryTree tree) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers to insert into the tree (comma-separated):");
        String input = scanner.nextLine();
        String[] numbers = input.split(",");
        if (numbers.length > 0) {
            try {
                int rootValue = Integer.parseInt(numbers[0].trim());
                tree.insert(rootValue);
                for (int i = 1; i < numbers.length; i++) {
                    int value = Integer.parseInt(numbers[i].trim());
                    tree.insert(value);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number in input.");
            } catch (IllegalArgumentException e) {
                System.out.println("Input contains invalid characters.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}