import java.util.*;

class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class DetectCycleUndirectedBF {
    
    public static boolean checkForCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            
            for (int adjacentNode : adj.get(node)) {
                if (!vis[adjacentNode]) {
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode, node));
                } else if (parent != adjacentNode) {
                    return true;
                }
            }
        }
        
        return false;
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (checkForCycle(i, adj, vis)) return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        
        //  undirected graph edges
        adj.get(0).add(1);
        adj.get(1).add(0);
        
        adj.get(1).add(2);
        adj.get(2).add(1);
        
        adj.get(2).add(3);
        adj.get(3).add(2);
        
        adj.get(3).add(4);
        adj.get(4).add(3);
        
        adj.get(4).add(1); //  creates a cycle
        adj.get(1).add(4);
        
        if (isCycle(V, adj))
            System.out.println("Cycle detected");
        else
            System.out.println("No cycle detected");
    }
}
