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
    static int index;
    private static int search(int start,int end,ArrayList<Integer> arr,int val){
        for(int i=start;i<=end;i++){
            if(arr.get(i)==val){
                return i;
            }
        }
        return -1;
    }
    private static TreeNode buildTree(int i,int j,ArrayList<Integer> A, ArrayList<Integer> B){
        if(i>j){
            return null;
        }
        TreeNode node = new TreeNode(B.get(index));
        if(i==j){
            index -- ;
            return node;
        }
        
        int search = search(i,j,A,B.get(index));
        index --;
        node.right = buildTree(search+1,j,A,B);
        node.left = buildTree(i,search-1,A,B);
        return node;
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        index = B.size()-1;
        return buildTree(0,A.size()-1,A,B);
    }
}
