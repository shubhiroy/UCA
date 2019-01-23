/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    private ListNode reversePair(ListNode a){
        ListNode prev = a;
        ListNode next = a.next;
        prev.next = next.next;
        next.next = prev;
        return next;
    }
    public ListNode swapPairs(ListNode A) {
        ListNode head = A;
        boolean first = true;
        if(head.next==null || head == null){
            return head;
        }
        if(head.next.next == null){
            return reversePair(head);
        }
        while(head.next!=null && head.next.next!=null){
            if(first){
                head = reversePair(head);
                A = head;
                head = head.next;
                first = false;
            }else{
                head.next = reversePair(head.next);
                head = head.next.next;
            }
        }
        return A;
    }
}
