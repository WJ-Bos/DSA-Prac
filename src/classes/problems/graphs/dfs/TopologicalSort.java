package classes.problems.graphs.dfs;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];

            graph.putIfAbsent(prerequisite, new ArrayList<>());
            graph.get(prerequisite).add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int completed = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            completed++;

            if (graph.containsKey(current)) {
                for (int neighbor : graph.get(current)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        return completed == numCourses;
    }


    public static List<Integer> topologicalOrdering(int numNodes, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numNodes];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);

            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numNodes; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topOrder = new ArrayList<>();

        while (!q.isEmpty()) {
            int current = q.poll();
            topOrder.add(current);

            if (graph.containsKey(current)) {
                for (int neighbor : graph.get(current)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        if (topOrder.size() != numNodes) {
            return new ArrayList<>();
        }

        return topOrder;

    }
}