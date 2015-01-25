package com.zhdan.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Static methods to work with graphs
 *
 * @author Egor Zhdan
 */
public final class Graphs {

    private Graphs() {
    }

    /**
     * Returns distances from given to all vertexes in the given graph
     *
     * @param graph graph
     * @param from source vertex
     * @return map with format {vertex: distance}
     */
    public static Map<Graph.Vertex, Double> getDistances(Graph graph, Graph.Vertex from) {
        if (!graph.containsVertex(from)) {
            throw new IllegalArgumentException("graph doesn't contain this vertex");
        }

        /* Dijkstra algorithm with Set */

        HashMap<Graph.Vertex, Double> dist = new HashMap<>();
        for (Graph.Vertex vertex : (Set<Graph.Vertex>) graph.getVertexes()) {
            dist.put(vertex, Double.POSITIVE_INFINITY / 2);
        }
        dist.put(from, (double) 0);

        TreeSet<Graph.Vertex> vertexQueue = new TreeSet<>((v1, v2) -> {
            double d1 = dist.get(v1);
            double d2 = dist.get(v2);
            return Double.compare(d2, d1);
        });
        vertexQueue.add(from);
        while (!vertexQueue.isEmpty()) {
            Graph.Vertex u = vertexQueue.pollFirst();

            // Visit each edge exiting u
            for (Graph.Edge e : (Set<Graph.Edge>) graph.getEdges(u)) {
                Graph.Vertex v = e.to;
                double distanceThroughU = dist.get(u) + e.length;
                if (distanceThroughU < dist.get(v)) {
                    vertexQueue.remove(v);
                    dist.put(v, distanceThroughU);
                    vertexQueue.add(v);
                }
            }
        }

        return dist;
    }

    /**
     * Returns paths from given to all vertexes in the given graph
     *
     * @param graph graph
     * @param from source vertex
     * @return map with format {vertex: path}
     */
    public static Map<Graph.Vertex, Graph.Path> getPaths(Graph graph, Graph.Vertex from) {
        if (!graph.containsVertex(from)) {
            throw new IllegalArgumentException("graph doesn't contain this vertex");
        }

        /* Dijkstra algorithm with Set */

        HashMap<Graph.Vertex, Double> dist = new HashMap<>();
        for (Graph.Vertex vertex : (Set<Graph.Vertex>) graph.getVertexes()) {
            dist.put(vertex, Double.POSITIVE_INFINITY / 2);
        }
        dist.put(from, (double) 0);

        Graph.PathBuilder builder = new Graph.PathBuilder();

        TreeSet<Graph.Vertex> vertexQueue = new TreeSet<>((v1, v2) -> {
            double d1 = dist.get(v1);
            double d2 = dist.get(v2);
            return Double.compare(d2, d1);
        });
        vertexQueue.add(from);
        while (!vertexQueue.isEmpty()) {
            Graph.Vertex u = vertexQueue.pollFirst();

            // Visit each edge exiting u
            for (Graph.Edge e : (Set<Graph.Edge>) graph.getEdges(u)) {
                Graph.Vertex v = e.to;
                double distanceThroughU = dist.get(u) + e.length;
                if (distanceThroughU < dist.get(v)) {
                    vertexQueue.remove(v);
                    dist.put(v, distanceThroughU);
                    builder.setPrevious(v, e);
                    vertexQueue.add(v);
                }
            }
        }

        HashMap<Graph.Vertex, Graph.Path> paths = new HashMap<>();
        for (Graph.Vertex v : (Set<Graph.Vertex>) graph.getVertexes()) {
            paths.put(v, builder.toPath(from, v));
        }
        return paths;
    }

}
