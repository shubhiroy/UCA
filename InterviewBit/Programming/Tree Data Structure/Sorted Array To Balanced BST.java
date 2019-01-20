/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private static TreeNode buildTree(int i,int j,List<Integer> a){
        if(i>j){
            return null;
        }
        int mid = (i+j)/2;
        TreeNode node = new TreeNode(a.get(mid));
        if(i==j){
            return node;
        }
        node.left = buildTree(i,mid-1,a);
        node.right = buildTree(mid+1,j,a);
        return node;
    }
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return buildTree(0,a.size()-1,a);
    }
}
