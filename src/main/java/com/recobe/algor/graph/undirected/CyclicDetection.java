package com.recobe.algor.graph.undirected;

public class CyclicDetection {

    public boolean isCyclic(Graph g) {
        boolean[] marked = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            if(!marked[v]) {
                if(dfs(g, marked, v, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(Graph g, boolean[] marked, int v, int parent) {
        marked[v] = true;
        for (int w: g.adj(v)) {
            if (!marked[w]) {
                if(dfs(g, marked, w, v)) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }


}
