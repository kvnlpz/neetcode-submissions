// TC: O(n) since we're just iterating through the string, and we're keeping track of the maxFrequency at every step instead of calculating it by going through the Map
// SC: O(m) m is the total number of unique chars in the string

// Algorithm: iterate through the string, add right pointer chars to window, at each step, calculate the maxFrequency so that you can see if the calculation is below the max K changes you can make. if it's not below, you need to shorten the window so you move left forward and remove the character from the window (map)


class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int result = 0;

        int left = 0, maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxFrequency = Math.max(maxFrequency, count.get(s.charAt(right)));
            // While the window has more changes than our given k, we move the left pointer forward to remove chars
            while ((right - left + 1) - maxFrequency > k) {
              count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
             // move left pointer forward
            left++;
        }

        // Calculate the window size 
        result = Math.max(result, right - left + 1);

        }
        return result;
    }
}
