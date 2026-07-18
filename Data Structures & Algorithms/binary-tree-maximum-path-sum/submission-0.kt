/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun TreeNode.value(): Int = `val`

    fun maxPathSum(root: TreeNode?): Int {
        //key - node hash, value - max sum of path found
        var nodeSums = mutableMapOf<Int, Int>()
        var nodesStack: ArrayDeque<TreeNode> =  ArrayDeque<TreeNode>()
        var maxSum: Int = Int.MIN_VALUE

        nodesStack.add(root!!);

        while (nodesStack.isNotEmpty()) {

            val node = nodesStack.removeLast()
            println("Node: ${node.value()}, left: ${node.left}, right: ${node.right}")

            var nodeSum =  nodeSums.getOrPut(node.hashCode()){node.value()}
            var leftNodeValSum = if(root.left != null) root.left!!.value() + nodeSum else Int.MIN_VALUE
            var rightNodeValSum = if(root.right != null) root.right!!.value() + nodeSum else Int.MIN_VALUE

            println("leftSum: $leftNodeValSum, rightSum: $rightNodeValSum")
            if(node.left != null && (nodeSum + node.left!!.value()) > nodeSum) {
               nodeSum += node.left!!.value()
            }

            if(node.right != null && (nodeSum + node.right!!.value()) > nodeSum) {
                nodeSum += node.right!!.value()
            }

            if(nodeSum > maxSum)
                maxSum = nodeSum

            nodeSums[node.hashCode()] = nodeSum

            if(node.left != null) {
                nodesStack.add(node.left!!)
            }

            if(node.right != null) {
                nodesStack.add(node.right!!)
            }

            println("+++++++++++++++++++++++++++++")
        }

        return maxSum
    }
}
