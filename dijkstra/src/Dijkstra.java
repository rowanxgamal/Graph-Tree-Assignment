import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Dijkstra {
    public static HashMap<String ,Integer> dijkstra(int [][] graph, ArrayList<String>nodes, String source, String destination){
        HashMap<String,Integer> distance = new HashMap<>();
        HashMap<String,String> parents = new HashMap<>();
        ArrayList<String > copyNodes = new ArrayList<>(nodes);
        String currentNode = source;
        for (String node : nodes){
            distance.put(node,Integer.MAX_VALUE);
        }
        distance.replace(source,0);
        //dijkstra
        while (copyNodes.size()!=0){
            String nearestNode = copyNodes.get(0);
            for (String node : copyNodes){
                if (distance.get(node)<distance.get(nearestNode)){
                    nearestNode = node;
                }
            }
            currentNode = nearestNode;
             // means it will be visited
            for (String node : copyNodes){
                if (graph[nodes.indexOf(currentNode)][nodes.indexOf(node)]!=0){
                    if (graph[nodes.indexOf(currentNode)][nodes.indexOf(node)]+ distance.get(currentNode) < distance.get(node)){
                        distance.replace(node,graph[nodes.indexOf(currentNode)][nodes.indexOf(node)]+ distance.get(currentNode));
                        parents.put(node,currentNode);
                    }
                }
            }
            copyNodes.remove(currentNode);
        }
        if (distance.get(destination)==Integer.MAX_VALUE)
            System.out.println("NO PATH");
        else{
            System.out.print("Shortest Path from "+source+" to "+destination+": ");
            Stack<String> path = new Stack<>();
            String start = destination;
            while (parents.containsKey(start)){
                path.push(start);
                start = parents.get(start);
            }
            path.push(source);
            while (!path.isEmpty()){
                System.out.print(path.pop());
                if (!path.isEmpty())
                    System.out.print("-");
            }
            System.out.println();
            System.out.println("Total Distance: "+distance.get(destination));
        }
        return distance;
    }
}
