/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;
/**
 *
 * @author shubham
 */
public class LoopUndirectedGraph {
     private int V;   
    private LinkedList<Integer> adj[]; 
 
    LoopUndirectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    void addEdge(int v,int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
 
    Boolean isCyclicUtil(int v, Boolean visited[], int parent) {
        visited[v] = true;
        Integer i;
 
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
 
            else if (i != parent)
                return true;
        }
        return false;
    }
    Boolean isCyclic(){
     Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        for (int u = 0; u < V; u++)
            if (!visited[u]) 
                if (isCyclicUtil(u, visited, -1))
                    return true;
 
        return false;
    }
 
    public void findloop(){
       
        LoopUndirectedGraph g1 = new LoopUndirectedGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
 
        LoopUndirectedGraph g2 = new LoopUndirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }

}
