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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        TreeNode curr = A;
        boolean zig = false;
        st1.push(curr);
        while(st1.size()>0){
            ArrayList<Integer> sArr = new ArrayList<>();
            while(st1.size()>0){
                st2.push(st1.pop());
            }
            while(st2.size()>0){
                curr = st2.pop();
                if(zig){
                    sArr.add(0,curr.val);
                }else{
                    sArr.add(curr.val);
                }
                if(curr.left!=null){
                    st1.push(curr.left);
                }
                if(curr.right!=null){
                    st1.push(curr.right);
                }
            }
            arr.add(sArr);
            zig = !zig;
        }
        return arr;
    }
}
