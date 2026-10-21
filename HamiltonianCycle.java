
import java.util.Scanner;

public class HamiltonianCycle {
    static int n;
    static int[][] graph;
    static int[] path;

    // Check whether vertex v can be added at position pos
    static boolean isSafe(int v, int pos) {
        // Check if there is an edge from previous vertex to v
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        // Check if vertex v is already in the path
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

    // Solve Hamiltonian Cycle using backtracking
    static boolean solve(int pos) {
        // If all vertices are included
        if (pos == n) {
            // Check if the last vertex connects to the first
            if (graph[path[n - 1]][path[0]] == 1) {
                return true;
            }
            return false;
        }

        // Try vertices from 1 to n-1
        for (int v = 1; v < n; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;

                if (solve(pos + 1)) {
                    return true;
                }

                // Backtrack
                path[pos] = -1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        graph = new int[n][n];
        path = new int[n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // Initialize path
        for (int i = 0; i < n; i++) {
            path[i] = -1;
        }

        // Start from vertex 0
        path[0] = 0;

        if (solve(1)) {
            System.out.println("Hamiltonian Cycle exists:");
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " -> ");
            }
            System.out.println(path[0]);
        } else {
            System.out.println("Hamiltonian Cycle does not exist.");
        }

        sc.close();
    }
}
