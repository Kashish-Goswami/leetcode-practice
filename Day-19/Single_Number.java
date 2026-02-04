// Day 19 - Single Number
// LeetCode #136
// Difficulty: Easy
// Concept: XOR
// Time: O(n)
// Space: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
