class Solution {
     fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { HashSet<Char>() }
        val cols =  Array(9) { HashSet<Char>() }
        val box =  Array(9) { HashSet<Char>() }

        for(r in 0..8) {
            for(c in 0..8) {
                val ch = board[r][c]
                if(ch=='.') continue

                val boxIndex = (r / 3) * 3 + (c / 3)

                if(!rows[r].add(ch))
                    return false
                if(!cols[c].add(ch))
                    return false
                if(!box[boxIndex].add(ch))
                    return false
            }
        }

        return true
    }
}
