import java.util.*;

public class DetectCycleDFSDirected {

    private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {
            // If the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis))
                    return true;
            }
            // If the node has been previously visited and is on the current path
            else if (pathVis[it] == 1)
                return true;
        }

        pathVis[node] = 0;
        return false;
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Example directed graph edges
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // creates a cycle

        if (isCyclic(V, adj))
            System.out.println("Cycle is detected");
        else
            System.out.println("No cycle detected");
    }
}
