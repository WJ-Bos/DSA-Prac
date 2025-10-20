package classes.problems.graphs.dfs;

public class NumberOfIslands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int numIslands = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){

                if(!seen[row][col] && grid[row][col] != '0'){
                    explore(row,col,seen,grid);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }


    private static void explore(int row, int col, boolean[][] seen, char[][] grid) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if(seen[row][col]) {
            return;
        }

        if(grid[row][col] == '0') {
            return;
        }

        seen[row][col] = true;

        explore(row + 1, col, seen, grid);
        explore(row - 1, col, seen, grid);
        explore(row, col + 1, seen, grid);
        explore(row, col - 1, seen, grid);
    }
}
