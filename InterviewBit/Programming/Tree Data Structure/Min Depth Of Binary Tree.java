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
    private static int minDepth2(TreeNode A){
        if(A.left==null && A.right==null){
            return 1;
        }
        int l = -1;
        int r = -1;
        if(A.left!=null){
            l = minDepth2(A.left);
        }
        if(A.right!=null){
            r = minDepth2(A.right);
        }
        if(l==-1){
            return r+1;
        }else if(r==-1){
            return l+1;
        }else{
            int min = java.lang.Math.min(l,r)+1;
            return min;
        }
    }
    public int minDepth(TreeNode A) {
        return minDepth2(A);
    }
}
