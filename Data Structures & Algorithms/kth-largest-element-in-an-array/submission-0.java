class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Making it k+1 to avoid resizing under the hood
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.poll();
    }
}
