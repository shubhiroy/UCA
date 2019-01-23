/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    private ListNode reverse(ListNode A){
        ListNode prev = null;
        ListNode curr = A;
        ListNode next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        ListNode head = null,curr = null;
        while(A!=null || B!=null || carry == 1){
            int sum = 0;
            if(A!=null && B!=null){
                 sum = A.val + B.val + carry;
                 carry = sum/10;
                if(sum>9){
                    sum = sum%10;
                }
            }else if(A==null && B!=null){
                sum = B.val + carry;
                carry = sum/10;
                if(sum>9){
                    sum = sum%10;
                }
            }else if(A!=null && B==null){
                sum = A.val + carry;
                carry = sum/10;
                if(sum>9){
                    sum = sum%10;
                }
            }else{
                sum = carry;
                carry = 0;
            }
            if(curr==null){
                curr = new ListNode(sum);
                head = curr;
            }else{
                curr.next = new ListNode(sum);
                curr = curr.next;
            }
            if(A!=null)
                A=A.next;
            if(B!=null)
                B=B.next;
        }
        return head;
    }
}
