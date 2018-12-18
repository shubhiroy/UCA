package Graphs;
import java.util.*;

class Test{
	public static void main(String[] args){
		Graph g = new Graph(5);
		g.add(1,2);
		g.add(0,2);
		g.add(4,3);
		System.out.println("Hello");
		g.dfs();
		System.out.println(g.isConnected(1,2));
		System.out.println(g.isConnected(4,2));
		
	}
}