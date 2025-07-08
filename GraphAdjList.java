import java.util.*;
import java.util.ArrayList;

public class GraphAdjList{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enetr the number of vertices: ");
        int v = s.nextInt();
        System.out.println("Enter the number of Edges: ");
        int e = s.nextInt();

        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

        for(int i=0;i<v;i++){
            arrList.add(new ArrayList<>());
        }

        System.out.println("Enter Edges (from and to) : ");
        for(int i=0;i<e;i++){
            int from = s.nextInt();
            int to = s.nextInt();

            arrList.get(from).add(to);
            arrList.get(to).add(from);
        }
        System.out.println("Adjancy List: ");
        for(int i=0;i<v;i++){
            System.out.print(i +": ");
            for(int node:arrList.get(i)){
                System.out.print(node+ " ");
            }
            System.out.println();
        }
        s.close();
    }
}