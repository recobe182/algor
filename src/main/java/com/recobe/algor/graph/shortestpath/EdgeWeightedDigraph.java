package com.recobe.algor.graph.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {

    private final int v;
    private final List<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int v) {
        this.v = v;
        adj = (List<DirectedEdge>[])new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return v;
    }

}
