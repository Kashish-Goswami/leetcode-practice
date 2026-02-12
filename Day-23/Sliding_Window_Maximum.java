// Day 23 - Sliding Window Maximum
// LeetCode #239
// Difficulty: Hard
// Concept: Monotonic Deque

import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {

            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offerLast(i);

            if (i >= k - 1)
                result[idx++] = nums[dq.peekFirst()];
        }

        return result;
    }
}
