package classes.problems.graphs.dfs;

import classes.utilities.structures.Vertex;

import java.util.*;

//Adjacency List Impl
public class GraphDfs {
    public static void main(String[] args) {

        List<int[]> edgesNum = Arrays.asList(
                // Component 1: {0, 1, 2}
                new int[]{0, 1},
                new int[]{1, 2},

                // Component 2: {3, 4}
                new int[]{3, 4},

                // Component 3: {5, 6}
                new int[]{5, 6},

                // Component 4: {7, 8}
                new int[]{7, 8},

                // Component 5: {9, 10}
                new int[]{9, 10},

                // Component 6: {11, 12}
                new int[]{11, 12},

                // Component 7: {13, 14}
                new int[]{13, 14},

                new int[]{15, 16},
                new int[]{15, 17},
                new int[]{15, 18},
                new int[]{16, 19}
        );

        Map<Integer, List<Integer>> graph = buildGraphInt(edgesNum);
        System.out.println("Number of Components -> "+ " " + numberOfComponents(graph));
        System.out.println("Largest Component -> "+ " " + biggestComp(graph));

    }

    public static List<Character> walkIter(Map<Character, List<Character>> graph, Character source, List<Character> path) {
        Stack<Character> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            Character curr = stack.pop();
            path.add(curr);

            for (char c : graph.get(curr)) {
                stack.push(c);
            }
        }
        return path;
    }


    public static List<Character> walkRec(Map<Character, List<Character>> graph, Character source, List<Character> path) {
        path.add(source);

        for (char c : graph.get(source)) {
            walkRec(graph, c, path);
        }

        return path;
    }

    public static boolean hasPath(Map<Character, List<Character>> graph, Character source, Character dst, Set<Character> visited) {
        if (visited.contains(source)) return false;
        if (source == dst) return true;

        for (char c : graph.get(source)) {
            if (hasPath(graph, c, dst, visited)) {
                return true;
            }
        }

        return false;
    }

    private static Map<Character, List<Character>> buildGraph(List<Character[]> edges) {
        Map<Character, List<Character>> graph = new HashMap<>();

        for (Character[] edge : edges) {
            Character from = edge[0];
            Character to = edge[1];

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);

            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        return graph;
    }

    private static Map<Integer, List<Integer>> buildGraphInt(List<int[]> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>());
        }

        return graph;
    }

    public static List<Vertex> findDfs(Vertex source, Vertex target, HashSet<Vertex> seen, List<Vertex> path) {
        if (seen.contains(source)) return null;

        seen.add(source);
        path.add(source);

        if (source == target) {
            return path;
        }

        for (Vertex neighbour : source.getNeighbours()) {
            List<Vertex> result = findDfs(neighbour, target, seen, path);

            if (result != null) {
                return result;
            }

        }

        path.removeLast();
        return null;
    }

    public static int numberOfComponents(Map<Integer, List<Integer>> graph) {
        Set<Integer> seen = new HashSet<>();

        int count = 0;

        for(int node : graph.keySet()){
            if(explore(graph,node, seen)){
               count++;
            }
        }

        return count;
    }

    private static boolean explore(Map<Integer, List<Integer>> graph, int current, Set<Integer> seen) {
        if(seen.contains(current)) return false;

        seen.add(current);
        for(int neighbour : graph.get(current)){
            explore(graph,neighbour,seen);
        }

        return true;
    }

    public static int biggestComp(Map<Integer, List<Integer>> graph) {
        Set<Integer> seen = new HashSet<>();

        int largest = 0;

        for(int node : graph.keySet()){
            if(!seen.contains(node)){
                int size = exploreCount(graph,node,seen);
               largest = Math.max(size,largest);
            }
        }

        return largest;
    }

    private static int exploreCount(Map<Integer, List<Integer>> graph, int current, Set<Integer> seen) {
        if(seen.contains(current)) return 0;

        seen.add(current);
        int size = 1;

        for(int neighbour : graph.get(current)){
           size +=  exploreCount(graph,neighbour,seen);
        }

        return size;
    }

}


