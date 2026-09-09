import java.util.Scanner;

public class PrimsAlgorithm {

  
    static int minKey(int[] key, boolean[] mstSet, int vertices) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

   
    static void primMST(int[][] graph, int vertices) {

        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        boolean[] mstSet = new boolean[vertices];

     
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

    
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < vertices - 1; count++) {

            int u = minKey(key, mstSet, vertices);


            mstSet[u] = true;


            for (int v = 0; v < vertices; v++) {

                if (graph[u][v] != 0 &&
                    !mstSet[v] &&
                    graph[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }


        System.out.println("\nMinimum Spanning Tree:");
        System.out.println("Edge\tWeight");

        int totalWeight = 0;

        for (int i = 1; i < vertices; i++) {
            System.out.println(
                parent[i] + " - " + i + "\t" + graph[i][parent[i]]
            );

            totalWeight += graph[i][parent[i]];
        }

        System.out.println("\nTotal Weight of MST = " + totalWeight);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.println(
            "Enter the adjacency matrix (enter 0 if there is no edge):"
        );

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        primMST(graph, vertices);

        sc.close();
    }
}