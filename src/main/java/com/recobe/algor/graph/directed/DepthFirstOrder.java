package com.recobe.algor.graph.directed;

import java.util.Stack;

public class DepthFirstOrder {

    private boolean[] marked;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(DiGraph g) {
        reversePost = new Stack<>();
        marked = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            if(!marked[v]) {
                dfs(g, v);
            }
        }
    }

    private void dfs(DiGraph g, int v) {
        marked[v] = true;
        for (int w: g.adj(v)) {
            if(!marked[w]) {
                dfs(g, w);
            }
        }
        reversePost.push(v);
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

}
