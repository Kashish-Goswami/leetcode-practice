// Day 12 - Maximum Depth of Binary Tree
// LeetCode #104
// Difficulty: Easy
// Approach: DFS (Recursion)
// Time Complexity: O(n)
// Space Complexity: O(h)

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(
                maxDepth(root.left),
                maxDepth(root.right)
        );
    }
}
