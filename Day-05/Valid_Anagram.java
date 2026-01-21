// Day 05 - Valid Anagram
// LeetCode #242
// Difficulty: Easy
// Approach: Frequency Count
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
}
