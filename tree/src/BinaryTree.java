import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void inOrderTraversal(Node node){
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.value+" ");
        inOrderTraversal(node.right);
    }
    public void preOrderTraversal(Node node){
        if (node == null)
            return;
        System.out.print(node.value+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public void postOrderTraversal(Node node){
        if (node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value+" ");
    }
    public static BinaryTree creatingTree(Scanner scanner){
        System.out.println("Enter the value of the root node: ");
        int rootValue = scanner.nextInt();
        Node root = new Node(rootValue);
        return new BinaryTree(root);
    }
    public static void inputBfs(Node node,Scanner scanner){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.println("Enter left child value of "+node.value+" (or -1 to skip):");
            int leftValue = scanner.nextInt();
            if (leftValue != -1){
                node.left = new Node(leftValue);
                queue.add(node.left);
            }

            System.out.println("Enter right child value of "+node.value+" (or -1 to skip):");
            int rightValue = scanner.nextInt();
            if (rightValue != -1){
                node.right = new Node(rightValue);
                queue.add(node.right);
            }

        }
    }
}
