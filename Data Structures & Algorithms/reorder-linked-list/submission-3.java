/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void printList(ListNode head) {
         ListNode it = head;

         while(it != null) {
            System.out.print(it.val + " ");
            it= it.next;
        }
        System.out.println("\n");    
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        printList(head);

        // Split on 2 groups - in half
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

       //System.out.println("slow: " + slow.val);
        //System.out.println("fast: " + fast.val);
    
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        
        // Reverse second half
        ListNode tmp;
        while(second != null) {
            tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        ListNode first = head;
        second = prev;

        // Merge results of 2 lists
        ListNode tmp1;
        ListNode tmp2;
        while(second != null) {
            tmp1 = first.next;
            tmp2 = second.next;

            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    
    }
}
