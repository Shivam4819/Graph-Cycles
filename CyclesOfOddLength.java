/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;
import java.util.*;

public class CyclesOfOddLength {
    public static int V =4;
     
    public static boolean containsOdd(int G[][], int src){
        int colorArr[] = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;
       
        colorArr[src] = 1;
       
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);
       
        while (!q.isEmpty()){
            int u = q.peek();
            q.pop();
       
            if (G[u][u] == 1)
               return true;  
       
            for (int v = 0; v < V; ++v){
                if (G[u][v] == 1 && colorArr[v] == -1){
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }
       
                else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
                    return true;
            }
        }
       
        return false;
    }
     
    public  void findCycles(){
 
        int G[][] = {{0, 1, 0, 1},
                     {1, 0, 1, 0},
                     {0, 1, 0, 1},
                     {1, 0, 1, 0}};
                                   
           if (containsOdd(G, 0))
               System.out.println("Yes") ;
            else
                   System.out.println("No");
    }
}
