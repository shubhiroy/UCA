// /**
//  * Definition for undirected graph.
//  * class UndirectedGraphNode {
//  *     int label;
//  *     List<UndirectedGraphNode> neighbors;
//  *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
//  * };
//  */
public class Solution {
    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> map){
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        for(UndirectedGraphNode each : node.neighbors){
            newNode.neighbors.add(clone(each, map));
        }
        return newNode;
    }
    
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
         HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
         return clone(node,map);
    }
}
