package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs {
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

        dfs(start, vertex, graph, visited);
    }

    public static void dfs(int start, int vertex, int[][] graph, boolean[] visited) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 0; i <= vertex ; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                dfs(i, vertex, graph, visited);
            }
        }
    }
}
