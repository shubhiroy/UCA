import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Rank {
    private static Node root;
    
	private class Node {
		
		private final Integer key;
		private Node right;
		private Node left;
		private int N;
		
		public Node(Integer key) {
			this.key = key;
			N = 1;
		}
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return sizeOf(root);
	}
	
	private int sizeOf(Node x) {
		return x == null ? 0 : x.N;
	}

	public Integer get(int key) {
		Node x = get(root, key);
		return x == null ? null : x.key;
	}
	
	private Node get(Node x, Integer key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp < 0) {
			return get(x.left, key);
		}
		return get(x.right, key);
	}

		
	private void updateRank(Node root){
		if(root==null)
			return;
		updateRank(root.left);
		root.N++;
		updateRank(root.right);
	}
	
	public Node insert(Node n,int key) {
		 Node x = new Node(key);
		 if(n==null){
			//n = new Node(key);
			return x;
		 }else if(n.key>key){
			n.left = insert(n.left,key);
			n.N++;
			updateRank(n.right);
		 }else if(n.key<key){
			 //x.N = n.N+1;
			n.right = insert(n.right,key);
			n.right.N = n.N+1;
			//n.N++;
		 }
		 return n;
	}
	  
	public Integer getRank(int key,Node n) {
		Node x = get(n,key);
		if(x==null)
			return -1;
		return x.N-1;
	}

    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Rank bst = new Rank();
        int n = in.nextInt();
        for(int i = 0 ; i < n ; i++){
           root =  bst.insert(root,in.nextInt());
		   //System.out.println("N = " + root.N);
        }
        int m = in.nextInt();
        for(int i = 0 ; i < m ; i++){
			int a =in.nextInt();
            System.out.println(" Rank of " + a + " = " +bst.getRank(a,root));
        }
	  //System.out.println(root.right.key + "  : = : " + root.right.N);	
	  
      //System.out.println(root.right.right.key + "  : = : " + root.right.right.N);
    }
}




