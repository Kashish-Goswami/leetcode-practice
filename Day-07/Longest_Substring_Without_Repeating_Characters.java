// Day 07 - Longest Substring Without Repeating Characters
// LeetCode #3
// Difficulty: Medium
// Approach: Sliding Window + HashSet
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
