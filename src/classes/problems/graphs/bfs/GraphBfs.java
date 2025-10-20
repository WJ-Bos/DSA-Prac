package classes.problems.graphs.bfs;

import classes.utilities.structures.Vertex;

import java.util.*;
import java.util.List;

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

    public Map<Integer, List<Integer>> buildGraphInt(List<int[]> edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            graph.computeIfAbsent(from, k-> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>());
        }

        return graph;
    }

    public Map<Character, List<Character>> buildGraphChar(List<char[]> edges){
        Map<Character, List<Character>> graph = new HashMap<>();

        for(char[] edge : edges){
            char from = edge[0];
            char to = edge[1];

            graph.computeIfAbsent(from, k-> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>());
        }

        return graph;
    }

    public static int shortestPath(Map<Character,List<Character>> graph, char source, char target){
        Queue<Character> q = new LinkedList<>();
        Map<Character, Integer> distances = new HashMap<>();
        Set<Character> seen = new HashSet<>();

        seen.add(source);
        distances.put(source,0);
        q.add(source);

        while(!q.isEmpty()){
            Character current = q.poll();
            int distance = distances.get(current);

            if(current == target) return distance;

            for(Character neighbour : graph.get(current)){
                if(!seen.contains(neighbour)){
                    seen.add(neighbour);
                    distances.put(neighbour,distance++);
                    q.add(neighbour);
                }
            }
        }
        return -1;
    }
}

