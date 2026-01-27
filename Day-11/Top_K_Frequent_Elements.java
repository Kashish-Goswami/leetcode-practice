// Day 11 - Top K Frequent Elements
// LeetCode #347
// Difficulty: Medium
// Approach: HashMap + Min Heap
// Time Complexity: O(n log k)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        for (int key : freq.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
