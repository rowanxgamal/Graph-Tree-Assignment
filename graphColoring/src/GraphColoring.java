import java.util.ArrayList;

public class GraphColoring {
    public void getColors(int[][] graph, ArrayList<String> vertices){
        int color = 1;
        int n  = graph.length;
        int[] colors = new int[n];
        String[] getcolor = {"red", "green", "blue", "yellow", "orange", "black", "brown", "white", "purple", "pink", "Violet", "grey", "Mint"};
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= color; j++){
                if(check(graph, j,colors, i)){
                    colors[i] = j;
                    // System.out.println( "node " + i + " color" + j);
                    break;
                }
            }
            if(colors[i] == 0){
                colors[i] = color+1;
                color++;
            }
        }

        System.out.println("Schedule colors Solved by iterative method: ");
        for(int i = 0; i < n; i++){
            System.out.println(vertices.get(i)+  " " + getcolor[colors[i]]);
        }
        int[] colors1 = new int[n];
        if (!rec(graph, 3, colors1, 0)) {
            System.out.println("No such a Schedule");
        }

        System.out.println("Schedule colors Solved by recursive method: ");
        for(int i = 0; i < n; i++){
            System.out.println(vertices.get(i)+  " " + getcolor[colors1[i]]);
        }
    }
    public boolean check(int[][] graph, int color, int[] colors, int vertex){
        for(int i = 0; i < graph.length; i++){
            if(colors[i] == color && graph[vertex][i] == 1)return false;
        }
        return true;
    }

    public boolean rec(int[][] graph, int m, int[] colors, int vertex) {
        if (vertex == graph.length) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (check(graph, c, colors, vertex)) {
                colors[vertex] = c;
                if (rec(graph, m, colors, vertex + 1)) {
                    return true;
                }
                colors[vertex] = 0;
            }
        }

        return false;
    }
}
