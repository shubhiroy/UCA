public class Solution {
    public int solve(ArrayList<Integer> A) {
        int size = A.size();
        Collections.sort(A);
        for(int i=0;i<size;i++){
            int s = size - i - 1;
            if(s==A.get(i)){
                if(i!=size-1 && A.get(i)!=A.get(i+1)){
                    return 1;
                }else if(i==size-1){
                    return 1;
                }
            }
        }
        return -1;
    }
}
