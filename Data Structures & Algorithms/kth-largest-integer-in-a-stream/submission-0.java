class KthLargest {
    
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        // Doing k + 1 so we avoid it from resizing under the hood
        minHeap = new PriorityQueue<>(k + 1);  
        for (int num : nums) add(num);
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) minHeap.poll();

        return minHeap.peek();
    }
}
