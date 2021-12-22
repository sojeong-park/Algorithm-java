package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode200 {
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

    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, 1, -1, 0};

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                visited[i][j] = false;
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    bfs(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int kx = pair.x + dx[i];
                int ky = pair.y + dy[i];

                if ((kx >= 0 && kx < grid.length) && (ky >= 0 && ky < grid[pair.x].length) && grid[kx][ky] == '1'){
                    if (!visited[kx][ky]) {
                        visited[kx][ky] = true;
                        queue.offer(new Pair(kx, ky));
                    }
                }
            }
        }
    }
}
