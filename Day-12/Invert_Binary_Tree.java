// Day 12 - Invert Binary Tree
// LeetCode #226
// Difficulty: Easy
// Approach: DFS
// Time Complexity: O(n)
// Space Complexity: O(h)

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}

