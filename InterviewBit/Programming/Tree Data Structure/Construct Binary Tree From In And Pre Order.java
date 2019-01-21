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
    static int ind;
    private static int search(int start,int end, ArrayList<Integer> arr, int val){
        for(;start<=end;start++){
            if(arr.get(start)==val){
                return start;
            }
        }
        return -1;
    }
    private static TreeNode buildTree(int i,int j,ArrayList<Integer> A, ArrayList<Integer> B,int index){
        if(i>j){
            return null;
        }
        TreeNode node = new TreeNode(A.get(ind));
        if(i==j){
            ind++;
            return node;
        }
        int search = search(i,j,B,A.get(ind));
        ind++;
        node.left = buildTree(i,search-1,A,B,ind);
        node.right = buildTree(search+1,j,A,B,ind);
        return node;
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        ind = 0;
        return buildTree(0,B.size()-1,A,B,ind);
    }
}
