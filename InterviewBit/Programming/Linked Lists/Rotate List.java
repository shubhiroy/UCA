/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode A, int B) {
        int size = 0;
        ListNode curr = A;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        B = B%size;
        if(B==0){
            return A;
        }
        B = size - B;
        ListNode head = A, prev = null,next=null;
        curr = A;
        int num = 0;
        while(curr.next!=null){
            num++;
            if(num==B){
                prev = curr;
                next = curr.next;
            }
            curr = curr.next;
        }
        prev.next = null;
        curr.next = head;
        return next;
    }
}
