import java.util.Scanner;

public class MainTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = BinaryTree.creatingTree(scanner);
        BinaryTree.inputBfs(binaryTree.root,scanner);
        System.out.print("Pre Order Traversal: ");
        binaryTree.preOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.print("In Order Traversal: ");
        binaryTree.inOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.print("Post Order Traversal: ");
        binaryTree.postOrderTraversal(binaryTree.root);
    }
}
