package com.recobe.algor.graph.mst;


import com.recobe.algor.util.MinPQ;
import com.recobe.algor.util.UF;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class KruskalMST {

    private Queue<Edge> mst = new SynchronousQueue<>();

    public KruskalMST(EdgeWeightedGraph g) {
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e: g.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(g.V());
        while(!pq.isEmpty() && mst.size() < g.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if(!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

}
