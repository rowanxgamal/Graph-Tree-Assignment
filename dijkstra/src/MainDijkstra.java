import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainDijkstra {
    public static void main(String[] args) {
//        int[][] graph = {
//                {0, 2, 4, 0, 0},
//                {2, 0, 1, 7, 0},
//                {4, 1, 0, 3, 0},
//                {0, 7, 3, 0, 0},
//                {0, 0, 0, 0, 0}
//        };
//        ArrayList<String> nodes = new ArrayList<>();
//        nodes.add("A");
//        nodes.add("B");
//        nodes.add("C");
//        nodes.add("D");
//        nodes.add("E");
//        HashMap <String,Integer> distance = Dijkstra.dijkstra(graph, nodes, "A", "E");
//        if (distance.get("E")== Integer.MAX_VALUE)
//            System.out.println("NO PATH");
//        else{
//            System.out.println(Dijkstra.dijkstra(graph, nodes, "A", "E"));
//            System.out.println(distance);
//        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the list of airports: ");
        String[] inputAirports = scanner.nextLine().split(", ");
        ArrayList<String>airports = new ArrayList<>();
        for (String airport: inputAirports){
            airports.add(airport);
        }
        int numAirports = airports.size();
        int[][] graph = new int[numAirports][numAirports];

        System.out.print("Enter the flights: "); //edges
        String[] flightsInput = scanner.nextLine().split(", ");

        for (String flightInput : flightsInput) {
            String[] flightDetails = flightInput.split("-");
            String source = flightDetails[0];
            String destination = flightDetails[1];
            System.out.print("The distance for flight " + source + "-" + destination + ": ");
            int distance = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            graph[airports.indexOf(source)][airports.indexOf(destination)] = distance;
        }
        System.out.print("Enter source airport: ");
        String sourceAirport = scanner.nextLine();

        System.out.print("Enter destination airport: ");
        String destinationAirport = scanner.nextLine();
        Dijkstra.dijkstra(graph,airports,sourceAirport,destinationAirport);
    }
}
