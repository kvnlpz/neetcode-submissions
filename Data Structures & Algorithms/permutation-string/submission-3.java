// TC: O(L_1 + L_2) let L_1 be the length of s1 and L_2 be the length of s2 however it's multiplied by 26 because at each step we're comparing the two arrays and it can be optimized surely 
// SC: O(1) since we're using 2 arrays that represent the alphabet (26 characters constant)
// Algorithm: use 2 arrays, 1 for window count of chars and another for target count of chars. 
// fill them both in while iterating thru s1 and then when iterating through s2 for our sliding window approach, remove from left as window moves and add from right as window moves. At each step, compare the arrays. return true if same array contents, false if none found at end

// Facts: 2 strings given, s1,s2
// ret true if s2 contains permutation of s1 else false
// Both in lowercase


// Example:
// s1 = abc, s2 = lecabee
// you can see that lecabee has all three, a-b-c in it, so we can return true ("cab")

// Example: s1=abc, s2=lecaabee
// it's false because while s2 has all a,b,c, it's has an extra a in it 

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Cant have a permutation of a larger string inside of a smaller string...
        if (s1.length() > s2.length()) {
            return false;
        }


        int[] targetCount = new int[26];
        int[] windowCount = new int[26];

        int windowSize = s1.length();

        // Initialize the frequency array for the first window 
        for(int i = 0; i < s1.length(); i++) {
            targetCount[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        // Slide the window accross the rest of s2
        for (int i = windowSize; i < s2.length(); i++) {
            
            // We have to compare the arrays to ensure they're both the same
            // If both eq -> permutation
            if (Arrays.equals(targetCount, windowCount)) {
                return true;
            }

            // Add the new char entering the window on right
            windowCount[s2.charAt(i) - 'a']++;

            // We still have to remove the old char
            windowCount[s2.charAt(i - windowSize) - 'a']--;


        }
        // Check the final window
        return Arrays.equals(targetCount, windowCount);
    }
}
