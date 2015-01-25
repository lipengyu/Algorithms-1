package com.zhdan.algorithms;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Class for storing graphs with unweighted edges
 *
 * @author Egor Zhdan
 */
public class UnweightedGraph<E> extends WeightedGraph<E> implements Graph<E> {

    private HashMap<Vertex<E>, HashSet<Edge<E>>> adjacencyLists = new HashMap<>();

    public UnweightedGraph(boolean isDirected) {
        super(isDirected);
    }

    @Override
    public void addEdge(Edge<E> edge) {
        assert edge.length == 1;
        super.addEdge(edge);
    }

    @Override
    public UnweightedGraph<E> clone() {
        return (UnweightedGraph<E>) super.clone();
    }

}
