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

        int cnt = 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    ans.add(bfs(cnt, new Pair(i, j), n));
                    cnt++;
                }
            }
        }

        Collections.sort(ans);
        System.out.println(cnt);
        for (int a : ans){
            System.out.println(a);
        }
    }

    static int bfs(int danji, Pair pair, int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);
        int cnt = 0;
        while (!queue.isEmpty()) {
            Pair pair1 = queue.poll();
            int x = pair1.x;
            int y = pair1.y;

            // 4가지 방향 탐색
            for (int i = 0; i < 4; i++) {
                int kx = x + dx[i];
                int ky = y + dy[i];

                if (kx >= 0 && kx < n && ky >= 0 && ky < n) {
                    if (!visited[kx][ky] && arr[kx][ky] == 1) {
                        visited[kx][ky] = true;
                        arr[kx][ky] = danji;
                        queue.offer(new Pair(kx, ky));
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
