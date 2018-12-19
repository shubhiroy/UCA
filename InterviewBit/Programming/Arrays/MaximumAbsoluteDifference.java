public class Solution {
    public int maxArr(ArrayList<Integer> A) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            a.add(A.get(i)+i);
            b.add(A.get(i)-i);
        }
        int ax = Collections.max(a);
        int an = Collections.min(a);
        int bx = Collections.max(b);
        int bn = Collections.min(b);
        
        return java.lang.Math.max((ax-an),(bx-bn));
    }
}
