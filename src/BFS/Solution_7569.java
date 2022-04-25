package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/7569
 * 토마토
 * */
public class Solution_7569 {
    // 상하좌우
    static int[] dx = {1,-1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    //위, 아래
    static int[] kd = {1, -1};

    static Queue<Pairs> queue = new LinkedList<>();
    static int[][][] arrs;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" "); // 가로, 세로, 높이(면)
        int depth = Integer.parseInt(in[2]), width = Integer.parseInt(in[0]), height = Integer.parseInt(in[1]);

        //3차원 배열을 이용한다.new int[면][행][열]
        arrs = new int[depth][width][height];

        boolean ripe = false;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < height; j++) {
                String[] nums = br.readLine().split(" ");
                for (int k = 0; k < width; k++) {
                    int num = Integer.parseInt(nums[k]);
                    if (num == 1) {
                        queue.offer(new Pairs(i,k,j));
                    }
                    if (num == 0) {
                        ripe = true;
                    }
                    arrs[i][k][j] = Integer.parseInt(nums[k]);
                }
            }
        }

        // 모두 익은 상태인지 체크
        if (!ripe) {
            System.out.println(0);
            return;
        }

        // 토마토가 모두 익는데 걸리는시간 구하기
        bfs(depth, width, height);

        // 토마토가 익지 않은 부분 체크
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    if (arrs[i][k][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(max - 1);
    }

    public static void bfs(int depth, int width, int height) {
        while (!queue.isEmpty()) {
            Pairs pairs = queue.poll();
            // 총 6개의 방향에 대해서 확인한다. 위,아래 / 상하좌우
            for (int i = 0; i < 2; i++) { // 위 아래
                int d = pairs.h + kd[i];
                if (d >= 0 && d < depth && arrs[d][pairs.x][pairs.y] == 0) {
                    arrs[d][pairs.x][pairs.y] = arrs[pairs.h][pairs.x][pairs.y] + 1;
                    max = Math.max(max, arrs[d][pairs.x][pairs.y]);
                    queue.add(new Pairs(d, pairs.x, pairs.y));
                }
            }

            for (int i = 0; i < 4; i++) { // 상하좌우
                int x = pairs.x + dx[i];
                int y = pairs.y + dy[i];
                if (x >= 0 && x < width && y >= 0 && y < height && arrs[pairs.h][x][y] == 0) {
                    arrs[pairs.h][x][y] = arrs[pairs.h][pairs.x][pairs.y] + 1;
                    max = Math.max(max, arrs[pairs.h][x][y]);
                    queue.add(new Pairs(pairs.h,  x, y));
                }
            }
        }
    }
}

class Pairs {
    int h;
    int x;
    int y;

    public Pairs(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}
