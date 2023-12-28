import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Classes");
        String[] vertices = scanner.nextLine().split(",");
        ArrayList<String> classes = new ArrayList<String>();
        for(int i = 0; i < vertices.length; i++) {
            classes.add(vertices[i]);
        }
        int numclasses = classes.size();
        int[][] graph = new int[numclasses][numclasses];
        System.out.println("Enter the number of Conflicting classes");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Conflicting Classes : ");
        for (int i = 0; i < n; i++) {
            String[] edges = scanner.nextLine().split("-");
            String source = edges[0];
            String destination = edges[1];
            graph[classes.indexOf(source)][classes.indexOf(destination)] = 1;
            graph[classes.indexOf(destination)][classes.indexOf(source)] = 1;
        }
        // for(int i = 0; i < graph.length; i++) {
        //     for(int j = 0; j < graph.length; j++) {
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println("");
        // }
        GraphColoring graphColoring = new GraphColoring();
        graphColoring.getColors(graph, classes);

        scanner.close();
    }
}