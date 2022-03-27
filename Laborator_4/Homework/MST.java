package lab4;
// Prim's algorithm

public class MST {
    private int V;

    public MST(int nrVertices){
        V = nrVertices;
    }

    public int minKey(int[] key, Boolean[] mstSet)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (Boolean.TRUE.equals(!mstSet[v]) && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }


    public void printMST(int[] parent, int[][] graph)
    {
        int sumWeight = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            sumWeight += graph[i][parent[i]];
        }
        System.out.println("Minimum cost = " + sumWeight);
    }


    public void primMST(int[][] graph) {
        int[] parent = new int[V];
        int[] key = new int[V];

        // to represent set of vertices included in MST
        Boolean[] mstSet = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (Boolean.TRUE.equals(graph[u][v] != 0 && !mstSet[v]) && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }

}
