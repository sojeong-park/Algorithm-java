package BFS;

import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class LeetCode286 {
    /**
     * BFS 활용 : 각 좌표의 최단거리 동시에 구함
     * 시작점: gate가 있는 좌표를 큐에넣고 순차적으로 탐색한다.
     * 주어지는 2차원 배열의 x축과 y축이 동일하지 않으므로 y축의 최대 길이는 배열[x].length로 탐색한다.
     * 현재 좌표에서 상,하,좌,우 탐색, 좌표값이 배열의 범위를 넘지 않도록 한다.
     * 현재 좌표에는 이전좌표의 value+1을 하여 거리값을 나타낸다.
     * */
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int INF = 2147483647;

    public static void main(String[] args) {
        int[][] rooms = {
                {INF,-1,0,INF}
                , {INF,INF,INF,-1}
                , {INF,-1,INF,-1}
                , {0,-1,INF,INF}
        };
        int[][] rooms2 = {{INF, 0, INF, INF, 0, INF, -1, INF}};
        wallsAndGates(rooms2);

        for (int i = 0; i < rooms2.length; i++) {
            for (int j = 0; j < rooms2[i].length; j++) {
                System.out.print(rooms2[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void wallsAndGates(int[][] rooms) {
        Queue<Pair> queue = new LinkedList<>();

        // gate가 있는 좌표부터 탐색 시작
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0)
                    queue.offer(new Pair(i, j));
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
               int x = pair.x + dx[i];
               int y = pair.y + dy[i];
               if ((x >= 0 && x < rooms.length) && (y >= 0 && y < rooms[pair.x].length) && rooms[x][y] == INF) {
                   queue.offer(new Pair(x, y));
                   rooms[x][y] = rooms[pair.x][pair.y] + 1;
               }
            }
        }
    }
}
