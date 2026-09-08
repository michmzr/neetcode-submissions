class Solution {
     val NUMS = mapOf(
        2 to  listOf('a', 'b', 'c'),
        3 to  listOf('d', 'e', 'f'),
        4 to  listOf('g', 'h', 'i'),
        5 to  listOf('j', 'k', 'l'),
        6 to  listOf('m', 'n', 'o'),
        7 to  listOf('p', 'q', 'r', 's'),
        8 to  listOf('t', 'u', 'v'),
        9 to  listOf('w', 'x', 'y', 'z'),
        )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val results = mutableListOf<String>()
        val current = StringBuilder()

        fun backtrack(index: Int) {
            if (index == digits.length) {
                results.add(current.toString())
                return
            }

            val digit = digits[index] - '0'
            val letters = NUMS[digit] ?: return

            for (ch in letters) {
                current.append(ch)
                backtrack(index + 1)
                current.deleteCharAt(current.length - 1)
            }
        }

        backtrack(0)
        return results
    }
}
