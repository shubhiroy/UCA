public class Solution {
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> persons = new ArrayList<>(A);
        Collections.sort(persons);
        int s = A.size();
        ArrayList<Integer> stand = new ArrayList<>();
        for(int i=0;i<s;i++){
            stand.add(0);
        }
        for(int i=0;i<persons.size();i++){
            int ind = A.indexOf(persons.get(i));
            int pos = B.get(ind);
            int c =0,j=0;
            while(c<pos){
                if(stand.get(j)==0){
                    c++;
                }
                j++;
            }
            while(stand.get(j)!=0){
                j++;
            }
            stand.set(j,persons.get(i));
        }
        return stand;
    }
}
