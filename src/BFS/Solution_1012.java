package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1012
 * 유기농 배추
 * */
public class Solution_1012 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,-1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // test case 개수

        for (int i = 0; i < t; i++) {
            String[] datas = br.readLine().split(" ");
            M = Integer.parseInt(datas[0]); // 가로길이
            N = Integer.parseInt(datas[1]); // 세로길이
            int k = Integer.parseInt(datas[2]); // 배추가 심어져 있는 위치의 개수

            arr = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < k; j++) { // 그래프 만들기
                String[] points = br.readLine().split(" ");
                int x = Integer.parseInt(points[0]);
                int y = Integer.parseInt(points[1]);
                arr[x][y] = 1;
            }

            int cnt = 0;
            for (int j = 0; j < M; j++) {
                for (int l = 0; l < N; l++) {
                    if (!visited[j][l] && arr[j][l] == 1) {
                        bfs(j, l);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int m, int n) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(m, n));
        visited[m][n] = true;

        while (!queue.isEmpty()) {
            Point pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int kx = x + dx[i];
                int ky = y + dy[i];
                if (kx >=0 && ky >= 0 && kx < M && ky < N) {
                    if (!visited[kx][ky] && arr[kx][ky] == 1) {
                        visited[kx][ky] = true;
                        queue.add(new Point(kx, ky));
                    }
                }
            }
        }
    }
}
