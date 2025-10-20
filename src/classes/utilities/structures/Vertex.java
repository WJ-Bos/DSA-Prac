package classes.utilities.structures;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int val;
    private int weight;
    private List<Vertex> neighbours;

    public Vertex(int val, int weight){
        this.val = val;
        this.weight = weight;
        this.neighbours = new ArrayList<>();
    }

    public Vertex(int val){
        this.val = val;
        this.weight = 0;
        this.neighbours = new ArrayList<>();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }
}
