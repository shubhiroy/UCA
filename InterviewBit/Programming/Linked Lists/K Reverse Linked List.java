/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    private ListNode reverse(ListNode a,int k){
        ListNode prev = a;
        ListNode curr = a.next;
        ListNode next;
        int i = 1;
        while(i<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        a.next = curr;
        return prev;
    }
    public ListNode reverseList(ListNode A, int B) {
        if(B==1){
            return A;
        }
        ListNode head = A;
        boolean first = true;
        while(head.next!=null){
            if(first){
                head = reverse(head,B);
                A = head;
                int i = 1;
    
                while(i<B){
                    head = head.next;
                    i++;
                }
                first = false;
            }else{
                head.next = reverse(head.next,B);
                int i = 1;
                while(i<=B){
                    head = head.next;
                    i++;
                }
            }
        }
        return A;
    }
}
