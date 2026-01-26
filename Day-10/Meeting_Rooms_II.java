// Day 10 - Meeting Rooms II
// LeetCode #253
// Difficulty: Medium
// Approach: Sorting + Two Pointers
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0, endPtr = 0;

        for (int i = 0; i < n; i++) {
            if (start[i] < end[endPtr]) {
                rooms++;
            } else {
                endPtr++;
            }
        }
        return rooms;
    }
}
