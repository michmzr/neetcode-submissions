class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) return 0

        var maxLength = 1
        var occurs = HashMap<Char, Int>()
        var l = 0

        for(r in s.indices) {
            val c = s[r]
            var lastOccur = occurs[c]

            if(lastOccur!=null && lastOccur >= l) {
                l = lastOccur + 1
            }

            occurs[c] = r
            maxLength = Math.max( maxLength, r - l + 1)
        }
        
        return maxLength
    }
}
