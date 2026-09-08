/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
      fun goodNodes(root: TreeNode?): Int {
        //Jak pozyskac informacje, ktore nody sa wieksze dla aktualnej liczby
        require(root != null)

        return traverse(root, root.`val`)
    }

    fun traverse(node: TreeNode, maxValue: Int): Int {
        val nodeValue = node.`val`

        var found = 0

        if( nodeValue >= maxValue)
            found++

        if(node.left != null) {
            found += traverse(node.left!!, max(nodeValue, maxValue))
        }

        if(node.right != null) {
            found += traverse(node.right!!, max(nodeValue, maxValue))
        }

        return found
    }
}
