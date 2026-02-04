// Day 19 - Sum of Two Integers
// LeetCode #371
// Difficulty: Medium
// Concept: Bit Manipulation

class Solution {
    public int getSum(int a, int b) {

        while (b != 0) {

            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
