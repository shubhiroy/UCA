public class Solution {
    static int[] parent;
    private int find(int a){
        while(parent[a]!=a){
            a=parent[a];
        }
        return a;
    }
    private void union(int a,int b){
        int par2 = find(b);
        while(find(a)!=par2){
            int oldParent = parent[a];
            parent[a] = par2;
            a=oldParent;
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        parent = new int[A+1];
        for(int i=0;i<A+1;i++){
            parent[i]=i;
        }
        PriorityQueue<ArrayList<Integer>> q = new PriorityQueue<>(new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
                return Integer.compare(a.get(a.size()-1),b.get(b.size()-1));
            }
        });
        for(ArrayList<Integer> arr : B){
            q.add(arr);
        }
        int sum =0;
        while(q.size()>0){
            ArrayList<Integer> curr = q.poll();
            if(find(curr.get(0))!=find(curr.get(1))){
                sum = sum + curr.get(2);
                union(curr.get(0),curr.get(1));
            }
        }
        return sum;
    }
}
