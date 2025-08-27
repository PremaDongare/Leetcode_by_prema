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
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node[] visited = new Node[101];

        //clone start node 
        Node cloneNode = new Node(node.val);
        visited[node.val] = cloneNode;

        //BFS
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        //process nodes
        while(!q.isEmpty()){
            Node current=q.poll();

            // traverse 
            for(Node neighbour: current.neighbors){
                if(visited[neighbour.val] == null){

                    Node cloneNeighbour = new Node(neighbour.val);

                    visited[neighbour.val]=cloneNeighbour;

                    q.add(neighbour);
                }
                //connect the cloned neigh
                visited[current.val].neighbors.add(visited[neighbour.val]);
            }
        }
        return cloneNode;
    }
}