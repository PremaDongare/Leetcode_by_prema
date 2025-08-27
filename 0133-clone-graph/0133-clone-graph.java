/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public void DFS(Node node, Node cloneNode, Node[] visited){

        visited[node.val] = cloneNode;

        // iterate through all neigh
        for(Node neighbour: node.neighbors){
        // if not visited
        if(visited[neighbour.val] == null){
            // create new
            Node cloneNeighoubr= new Node(neighbour.val);
            cloneNode.neighbors.add(cloneNeighoubr);

            DFS(neighbour, cloneNeighoubr, visited);
        }else{
            // if alredy visited , just connect
            cloneNode.neighbors.add(visited[neighbour.val]);
        }
    }
}
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        // first node
        Node cloneNode = new Node(node.val);
        // put in in visited
         Node[] visited = new Node[101];
        //dfs
        DFS(node,cloneNode,visited);

        return cloneNode;
    }
}