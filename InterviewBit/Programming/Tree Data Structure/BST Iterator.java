/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

    static int count = 0;
    static ArrayList<Integer> in = new ArrayList<>();
    private static void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        in.add(node.val);
        inorder(node.right);
    }
    public Solution(TreeNode root) {
        inorder(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (in.size()>count);
    }

    /** @return the next smallest number */
    public int next() {
        int res = in.get(count);
        count ++;
        return res;
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
