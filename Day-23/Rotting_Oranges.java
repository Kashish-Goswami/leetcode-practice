// Day 23 - Rotting Oranges
// LeetCode #994
// Concept: Multi-source BFS

import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});

                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            while (size-- > 0) {

                int[] curr = queue.poll();

                for (int[] d : dirs) {

                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if (r >= 0 && c >= 0 &&
                        r < grid.length && c < grid[0].length &&
                        grid[r][c] == 1) {

                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
