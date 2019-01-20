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
    private static void inorder(TreeNode A, ArrayList<Integer> arr){
        if(A==null){
            return;
        }
        inorder(A.left,arr);
        arr.add(A.val);
        inorder(A.right,arr);
    }
    public int kthsmallest(TreeNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(A,arr);
        return arr.get(B-1);
    }
}
