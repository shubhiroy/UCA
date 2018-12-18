package Graphs;
import java.util.*;
//@SuppressWarning("unchecked")

public class Bag<T> implements Iterable<T>{
	private Node first;
	private Node last;
	private class Node{
		T data;
		Node next;
		Node(T data){
			this.data = data;
			this.next = null;
		}
	}
	void add(T data){
		Node temp = new Node(data);
		if(first==null){
			first = temp;;
			last = first;
		}else{
			last.next = temp;
			last = temp;
		}
	}
	int size(){
		int s=0;
		while(new ListIterator().hasNext()){
			s++;
		}
		return s;
	}
	
	//@Override
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<T>{
		private Node current = first;
		//@Override
		public boolean hasNext(){
			return current!=null;
		}
		
		//@Override
		public T next(){
			Node temp = current;
			current = current.next;
			return temp.data;
		}
		/*public Integer next(){
			//T temp = current.data;
			//current = current.next;
			return 0;
		}*/
	
	}
}