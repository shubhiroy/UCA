public class Solution {
    public ArrayList<Integer> flip(String A) {
        int size = A.length();
        int l0=-1,r0=-1,l1=-1,r1=-1,max=0,ml=-1,mr=-1,t;
        if(A.charAt(0)=='0'){
            l0=0;
            t=0;
        }else{
            l1=0;
            t=1;
        }
        int diff;
        for(int i=1;i<size;i++){
            if(t!=Character.getNumericValue(A.charAt(i))){
                if(t==0){
                    r0=i;
                    //System.out.println("t=0 i="+i+" l0="+l0+" r0="+r0+" l1="+l1+" r1="+r1);
                    diff=(r0-l0)+(r1-l1);
                    if(diff>max){
                        max=diff;
                        ml=l0+1;
                        mr=r0;
                    }
                    l1=i;
                    t=1;
                }else{
                    r1=i;
                    // System.out.println("t=1 i="+i+" l0="+l0+" r0="+r0+" l1="+l1+" r1="+r1);
                    diff=(r0-l0)+(r1-l1);
                    if(diff>max){
                        max=diff;
                        ml=l0+1;
                        mr=r0;
                    }
                    l0=i;
                    t=0;
                }
                
            }
        }
        if(max==0 && l0==-1){
            return new ArrayList<Integer>(0);
        }else if(max==0 && l0!=-1){
            ArrayList<Integer> a =  new ArrayList<>();
            a.add(1);
            a.add(size);
            return a;
        }else{
            ArrayList<Integer> a =  new ArrayList<>();
            a.add(ml);
            a.add(mr);
            return a;
        }
    }
}

