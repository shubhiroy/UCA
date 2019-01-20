public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        TreeNode curr = a;
        while(curr!=null || st.size()>0){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            arr.add(curr.val);
            curr = curr.right;
        }
        return arr;
    }
}