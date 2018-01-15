package com.recobe.algor.graph.directed;

public class CyclicDetection {

    public boolean isCyclic(DiGraph g) {
        boolean[] marked = new boolean[g.V()];
        boolean[] recStack = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            if (!marked[v]) {
                if (dfs(g, v, marked, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(DiGraph g, int v, boolean[] marked, boolean[] recStack) {
        marked[v] = true;
        recStack[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                if (dfs(g, w, marked, recStack)) {
                    return true;
                }
            } else if (recStack[w]) {
                return true;
            }
        }
        recStack[v] = false;
        return false;
    }

}
