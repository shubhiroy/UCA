/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    private ListNode delNode(ListNode a){
        ListNode temp = a.next;
        a.next = null;
        a = null;
        return temp;
    }
    public ListNode partition(ListNode A, int B) {
        ListNode s = null;
        ListNode bH = null;
        ListNode b = null;
        ListNode curr = A;
        int flag = 0;
        if(curr.val<B){
            flag = 1;
            A = curr;
            s = curr;
        }else{
            bH = curr;
            b=curr;
        }
        curr = curr.next;
        while(curr!=null){
            if(curr.val < B){
                flag=1;
                if(s==null){
                    A = curr;
                    s = curr;
                }else{
                    s.next = curr;
                    s = s.next;
                }
            }else{
                if(b==null){
                    bH = curr;
                    b = curr;
                }else{
                    b.next = curr;
                    b = b.next;
                }
            }
            curr = curr.next;
        }
        if(flag==1){
            s.next = bH;
            if(b!=null)
                b.next = null;
        }
        return A;
    }
}
