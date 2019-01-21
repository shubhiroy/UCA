    private static int V;
    private static int minKey(int[] key, boolean[] mst){
        int min_key = Integer.MAX_VALUE,minInd = -1;
        for(int v=0;v<key.length;v++){
            if(mst[v]==false && key[v]<min_key){
                min_key = key[v];
                minInd = v;
            }
        }
        return minInd;
    }
    private static int cost(int[] parent, ArrayList<ArrayList<Integer>> graph){
        int sum = 0;
        for(int v=1;v<V;v++){
            sum = sum + (int)graph.get(v).get(parent[v]);
        }
        return sum;
    }
    private static int primMST(ArrayList<ArrayList<Integer>> graph){
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mst = new boolean[V];
        for(int v=0;v<V;v++){
            key[v]=Integer.MAX_VALUE;
            mst[v] = false;
        }
        key[0]=0;
        parent[0]=-1;
        for(int count=0;count<V-1;count++){
            int u = minKey(key,mst);
            mst[u]=true;
            for(int v=0;v<V-1;v++){
                if(graph.get(u).get(v)!=0 && mst[v]==false && graph.get(u).get(v)<key[v]){
                    parent[v]=u;
                    key[v]=graph.get(u).get(v);
                }
            }
        }
        int cost = cost(parent,graph);
        return cost;
    }