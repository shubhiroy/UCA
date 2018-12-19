public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int sum=A.get(0),maxi=A.get(0);
        for(int i=1;i<A.size();i++){
            sum+=A.get(i);
            if(sum<=A.get(i)){
                sum=A.get(i);
            }
            maxi=java.lang.Math.max(sum,maxi);
        }
        return maxi;
    }
}
