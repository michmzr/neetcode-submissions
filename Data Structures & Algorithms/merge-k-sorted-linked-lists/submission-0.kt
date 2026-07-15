/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeLists(arr1: ListNode?, arr2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy

        var pos1 = arr1
        var pos2 = arr2

        while (pos1 != null && pos2 != null) {
            if (pos1.`val` <= pos2.`val`) {
                current.next = pos1
                pos1 = pos1.next
            } else {
                current.next = pos2
                pos2 = pos2.next
            }

            current = current.next!!
        }

        current.next = pos1 ?: pos2

        return dummy.next

    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        var result: ListNode? = null

        for (list in lists) {
            result = mergeLists(result, list)
        }

        return result
    }
}