public class Solution {
    class Graph{
        int v;
        int[][] graph;
        boolean[][] vis;
        int[] union;
        Graph(int v){
            this.v = v;
            graph = new int[v][v];
            vis = new boolean[v][v];
            union = new int[v];
            for(int i=0;i<=v;i++){
                union[i]=i;
            }
        }
        void updateUnion(int a,int b){
            for(int i=0;i<v;i++){
                if(union[i]==b){
                    union[i]=a;
                }
            }
        }
        boolean checkConnect(int a,int b){
            return (union[a]==union[b]);
        }
        void addEdge(int v,int w,int c){
            graph[v][w]=c;
        }
        boolean checkUnion(){
            for(int i=1;i<v;i++){
                if(union[i]!=union[i-1]){
                    return true;
                }
            }
            return false;
        }
        int getMinEdge(){
            int min = Integer.MAX_VALUE;
            int vert1=-1,vert2=-1;
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(graph[i][j]!=0 && graph[i][j]<min && checkConnect(i,j)==false){
                        min = graph[i][j];
                        vert1 = i;
                        vert2 = j;
                    }
                }
            }
            updateUnion(union[vert1],union[vert1]);
            graph[vert1][vert2] = 0;
            return min;
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph g = new Graph(A);
        for(ArrayList<Integer> a : B){
            g.addEdge(a.get(0),a.get(1),a.get(2));
        }
        int sum = 0;
        while(g.checkUnion()){
            sum = sum+g.getMinEdge();
        }
        return sum;
    }
}
