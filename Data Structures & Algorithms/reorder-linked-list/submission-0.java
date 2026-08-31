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
        ListNode reversed = null;
        printList(head);

        ListNode it = head.next;
        int nr = 1;
        int n=0;
        while(it != null) {
            System.out.println("it: " + it.val + " next: " + it.next);
            ListNode tmp = new ListNode(it.val, reversed);
            reversed = tmp;

            it = it.next;
            n++;
        }

        ListNode hIt = head;
        ListNode rIt = reversed;

        ListNode currNode = head;
        for(int i=1; i < n/2; i++) {
            // todo
            hIt.next = rIt;
            hIt = hIt.next;
            rIt = rIt.next;
        }

        printList(head);
    }
}
