// Day 15 - Combination Sum
// LeetCode #39
// Difficulty: Medium
// Approach: Backtracking
// Time Complexity: Exponential
// Space Complexity: O(target)

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int index, int target, int[] nums,
                           List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) return;

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i, target - nums[i], nums, path, res);
            path.remove(path.size() - 1);
        }
    }
}
