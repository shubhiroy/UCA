public class Solution {
    private static boolean check(TreeNode A, int value){
        if(A==null){
            return false;
        }
        if(A.val==value)
            return true;
        boolean l = check(A.left,value);
        boolean r = check(A.right,value);
        return (l||r);
    }
	
    int find(TreeNode A,int value, ArrayList<Integer> arr){
        if(A==null){
            return -1;
        }
        arr.add(A.val);
        if(A.val == value){
            return value;
        }
        int x=find(A.left,value,arr);
        int y=find(A.right,value,arr);
        if(y!=-1 || x!=-1){
            return A.val;
        }
        arr.remove(arr.size()-1);
        return -1;
    }
    private int lca2(TreeNode A, int B, int C){
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        find(A,B,b);
        find(A,C,c);
        int i;
         for (i = 0; i < b.size() && i < c.size(); i++) {
            if (!b.get(i).equals(c.get(i))) {
                break;
            }
        }
        return b.get(--i);
    }
	
    public int lca(TreeNode A, int B, int C) {
        if(A==null ||check(A,B)==false || check(A,C)==false ){
            return -1;
        }
        return lca2(A,B,C);
    }
}