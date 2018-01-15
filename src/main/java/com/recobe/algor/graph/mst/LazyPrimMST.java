package com.recobe.algor.graph.mst;

import com.recobe.algor.util.MinPQ;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class LazyPrimMST {

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph g) {
        pq = new MinPQ<>();
        mst = new SynchronousQueue<>();
        marked = new boolean[g.V()];
        visit(g, 0);

        while(!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w])
                continue;
            mst.add(e);
            if(!marked[v])
                visit(g, v);
            if(!marked[w])
                visit(g, w);
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e: g.adj(v)) {
            if(!marked[e.other(v)])
                pq.insert(e);
        }
    }

    public Iterable<Edge> mst() {
        return mst;
    }

}
