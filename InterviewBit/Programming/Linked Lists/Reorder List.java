/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    private ListNode getMid(ListNode A){
        ListNode slow = A;
        ListNode fast = A.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
    private int getSize(ListNode A){
        int size = 0;
        ListNode curr = A;
        while(curr!=null){
            curr = curr.next;
            size++;
        }
        return size;
    }
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
    public ListNode reorderList(ListNode A) {
        ListNode head = A;
        int size = getSize(A);
        ListNode mid = getMid(A);
        mid = reverse(mid);
        //System.out.println(size);
        if(size%2==1){
            while(mid!=null){
                ListNode temp = head.next;
                head.next = mid;
                head = mid;
                mid = mid.next;
                head.next = temp;
                head = temp;
            }
            head.next = null;
        }else{
            while(mid!=null){
                ListNode temp = head.next;
                head.next = mid;
                head = mid;
                mid = mid.next;
                head.next = temp;
                head = temp;
            }
        }
        return A;
    }
}
