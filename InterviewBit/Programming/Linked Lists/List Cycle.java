/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    private ListNode removeCycle(ListNode slow, ListNode fast){
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = removeCycle(a,fast);
                return slow;
            }
        }
        return null;
    }
}