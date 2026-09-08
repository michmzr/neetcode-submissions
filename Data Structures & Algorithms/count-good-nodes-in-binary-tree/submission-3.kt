/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
       fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0

        return traverse(root, root.`val`)
    }

    private fun traverse(node: TreeNode?, pathMaximum: Int): Int {
        if (node == null) return 0

        val isGood = if (node.`val` >= pathMaximum) 1 else 0
        val newMaximum = max(pathMaximum, node.`val`)

        return isGood +
            traverse(node.left, newMaximum) +
            traverse(node.right, newMaximum)
    }
}
