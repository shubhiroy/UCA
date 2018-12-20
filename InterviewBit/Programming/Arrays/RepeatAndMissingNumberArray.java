public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
       int size = A.size();
       long reqSum = sumOfNos(size);
       long reqSq = sumOfSquares(size);
       long actSum = sumOfArray(A);
       long actSq = sumOfArraySquares(A);
       
       long diff = reqSum-actSum;
       long x = reqSq-actSq;
       long sum = x/diff;
       
       int num1 = (int)(sum-diff)/2;
       int num2 = (int)(num1+diff);
       
        ArrayList<Integer> a = new ArrayList<>();
        a.add(num1);
        a.add(num2);
        return a;
    }
    
    long sumOfNos(int n){
        return (long)(n*(n+1))/2 ;
    }
    long sumOfSquares(int n){
        return (long)(n*(n+1)*(2*n+1))/6;
    }
    long diff(long a,long b){
        return (long)(a-b) ;
    }
    long sumOfArray(List<Integer> A){
        long sum=0;
        for(Integer i:A){
            long j = (long) i;
            sum+=j;
        }
        return sum;
    }
    long sumOfArraySquares(List<Integer> A){
        long sum=0;
        for(Integer i:A){
            long j = (long) i;
            sum+=(j*j);
        }
        return sum;
    }
}
