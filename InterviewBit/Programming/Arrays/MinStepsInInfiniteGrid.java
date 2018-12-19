public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int steps=0;
        for(int i=1;i<A.size();i++){
            int a=java.lang.Math.abs(A.get(i)-A.get(i-1));
            int b=java.lang.Math.abs(B.get(i)-B.get(i-1));
            steps+=java.lang.Math.max(a,b);
        }
       return steps; 
    }
}
