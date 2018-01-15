package com.recobe.algor.graph.directed;

import java.util.ArrayList;
import java.util.List;

public class DiGraph {

    private final int V;
    private List<Integer>[] adj;

    public DiGraph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

}
