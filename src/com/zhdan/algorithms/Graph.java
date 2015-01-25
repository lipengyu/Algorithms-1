package com.zhdan.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * Interface which all graphs implement
 *
 * @author Egor Zhdan
 */
public interface Graph<E> {

    public void addEdge(Edge<E> edge);

    public Set<Edge<E>> getEdges(Vertex<E> from);

    public Set<Vertex<E>> getVertexes();

    public boolean containsVertex(Vertex<E> vertex);

    public boolean isDirected();


    public static class Vertex<T> implements Cloneable {

        public final T value;

        public Vertex(T value) {
            this.value = value;
        }

        @Override
        public Vertex<T> clone() {
            try {
                return (Vertex<T>) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof Vertex)) return false;

            Vertex<T> v = (Vertex<T>) obj;
            return value.equals(v.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }


    public static class Edge<T> implements Cloneable {

        public Vertex<T> from;
        public Vertex<T> to;
        public double length;

        public Edge(Vertex<T> from, Vertex<T> to, double length) {
            this.from = from.clone();
            this.to = to.clone();
            this.length = length;
        }

        public Edge(Vertex<T> from, Vertex<T> to) {
            this.from = from;
            this.to = to;
            this.length = 1;
        }

        public Edge<T> reversed() {
            return new Edge<>(to, from, length);
        }

        @Override
        protected Edge<T> clone() {
            try {
                return (Edge<T>) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof Edge)) return false;

            Edge<T> e = (Edge<T>) obj;
            return (length == e.length) && (from.equals(e.from)) && (to.equals(e.to));
        }

        @Override
        public String toString() {
            return from.value + " -> " + to.value;
        }

    }


    public static class Path<T> implements Cloneable {

        private ArrayList<Edge<T>> edges = new ArrayList<>();
        private double length = 0;

        public Path() {
        }

        public double length() {
            return length;
        }

        public ArrayList<Edge<T>> edges() {
            return edges;
        }

        public void addEdge(Edge<T> edge) {
            length += edge.length;
            edges.add(edge);
        }

        public void reverse() {
            Collections.reverse(edges);
        }

        @Override
        protected Path<T> clone() {
            try {
                return (Path<T>) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;

            Path path = (Path) o;

            if (Double.compare(path.length, length) != 0) return false;
            if (!edges.equals(path.edges)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = edges.hashCode();
            temp = Double.doubleToLongBits(length);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Edge item : edges) {
                builder.append(item.toString()).append(" ");
            }
            return builder.toString();
        }

    }


    public static class PathBuilder<T> {

        private HashMap<Vertex<T>, Edge<T>> prev = new HashMap<>();

        public PathBuilder() {
        }

        public Edge<T> previous(Vertex<T> vertex) {
            return prev.get(vertex);
        }

        public void setPrevious(Vertex<T> vertex, Edge<T> previous) {
            prev.put(vertex, previous);
        }

        public Path<T> toPath(Vertex<T> start, Vertex<T> end) {
            Path<T> path = new Path<>();
            Edge<T> current = previous(end);
            while (current != null) {
                path.addEdge(current);
                current = previous(current.from);
            }
            path.reverse();
            return path;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PathBuilder)) return false;

            PathBuilder builder = (PathBuilder) o;

            if (!prev.equals(builder.prev)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return prev.hashCode();
        }

    }


}
