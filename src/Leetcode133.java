package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode133 {
    public static void main(String[] args) {

    }

    boolean[] visited = new boolean[101];
    Map<Integer, Node> clones = new HashMap<Integer,Node>();

    public Node cloneGraph(Node node) {

        if(node == null)
            return null;

        Node nodeClone = new Node(node.val);

        clones.putIfAbsent(node.val,nodeClone);
        visited[node.val] = true;

        for(Node n:node.neighbors){
            if(!visited[n.val]){
                cloneGraph(n);
            }
            nodeClone.neighbors.add(clones.get(n.val));
        }

        return nodeClone;
    }

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
}
