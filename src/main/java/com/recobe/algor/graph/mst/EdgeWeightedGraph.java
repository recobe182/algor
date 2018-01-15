package com.recobe.algor.graph.mst;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {

    private final int v;
    private final List<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.v = v;
        adj = (ArrayList<Edge>[])new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return v;
    }

    public Iterable<Edge> edges() {
        List<Edge> list = new ArrayList<>();
        for (int v = 0; v < this.v; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

}
