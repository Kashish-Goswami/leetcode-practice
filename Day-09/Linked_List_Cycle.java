// Day 09 - Linked List Cycle
// LeetCode #141
// Difficulty: Easy
// Approach: Floyd’s Cycle Detection
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }
}
