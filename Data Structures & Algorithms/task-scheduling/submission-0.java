class Solution {

    private class CooldownTask {
        int remaining;
        int readyTime;

        CooldownTask(int remaining, int readyTime) {
            this.remaining = remaining;
            this.readyTime = readyTime;
        }

    }
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        // Add the tasks to the queue now.
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                maxHeap.offer(counts[i]);
            }
        }

        // We also need the cool down Queue

        Queue<CooldownTask> cooldownQueue = new ArrayDeque<>();
        int currentTime = 0;  
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            currentTime++;
            if (maxHeap.isEmpty()) {
                // Fast forward so we dont waste cycles
                currentTime = cooldownQueue.peek().readyTime;
            }
            else {
                // get the task and decrement it so see if we still have identical tasks
                int remainingCount = maxHeap.poll() - 1;
                // if still has left over, add it to cooldown Q, currentTime + n (cycles)
                if (remainingCount > 0) cooldownQueue.offer(new CooldownTask(remainingCount, currentTime + n));
            }

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek().readyTime == currentTime) {
                maxHeap.offer(cooldownQueue.poll().remaining);    
            }
        }
        return currentTime;
    }
}
