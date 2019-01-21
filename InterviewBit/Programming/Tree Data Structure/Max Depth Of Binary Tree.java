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
    private static int maxDepth2(TreeNode A){
        if(A==null){
            return 0;
        }
        int max = java.lang.Math.max(maxDepth2(A.left),maxDepth2(A.right))+1;
        return max;
    }
    public int maxDepth(TreeNode A) {
        return maxDepth2(A);
    }
}
