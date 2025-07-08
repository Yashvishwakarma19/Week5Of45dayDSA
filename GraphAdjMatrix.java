import java.util.*;
public class GraphAdjMatrix{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int v = s.nextInt();
        System.out.println("Enter the number of Edges: ");
        int e = s.nextInt();

        int[][] adjMatrix = new int[v][v];

        System.out.println("Enter the (from to) edge : ");
        for(int i=0;i<e;i++){
            int from  = s.nextInt();
            int to = s.nextInt();

            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;
        }

        System.out.println("Adjency matrix: ");
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
        s.close();
    }
}