import java.util.*;

class TrieTree{
	private TrieNode root;
	private class TrieNode{
		Map<Character,TrieNode> children;
		boolean eow;
		TrieNode(){
			children = new HashMap<Character,TrieNode>();
			eow = false;
		}
	}
	TrieTree(){
		root = new TrieNode();
	}
	private void insert(TrieNode root, String s,int index){
		if(index==s.length()){
			root.eow = true;
			return;
		}
		Character ch = s.charAt(index);
		TrieNode node = root.children.get(ch);
		if(node==null){
			node = new TrieNode();
			root.children.put(ch,node);
		}
		insert(node,s,index+1);
	}
	private boolean search(TrieNode root, String s,int index){
		if(index == s.length()){
			return root.eow;
		}
		Character ch = s.charAt(index);
		TrieNode node = root.children.get(ch);
		if(node == null){
			return false;
		}
		return search(node,s,index+1);
	}
	boolean del = false;
	private void delete(TrieNode root,String s,int index){
		if(index==s.length()){
			root.eow = false;
			if(root.children.size()==0){
				del = true;
			}
			return;
		}
		Character ch = s.charAt(index);
		TrieNode node = root.children.get(ch);
		insert(node,s,index+1);
		if(del){
			root.children.remove(ch);
			if(root.children.size()!=0){
				del = false;
			}
		}
	}
	
	
	public void insert(String s){
		insert(root,s,0);
	}
	public boolean search(String s){
		return search(root,s,0);
	}
	public void delete(String s){
		delete(root,s,0);
	}
}

public class Trie{
	public static void main(String[] args){
		TrieTree tt = new TrieTree();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s;
		for(int i=0;i<n;i++){
			s = sc.nextLine();
			tt.insert(s);
		}
		s = sc.nextLine();
		if(tt.search(s)){
			System.out.println("String found");
		}else{
			System.out.println("String not found");
		}
	}
}