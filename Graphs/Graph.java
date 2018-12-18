package Graphs;
import java.util.*;
@SuppressWarnings("unchecked")

public class Graph<T>{
	Bag<Integer>[] b;
	private int v;
	private int e;
	private boolean[] visited;
	private int[] isConnected;
	private int count;
	Graph(int v){
		this.v = v;
		b= new Bag[v];
		e=0;
		visited = new boolean[v];
		isConnected = new int[v];
		count=0;
		for(int i=0;i<v;i++){
			b[i]=new Bag<Integer>();
		}
	}
	void add(Integer v,Integer w){
		if(v!=w){
			b[v].add(w);
			b[w].add(v);
			e++;
		}
	}
	public Iterable<Integer> adj(int v){
		return b[v];
	}
	private void dfs(Integer root){
		visited[root]=true;
		isConnected[root]=count;
		System.out.print(" "+root+" ");
		for(int w : adj(root)){
			if(!visited[w]){
				dfs(w);
			}
		}
	}
	void dfs(){
		System.out.println("DFS");
		//visited=new boolean[v];
		for(int i=0;i<v;i++){
			if(!visited[i]){
				isConnected[i]=count;
				dfs(i);
				count++;
				System.out.println();
			}
		}
	}
	boolean isConnected(int v,int w){
		return isConnected[v]==isConnected[w];
	}
}
