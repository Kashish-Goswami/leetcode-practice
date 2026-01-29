// Day 13 - Course Schedule
// LeetCode #207
// Difficulty: Medium
// Approach: DFS + Cycle Detection
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        int[] visited = new int[numCourses]; // 0=unvisited, 1=visiting, 2=done

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int node) {
        visited[node] = 1;

        for (int nei : graph.get(node)) {
            if (visited[nei] == 1) return false;
            if (visited[nei] == 0 && !dfs(graph, visited, nei)) return false;
        }

        visited[node] = 2;
        return true;
    }
}
