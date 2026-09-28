class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Use a deque to hold indexes
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];

        // Now iterate through the nums array for the window
        for (int i = 0; i < nums.length; i++) {
            // if the first index in the deque is less than the first index of our window, it needs to leave
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // keep the deque monotonic
            // if the last number in the deque is less than the current number then it is useless to us, so we can get rid of it, it will not outlast them in the window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Now we add the current index to the back of the Deque
            deque.offerLast(i);

            // Checking to see if now our window is big enough (for example if k=3 then we need to get 3 indices long)
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }


        }

        return result;

    }
}
