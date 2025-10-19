package classes.problems.graphs.bfs;

import classes.utilities.Vertex;

import javax.swing.*;
import java.util.*;

//Adjacency Matrix Implementation
public class GraphBfs {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        List<Integer> path = walk(graph, 0, 4);
        System.out.println(path);
    }

    public static List<Integer> walk(int[][] graph, int source, int needle){
        if (source == needle) {
            return List.of(source);
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] seen = new boolean[graph.length];
        int[] prev = new int[graph.length];

        Arrays.fill(prev, -1);

        seen[source] = true;
        q.add(source);

        do {
            int curr = q.poll();

            if(curr == needle){
                return reconstructPath(prev, source, needle);
            }

            int[] neighbours = graph[curr];

            for(int i = 0; i < neighbours.length; i++){
                if(neighbours[i] == 0 || seen[i]){
                    continue;
                }

                seen[i] = true;
                prev[i] = curr;
                q.add(i);
            }
        }while (!q.isEmpty());

        return new ArrayList<>();
    }

    public static List<Vertex> walk(Vertex vertex, Vertex target){
        Set<Vertex> seen = new HashSet<>();
        Map<Vertex,Vertex> prev = new HashMap<>();

        Queue<Vertex> q = new LinkedList<>();
        q.add(vertex);
        seen.add(vertex);

        while(!q.isEmpty()){
            Vertex current = q.poll();

            if(current == vertex){
                return reconstructPath(prev, vertex, target);
            }

            List<Vertex> neighbours = current.getNeighbours();

            for(Vertex n : neighbours){
                if(!seen.contains(n)){
                    seen.add(n);
                    prev.put(n, current);
                    q.add(n);
                }
            }
        }
        return new ArrayList<>();
    }

    private static List<Vertex> reconstructPath(Map<Vertex, Vertex> prev, Vertex vertex, Vertex target) {
        List<Vertex> path = new ArrayList<>();

        for(Vertex at = target; at != null; at = prev.get(at)){
            path.add(at);
            if(at == vertex) break;
        }

        Collections.reverse(path);
        return path;
    }

    private static List<Integer> reconstructPath(int[] prev, int source, int needle){
        List<Integer> path = new ArrayList<>();

        for(int at = needle; at != -1; at = prev[at]){
            path.add(at);
        }

        Collections.reverse(path);
        return path;
    }
}

