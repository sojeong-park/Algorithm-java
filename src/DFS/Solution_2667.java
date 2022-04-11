package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2667
 * 단지 번호 붙이기
 * 인접행렬 + dfs/bfs 구현
 * */
class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution_2667 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String nums = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = nums.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    bfs(i, j, n);
                    cnt++;
                }
            }
        }

        Collections.sort(ans);
        System.out.println(cnt);
        for (int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }

    static void bfs(int x, int y, int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int nx = pair.x;
            int ny = pair.y;

            // 4가지 방향 탐색
            for (int i = 0; i < 4; i++) {
                int kx = nx + dx[i];
                int ky = ny + dy[i];

                if (kx >= 0 && kx < n && ky >= 0 && ky < n) {
                    if (!visited[kx][ky] && arr[kx][ky] == 1) {
                        visited[kx][ky] = true;
                        queue.offer(new Pair(kx, ky));
                        cnt++;
                    }
                }
            }
        }
        ans.add(cnt);
    }
}
