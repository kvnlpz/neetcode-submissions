class MedianFinder {

    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;


    public MedianFinder() {
        this.smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.largeHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if (smallHeap.isEmpty() || smallHeap.peek() >= num) {
            smallHeap.add(num);
        }
        else largeHeap.add(num);
        

        // rebalance

        if (smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.add(smallHeap.poll());
        } else if (largeHeap.size() > smallHeap.size()) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        } else return smallHeap.peek();
        
    }
}
