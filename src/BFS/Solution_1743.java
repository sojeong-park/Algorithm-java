package BFS;

import java.io.*;
import java.util.*;


/**
 * https://www.acmicpc.net/problem/1743
 * 음식물 피하기
 * */

public class Solution_1743 {
    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, 1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] datas = br.readLine().split(" ");
        int n = Integer.parseInt(datas[0]);
        int m = Integer.parseInt(datas[1]);
        int k = Integer.parseInt(datas[2]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < k; i++) {
            String[] pairs = br.readLine().split(" ");
            int x = Integer.parseInt(pairs[0]) - 1;
            int y = Integer.parseInt(pairs[1]) - 1;
            arr[x][y] = 1;
        }

        boolean[][] visited = new boolean[n][m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    visited[i][j] = true;
                    max = Math.max(bfs(i, j, arr, visited), max);
                }
            }
        }
        System.out.println(max);
    }

    public static int bfs(int x, int y, int[][] arr, boolean[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        int size = 1;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            for (int i = 0; i < 4; i++) {
                int kx = pair.x + dx[i];
                int ky = pair.y + dy[i];
                if (0 <= kx && 0 <= ky &&  kx < arr.length && ky < arr[kx].length && arr[kx][ky] == 1) {
                    if (!visited[kx][ky]) {
                        visited[kx][ky] = true;
                        size++;
                        q.offer(new Pair(kx, ky));
                    }
                }
            }
        }
        return size;
    }
}
