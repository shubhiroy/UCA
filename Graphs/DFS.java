import java.util.*;
@SuppressWarnings("unchecked")

public class DFS{
	private Graph g;
	DFS(int v){
		g = new Graph(v);
	}
	private class Graph{
		LinkedList<Integer>[] n;
		int v,e;
		boolean[] visited;
		Graph(int v){
			n= new LinkedList[v];
			for(int i=0;i<v;i++){
				n[i]=new LinkedList<Integer>();
			}
			//visited = new boolean[v];
			this.v = v;
			e=0;
		}
	}
	private void edge(Graph g,int a,int b){
		g.n[a].add(b);
		g.n[b].add(a);
		g.e+=2;
	}
	private void dfs(Graph g,int r){
		g.visited[r]=true;
		for(int i=0;i<g.n[r].size();i++){
			if(g.visited[g.n[r].get(i)]==false){
				System.out.print(g.n[r].get(i) + " ");
				dfs(g,g.n[r].get(i));
			}
		}
	}
	
	public void dfs(){
		for(int i=0;i<g.v;i++){
			//if(g.visited[i]==false){
				g.visited = new boolean[g.v];
				System.out.print(i + " => "); 
				dfs(g,i);
				System.out.println();
			//}
		}
	}
	public void edge(int a,int b){
		edge(g,a,b);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//int v = sc.nextInt();
		DFS d = new DFS(5);
		d.edge(1,2);
		d.edge(4,2);
		d.edge(3,4);
		d.edge(1,0);
		d.edge(4,0);
		d.dfs();
	}
}