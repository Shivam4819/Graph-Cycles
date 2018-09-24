/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

 
class Graph {
     
   
 
    public static void main(String[] args)
    {
        LoopDirectedGraph graph = new LoopDirectedGraph(4);
        graph.create();
        
        LoopUndirectedGraph loopUndirected = new LoopUndirectedGraph(5);
        loopUndirected.findloop();
        
        TotalCycles totalcycles =new TotalCycles();
        totalcycles.cycles();
        
        CyclesOfOddLength oddlength= new CyclesOfOddLength();
        oddlength.findCycles();
        
        
    }
}
 