// Day 11 - Kth Largest Element in an Array
// LeetCode #215
// Difficulty: Medium
// Approach: Min Heap
// Time Complexity: O(n log k)
// Space Complexity: O(k)

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
