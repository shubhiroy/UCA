public class Solution {
    static String multi = "1";
    private static void faster(long A, String mult){
        //System.out.println(mult); 
        Stack<String> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        st1.push(mult);
        String curr = mult;
        while(st1.size()>0){
            while(st1.size()>0){
                st2.push(st1.pop());
            }
            while(st2.size()>0){
                curr = st2.pop();
                long m = Integer.parseInt(curr);
                if(m%A==0){
                    multi = curr;
                    return;
                }
                if(!st1.contains(curr+"0")){
                    st1.push(curr+"0");
                }
                if(!st1.contains(curr+"1")){
                    st1.push(curr+"1");
                }        
            }
        }
       
        faster(A,mult+"0");
        faster(A,mult+"1");
        
    }
    public String multiple(int A) {
        String mult = "1";
        faster(A,mult);
        return multi;
    }
}
