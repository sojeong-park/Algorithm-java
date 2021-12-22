package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs {
    public static void bfs(int start, int vertex, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertex+1];

        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node +" ");
            for (int i = 1; i <= vertex; i++) {
                if (!visited[i] && graph[node][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * https://www.acmicpc.net/problem/1260
     * 입력 예제
     * 4 5 1    // 정점개수, 간선개수, 탐색 시작 번호
     * 1 2
     * 1 3
     * 1 4
     * 2 4
     * 3 4
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());
        int vertex = Integer.parseInt(tokenizer.nextToken());
        int edge = Integer.parseInt(tokenizer.nextToken());
        int start = Integer.parseInt(tokenizer.nextToken());

        int[][] graph = new int[vertex+1][vertex+1];
        boolean[] visited = new boolean[vertex+1];

        for (int i = 0; i < edge; i++) {
            tokenizer = new StringTokenizer(bf.readLine());
            int edge1 = Integer.parseInt(tokenizer.nextToken());
            int edge2 = Integer.parseInt(tokenizer.nextToken());

            graph[edge1][edge2] = 1;
            graph[edge2][edge1] = 1;
        }

        bfs(start, vertex, graph);
    }
}
