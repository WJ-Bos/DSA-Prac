package classes.problems.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {

    public static void main(String[] args) {

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(0, graph, path, result);

        return result;
    }

    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> result) {
      if(node == graph.length -1){
          result.add(new ArrayList<>(path));
          return;
      }

      for(int neigh : graph[node]){
          path.add(neigh);
          dfs(neigh,graph,path,result);
          path.removeLast();
      }
    }
}
