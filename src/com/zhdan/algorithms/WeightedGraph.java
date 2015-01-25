package com.zhdan.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for storing graphs with weighted edges
 *
 * @author Egor Zhdan
 */
public class WeightedGraph<E> implements Graph<E>, Cloneable {

    protected HashMap<Vertex<E>, HashSet<Edge<E>>> adjacencyLists = new HashMap<>();
    protected final boolean directed;

    public WeightedGraph(boolean isDirected) {
        this.directed = isDirected;
    }

    @Override
    public void addEdge(Edge<E> edge) {
        if (!adjacencyLists.containsKey(edge.from)) {
            adjacencyLists.put(edge.from, new HashSet<>());
        }
        if (!adjacencyLists.containsKey(edge.to)) {
            adjacencyLists.put(edge.to, new HashSet<>());
        }

        adjacencyLists.get(edge.from).add(edge);
        if (!directed) {
            adjacencyLists.get(edge.to).add(edge.reversed());
        }
    }

    @Override
    public Set<Edge<E>> getEdges(Vertex<E> from) {
        return adjacencyLists.get(from);
    }

    @Override
    public Set<Vertex<E>> getVertexes() {
        return adjacencyLists.keySet();
    }

    public boolean containsVertex(Vertex<E> vertex) {
        return adjacencyLists.containsKey(vertex);
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public WeightedGraph<E> clone() {
        try {
            return (WeightedGraph<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
