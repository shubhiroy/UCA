public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> arr = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        if(!q.contains(A)){
                q.add(A);    
            }
            if(!q.contains(B)){
                q.add(B);    
            }
            if(!q.contains(C)){
                q.add(C);    
            }
        while(D>0){
            Integer curr = q.poll();
            arr.add(curr);
            if(!q.contains(curr*A)){
                q.add(curr*A);    
            }
            if(!q.contains(curr*B)){
                q.add(curr*B);    
            }
            if(!q.contains(curr*C)){
                q.add(curr*C);    
            }
            D--;
        }
        return arr;
    }
}
