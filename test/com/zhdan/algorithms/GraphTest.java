package com.zhdan.algorithms;

import org.junit.Test;

import java.util.Map;

public class GraphTest {

    @Test
    public void testShortestPath() {
        WeightedGraph<Integer> graph = new WeightedGraph<>(false);
        graph.addEdge(new Graph.Edge<>(new Graph.Vertex<>(1), new Graph.Vertex<>(2), 1));
        graph.addEdge(new Graph.Edge<>(new Graph.Vertex<>(2), new Graph.Vertex<>(3), 4));
        graph.addEdge(new Graph.Edge<>(new Graph.Vertex<>(1), new Graph.Vertex<>(3), 6));
        Map<Graph.Vertex, Graph.Path> result = Graphs.getPaths(graph, new Graph.Vertex(1));
        for (Map.Entry<Graph.Vertex, Graph.Path> e : result.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

}