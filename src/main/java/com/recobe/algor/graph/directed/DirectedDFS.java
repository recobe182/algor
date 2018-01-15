package com.recobe.algor.graph.directed;

public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(DiGraph g, int s) {
        dfs(g, s);
    }

    private void dfs(DiGraph g, int v) {
        marked[v] = true;
        for (int w: g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean visited(int v) {
        return marked[v];
    }

}
