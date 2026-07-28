// TC: O(n) as we're just iterating through the input list of strings
// SC: O(k) where k is the size of the list we make from the decoded string. which is dependent on the input string we've been given
// Algorithm: Basically, just go through the input list of strings and add them to a string builder but with a non ascii delimiter so that we can distinguish where words start and stop for when we decode
// then when we have to decode the string, we use the builtin .split() function with the same delimiter and then remove the last item in the list because that's just an empty string which happens by default

class Solution {

    fun encode(strs: List<String>): String {
        return strs.joinToString("") {"$it🧿"}

    }

    fun decode(str: String): List<String> {
        return str.split("🧿").dropLast(1)
    }
}
