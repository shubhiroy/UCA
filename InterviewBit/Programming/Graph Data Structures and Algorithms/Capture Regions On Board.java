public class Solution {
    private static void set(ArrayList<ArrayList<Character>> A , int i, int j){
        A.get(i).set(j,'B');
        if(i-1 >= 0 && A.get(i-1).get(j)=='O'){
            set(A,i-1,j);
        }
        if(j-1 >= 0 && A.get(i).get(j-1)=='O'){
            set(A,i,j-1);
        }
        if(i+1 < A.size() && A.get(i+1).get(j)=='O'){
            set(A,i+1,j);
        }
        if(j+1 < A.get(i).size() && A.get(i).get(j+1)=='O'){
            set(A,i,j+1);
        }
    }
    
    public static void dfs(ArrayList<ArrayList<Character>> A){
       for(int i=0;i<A.size();i++){
           if(i==0 || i==A.size()-1){
               for(int j=0;j<A.get(i).size();j++){
                   if(A.get(i).get(j)=='O'){
                       set(A,i,j);
                   }
               }
           }else{

               if(A.get(i).get(0)=='O'){
                    set(A,i,0);
               }
               if( A.get(i).get(A.get(i).size()-1)=='O'){
                   set(A,i,A.get(i).size()-1);
               }
           }
       }
    }
    public void solve(ArrayList<ArrayList<Character>> a) {
        dfs(a);
      for(int i=0;i<a.size();i++){
          for(int j=0;j<a.get(i).size();j++){
              if(a.get(i).get(j)=='B'){
                  a.get(i).set(j,'O');
              }else if(a.get(i).get(j)=='O'){
                  a.get(i).set(j,'X');
              }
          }
      }
    }
}
