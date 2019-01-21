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
    private static ArrayList<ArrayList<Integer>>res;
    private static void pathSum(TreeNode A, int B, ArrayList<Integer> arr, int sum){
        sum = sum + A.val;
        ArrayList<Integer> arrNew = new ArrayList(arr);
        arrNew.add(A.val);
        if(A.left==null && A.right==null){
            if(sum==B){
                res.add(arrNew);
            }
            return;
        }
       if(A.left==null){
           pathSum(A.right, B, arrNew, sum);
       }else if(A.right==null){
           pathSum(A.left, B, arrNew, sum);
       }else{
           pathSum(A.left, B, arrNew, sum);
           pathSum(A.right, B, arrNew, sum);
       }
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
         res = new ArrayList<ArrayList<Integer>>();
        int sum =0;
        pathSum(A,B,arr,sum);
        return res;
    }
}
