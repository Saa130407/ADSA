import java.util.Scanner;

public class DijkstraAlgorithm {

    static final int INF = Integer.MAX_VALUE;

    // Dijkstra's Algorithm
    static int[] dijkstra(int[][] graph, int source, int n) {

        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        // Initialize distance and visited arrays
        for (int i = 0; i < n; i++) {
            distance[i] = INF;
            visited[i] = false;
        }

        // Distance from source to itself is 0
        distance[source] = 0;

        // Find shortest paths
        for (int count = 0; count < n - 1; count++) {

            // Find unvisited vertex with minimum distance
            int u = -1;
            int minDistance = INF;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < minDistance) {
                    minDistance = distance[i];
                    u = i;
                }
            }

            // No reachable unvisited vertex
            if (u == -1) {
                break;
            }

            // Mark vertex as visited
            visited[u] = true;

            // Update distances of adjacent vertices
            for (int v = 0; v < n; v++) {

                if (!visited[v]
                        && graph[u][v] != 0
                        && distance[u] != INF
                        && distance[u] + graph[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        return distance;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter the adjacency matrix:");
        System.out.println("(Enter 0 if there is no edge)");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex (0 to " + (n - 1) + "): ");
        int source = sc.nextInt();

        int[] distance = dijkstra(graph, source, n);

        // Display shortest distances
        System.out.println("\nShortest distances from vertex " + source + ":");

        for (int i = 0; i < n; i++) {
            if (distance[i] == INF) {
                System.out.println("Vertex " + i + " : INF");
            } else {
                System.out.println("Vertex " + i + " : " + distance[i]);
            }
        }

        sc.close();
    }
}