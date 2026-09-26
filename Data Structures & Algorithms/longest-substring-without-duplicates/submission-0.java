// TC: O(N) iterating through string
// SC: O(N) storing in map
// Algorithm:

// Hints / Pointers: When we iterate through the string and add more chars, when we get rid of the a char, we're literally getting rid of the leftmost one

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Where we'll store the characters
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, longest = 0;
        // Iterate through the string
        for (int right = 0; right < s.length(); right++) {
            // If the map contains the character then we can update left
            if (map.containsKey(s.charAt(right))) {
                // Left is going to be either the last known location of the character or itself, whichever is bigger, ensuring that we always move forward
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            
            // now, we need to put this right char into our window for later
            map.put(s.charAt(right), right);
            // at each iteration we have to calc the longest string so far, 
            // so we get max of longest vs the current window length
            longest = Math.max(longest, right - left + 1);
        }
        // Just return what we found
        return longest;
    }
}
