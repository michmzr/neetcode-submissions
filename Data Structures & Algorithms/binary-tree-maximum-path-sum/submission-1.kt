/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
     fun TreeNode.value(): Int = `val`

    private var maxSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        maxSum = Int.MIN_VALUE
        dfs(root)
        return maxSum
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val leftGain = max(dfs(node.left), 0)
        val rightGain = max(dfs(node.right), 0)

        // Aktualizuj globalny wynik — ścieżka może łączyć oba poddrzewa
        maxSum = max(maxSum, node.value() + leftGain + rightGain)

        // Zwróć do rodzica tylko jeden "ogon" — najlepszy kierunek
        return node.value() + max(leftGain, rightGain)
    }
}
