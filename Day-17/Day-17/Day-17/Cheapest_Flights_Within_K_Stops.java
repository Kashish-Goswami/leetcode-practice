// Day 17 - Cheapest Flights Within K Stops
// LeetCode #787
// Difficulty: Medium / Hard
// Approach: BFS + Relaxation
// Time Complexity: O(E * K)
// Space Complexity: O(V)

import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int node = curr[0], price = curr[1];

                for (int[] nei : graph[node]) {
                    int next = nei[0], wt = nei[1];
                    if (price + wt < cost[next]) {
                        cost[next] = price + wt;
                        q.offer(new int[]{next, cost[next]});
                    }
                }
            }
            stops++;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
          }
