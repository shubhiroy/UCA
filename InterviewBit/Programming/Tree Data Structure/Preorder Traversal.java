/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        TreeNode curr = A;
        st1.push(curr);
        while(st1.size()>0){
            curr = st1.pop();
            arr.add(curr.val);
            if(curr.right!=null){
                st1.push(curr.right);
            }
            if(curr.left!=null){
                st1.push(curr.left);
            }
        }
        return arr;
    }
}
