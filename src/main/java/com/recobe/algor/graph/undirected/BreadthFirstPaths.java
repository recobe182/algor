package com.recobe.algor.graph.undirected;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;

    private void bfs(Graph g, int s) {
        Queue<Integer> q = new SynchronousQueue<>();
        q.add(s);
        marked[s] = true;
        while(!q.isEmpty()) {
            int v = q.poll();
            for (int w: g.adj(v)) {
                if(!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

}
