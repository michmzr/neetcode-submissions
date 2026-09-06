class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.length == 0) return 0

        var l=0
        var r=1
        var maxLength = 1
        var occurs = HashSet<Char>()
        occurs.add(s[0])

        while(r<s.length) {
            var rChar = s[r]

            if(occurs.contains(rChar)) {
                occurs.remove(s[l])
                l++
            } else {
                occurs.add(rChar)
                r++
            }

            maxLength = Math.max(maxLength, r-l)
        }

        return maxLength
    }
}
