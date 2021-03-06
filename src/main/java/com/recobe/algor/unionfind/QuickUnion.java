package com.recobe.algor.unionfind;

public class QuickUnion
{
    private int[] id;
    private int[] sz;
    public QuickUnion(int N)
    {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }
    public int root(int i)
    {
        while (i != id[i])
        {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean find(int p, int q)
    {
        return root(p) == root(q);
    }
    public void unite(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}