// Day 17 - Redundant Connection
// LeetCode #684
// Difficulty: Medium
// Approach: Union-Find
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (find(u) == find(v)) {
                return edge;
            }
            parent[find(u)] = find(v);
        }
        return new int[0];
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
                             }
