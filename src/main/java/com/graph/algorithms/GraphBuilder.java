package com.graph.algorithms;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class GraphBuilder {
    private Graph<String, DefaultEdge> graph;

    public GraphBuilder() {
        graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    }

    public Graph<String, DefaultEdge> getGraph() {
        return graph;
    }

    public void addVertex(String vertex) {
        graph.addVertex(vertex);
    }

    public void addEdge(String source, String target) {
        graph.addEdge(source, target);
    }
}
