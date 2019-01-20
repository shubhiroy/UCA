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
    public int t2Sum(TreeNode A, int B) {
         ArrayList<Integer> arr = new ArrayList<>();
        inorder(A,arr);
        //int res = 0;
        int val;
        for(int i=0;i<arr.size();i++){
            val = B-arr.get(i);
            for(int j=i+1;j<arr.size();j++){
                if(arr.get(j)==val){
                    return 1;
                    
                }
            }
        }
        return 0;
    }
}
