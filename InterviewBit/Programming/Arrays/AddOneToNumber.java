public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int c=0;
        for(int i=A.size()-1;i>=0;i--){
             int a = A.get(i)+c;
             if(i==A.size()-1){
                 a+=1;
             }
             if(a>9){
                 A.set(i,0);
                 c=1;
             }else{
                 A.set(i,a);
                 c=0;
             }
        }
       if(c!=0){
           A.add(0,c);
       }
       int i=0;
       while(A.get(i)==0){
           i++;
       }
       ArrayList<Integer> res = new ArrayList<>();
       for(;i<A.size();i++){
           res.add(A.get(i));
       }
        return res;
    }
}
