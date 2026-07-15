/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummy: ListNode = ListNode(-1)
        var current: ListNode = dummy

        var pos1 = l1
        var pos2 = l2

        var nrPos = 0
        var carry=0

        while (pos1 != null || pos2 != null || carry != 0) {
            val sum =  (pos1?.`val` ?: 0) + (pos2?.`val` ?: 0) + carry

            carry = sum / 10

           // println("$nrPos -> pos1: ${pos1?.`val`}, pos2: ${pos2?.`val`}, sum: $sum carry: $carry, pos1.next: ${pos1?.next?.`val`}, pos2.next: ${pos2?.next?.`val`}")

            current.next = ListNode(sum % 10)
            current = current.next!!

            pos1 = pos1?.next
            pos2 = pos2?.next
        }

        return dummy.next
    }
}
