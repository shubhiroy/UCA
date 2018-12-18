import java.util.*;

public class RunningMed{
	PriorityQueue<Integer> minQ = new PriorityQueue<>();
	PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
	
	public void insert(int n){
		if(maxQ.isEmpty()){
			maxQ.add(n);
		}else if(minQ.size()==maxQ.size()){
			if(maxQ.peek()>n){
				minQ.add(n);
				maxQ.add(minQ.remove());
			}else{
				maxQ.add(n);
			}
		}else if(maxQ.size()>minQ.size()){
			if(maxQ.peek()>n){
				minQ.add(n);
			}else{
				maxQ.add(n);
				minQ.add(maxQ.remove());
			}
		}
	}
	
	public double getMed(){
		if(maxQ.size()>minQ.size()){
			return maxQ.peek();
		}
		return (maxQ.peek()+minQ.peek())/2.0;
	}
	
	public static void main(String[] args){
		RunningMed rm = new RunningMed();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int arr[n];
		for(int i=0;i<n;i++){
			//arr[i] = sc.nextInt();
			rm.insert(sc.nextInt());
			System.out.println(rm.getMed());
		}
		
	}
}