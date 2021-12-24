package DFS;

public class LeetCode200 {
    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, 1, -1, 0};

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i <grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                visited[i][j] = false;
            }
        }
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int x, int y, char[][] grid, boolean[][] visited) {
        if (visited[x][y]) return;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int kx = x + dx[i];
            int ky = y + dy[i];
            if ((kx >= 0 && kx < grid.length) && (ky >= 0 && ky < grid[x].length) && grid[kx][ky] == '1'){
                dfs(kx, ky, grid, visited);
            }
        }
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid2));
    }
}
