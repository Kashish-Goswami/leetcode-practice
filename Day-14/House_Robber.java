// Day 14 - House Robber
// LeetCode #198
// Difficulty: Medium
// Approach: DP
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int rob(int[] nums) {
        int prev1 = 0, prev2 = 0;

        for (int num : nums) {
            int temp = Math.max(prev2 + num, prev1);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
}
