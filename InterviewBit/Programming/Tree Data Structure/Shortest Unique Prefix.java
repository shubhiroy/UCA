public class Solution {
    class Trie{
        TrieNode t;
        private class TrieNode{
            Map<Character,TrieNode> children;
            boolean eow;
            TrieNode(){
                children = new HashMap<Character,TrieNode>();
                eow = false;
            }
        }
        Trie(){
            t = new TrieNode();
        }
        private void add(TrieNode t,String s,int i){
            if(i==s.length()){
                t.eow =true;
                return;
            }
            Character ch = s.charAt(i);
            TrieNode node = t.children.get(ch);
            if(node == null){
                node = new TrieNode();
                t.children.put(ch,node);
            }
            add(node,s,i+1);
        }
        
        private String getUni(TrieNode t,String s,int i,int p){
            if(i==s.length() && t.eow == true){

                String res = s.substring(0,p+1);
                return res;
            }
            if(t.children.size()>1){
                p = i;
            }
            Character ch = s.charAt(i);
            TrieNode node = t.children.get(ch);
            return getUni(node,s,i+1,p);
        }
        
        void add(String s){
            add(t,s,0);
        }
        
        String getUni(String s){
            return getUni(t,s,0,s.length()-1);
        }
    }
    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> arr = new ArrayList<>();
        Trie t = new Trie();
        for(String s : A){
            t.add(s);
        }
        for(String s : A){
            arr.add(t.getUni(s));
        }
        return arr;
    }
}
