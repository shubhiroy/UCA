public class Solution {
    int possible;
    boolean[] vis ;
    boolean[] st ;
    LinkedList<Integer>[] l ;
    private void course(int node){
        vis[node]=true;
        st[node]=true;
        for(int i=0;i<l[node].size();i++){
            if(vis[l[node].get(i)]==true && st[l[node].get(i)]==true){
                possible = 0;
                return;
            }
            course(l[node].get(i));
        }
        st[node]=false;
    }
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        possible = 1;
        vis = new boolean[A];
        st = new boolean[A];
        l = new LinkedList[A];
        for(int i=0;i<A;i++){
            l[i] = new LinkedList<Integer>();
        }
        for(int i=0;i<B.size();i++){
            l[B.get(i)-1].add(C.get(i)-1);
        }
        for(int i=0;i<A;i++){
            if(vis[i]==false){
                course(i);
            }
        }
        return possible;
    }
}
