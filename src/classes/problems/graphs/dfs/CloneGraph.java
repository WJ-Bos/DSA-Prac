package classes.problems.graphs.dfs;

import classes.utilities.structures.Node;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node){
        if(node == null) return null;

        Map<Node,Node> map = new HashMap<>();
        return clone(node,map);
    }

    private Node clone(Node node, Map<Node, Node> map) {
        if(map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);
        map.put(node,copy);
        for(Node n : node.neighbors){
            clone(n,map);
        }

        return copy;
    }
}
