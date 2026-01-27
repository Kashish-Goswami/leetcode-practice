// Day 11 - Find Median from Data Stream
// LeetCode #295
// Difficulty: Hard
// Approach: Two Heaps
// Time Complexity: O(log n)
// Space Complexity: O(n)

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> maxHeap; // left half
    PriorityQueue<Integer> minHeap; // right half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
