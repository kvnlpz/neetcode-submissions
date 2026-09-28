class Solution {
    public String minWindow(String s, String t) {
        // Check inputs first before doing any work
        if (s.length() < t.length() || t.isEmpty()) {
            return "";
        }

        // Use a 128 size int array to represent ASCII chars
        int[] charCounts = new int[128];
        // Fill it in with the ones we have
        for (char c : t.toCharArray()) {
            charCounts[c]++;
        }

        int left = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        // Use this to track how many total chars needed
        int charsNeeded = t.length();


        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            // if it's a char we still need, decrement our req counter
            if (charCounts[rightChar] > 0) {
                charsNeeded--;
            }

            // Now, since we moved the window more to the right and now have this char in it, we can dec char counts

            charCounts[rightChar]--;


            // Check if we have a valid window, and if we do, check if we can make it smaller
            while (charsNeeded == 0) {
                int currentWindowLength = right - left + 1;

                if(currentWindowLength < minLength) {
                    // if we found a smaller min length then just update it to the smaller one
                    minLength = currentWindowLength;
                    // change the value of minstart because it is at a new index now
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                // Remove the left character from our window because we're moving the window to the right
                charCounts[leftChar]++;

                // if this move caused us to need more chars, it means the window broke, because we dropped a required character.
                if (charCounts[leftChar] > 0) {
                    charsNeeded++;
                }

                left++;

            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);

    }
}
