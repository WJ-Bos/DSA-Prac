package classes.utilities.structures;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }


}
