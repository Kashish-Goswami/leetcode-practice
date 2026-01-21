// Day 05 - Remove Element
// LeetCode #27
// Difficulty: Easy
// Approach: Two Pointers
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int num : nums) {
            if (num != val) {
                nums[index] = num;
                index++;
            }
        }
        return index;
    }
}
