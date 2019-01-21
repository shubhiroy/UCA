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
    private static TreeNode invert(TreeNode A){
        if(A==null){
            return null;
        }
        A.left = invert(A.left);
        A.right = invert(A.right);
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
        return A;
        
    }
    public TreeNode invertTree(TreeNode A) {
        return invert(A);
    }
}
