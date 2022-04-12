package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/7576
 * 토마토
 * */
public class Solution_7576 {
    static int[] dx = {1,-1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static Queue<Point> queue = new LinkedList<>();
    static int N, M, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] boxSize = br.readLine().split(" "); // [가로, 세로]
        M = Integer.parseInt(boxSize[0]);
        N = Integer.parseInt(boxSize[1]);

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" "); // 0 0 0 0 0 0
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(nums[j]);
                arr[i][j] = a;

                if (a == 1) {
                    queue.add(new Point(i, j)); // 초기 익은 토마토 위치
                }
            }
        }
        bfs();
        boolean nonRipe = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    nonRipe = true;
                    break;
                }
            }
        }
        if (nonRipe) {
            System.out.println(-1);
        } else {
            if (max == 0) {
                System.out.println(0);
            } else {
                System.out.println(max-1);

            }
        }
    }
    static void bfs() {
        while (!queue.isEmpty()) {
            Point pair = queue.poll();
            int x = pair.x, y = pair.y;

            for (int i = 0; i < 4; i++) {
                int kx = x + dx[i];
                int ky = y + dy[i];
                if (kx >= 0 && ky >= 0 && kx < N && ky < M) {
                    if (arr[kx][ky] == 0) {
                        queue.offer(new Point(kx, ky));
                        arr[kx][ky] = arr[x][y] + 1;
                        max = Math.max(max, arr[kx][ky]);
                    }
                }
            }
        }
    }
}
