public class Solution {
    public static void dfs(int i, int j,ArrayList<String> A, boolean[][] vis){
        vis[i][j]=true;
        if(i>0 && A.get(i-1).charAt(j)=='X' && vis[i-1][j]==false){
            dfs(i-1, j, A, vis);
        }
        if(j>0 && A.get(i).charAt(j-1)=='X' && vis[i][j-1]==false){
            dfs(i, j-1, A, vis);
        }
        if(i<A.size()-1 && A.get(i+1).charAt(j)=='X' && vis[i+1][j]==false){
            dfs(i+1, j, A, vis);
        }
         if(j<A.get(i).length()-1 && A.get(i).charAt(j+1)=='X' && vis[i][j+1]==false){
            dfs(i, j+1, A, vis);
        }
    }
    public int black(ArrayList<String> A) {
        int c=0;
        boolean[][] vis = new boolean[A.size()][A.get(0).length()];
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(i).length();j++){
                if(A.get(i).charAt(j)=='X' && vis[i][j]==false){
                     c++;
                    dfs(i,j,A,vis);
                }
            }
        }
        return c;
    }
}
