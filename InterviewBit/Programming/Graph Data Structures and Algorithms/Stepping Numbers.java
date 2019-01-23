public class Solution {
    private void graph(LinkedList<Integer>[] l){
        for(int i=0;i<10;i++){
            if(i<9)
                l[i+1].add(i);
            l[i].add(i+1);
        }
    }
    
    private boolean check(int rem, int rem2,LinkedList<Integer>[] l){
        if(l[rem].contains(rem2)){
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Integer> stepnum(int A, int B) {
        LinkedList<Integer>[] l = new LinkedList[10];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<10;i++){
            l[i] = new LinkedList<Integer>();
        }
        graph(l);
        for(int i=A;i<=B;i++){
            boolean isStepping = true;
            int num = i;
            int rem = num % 10;
            num = num / 10;
            while(num>0){
                int rem2 = num%10;
                num = num / 10;
                isStepping = check(rem,rem2,l);
                if(isStepping==false){
                    break;
                }
                rem = rem2;
            }
            if(isStepping){
                arr.add(i);
            }
        }
        return arr;
    }
}
