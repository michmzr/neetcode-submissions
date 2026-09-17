class Solution {
  fun validRow(row: CharArray): Boolean {
        val onlyNumbers = row.filter { it != '.' }

        return onlyNumbers == onlyNumbers.distinct()
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        //Valid rows
        val hasValidRows = board.all { row ->
            validRow(row)
        }

        if(!hasValidRows) {
          //  println("It has invalid row")
            return false
        }

        //Valid columns
        val columns = mutableListOf<CharArray>()
        for (c in 0..8) {
            columns.add(board.map { row -> row[c] }.toCharArray())
        }
        val hasValidCols = columns.all { row ->
            validRow(row)
        }

        if(!hasValidCols) {
           // println("It has invalid column")
            return false
        }

        //Validate cells
        for(cell in 0..8) {
            /**
             * 0 1 2
             * 3 4 5
             * 6 7 8
             */
            val rStart:Int = (cell / 3)*3
            val cInd:Int = (cell %3) * 3
            println("r: $rStart, c: $cInd")
            val cellEls = charArrayOf(
                board[rStart][cInd], board[rStart][cInd + 1], board[rStart][cInd + 2],
                board[rStart + 1][cInd], board[rStart + 1][cInd + 1], board[rStart + 1][cInd + 2],
                board[rStart + 2][cInd], board[rStart + 2][cInd + 1], board[rStart + 2][cInd + 2]
            )

            if(!validRow(cellEls)) {
                //println("Invalid cell: $cell - ${cellEls.contentToString()}")
                return false
            }
        }

        return true
    }
}
