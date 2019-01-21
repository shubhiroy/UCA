/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Stack<TreeLinkNode> st1 = new Stack<>();
        Stack<TreeLinkNode> st2 = new Stack<>();
        TreeLinkNode curr = root;
        st1.push(curr);
        while(st1.size()>0){
            while(st1.size()>0){
                st2.push(st1.pop());
            }
            while(st2.size()>0){
                curr = st2.pop();
                if(curr.left!=null){
                    st1.push(curr.left);
                }
                if(curr.right!=null){
                    st1.push(curr.right);
                }
                if(st2.size()>0){
                    curr.next = st2.peek();
                }else{
                    curr.next = null;
                }
            }
        }
        
    }
}
