package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/2606
 * 바이러스
 * */
public class Solution_2606 {
    static boolean[] visited;
    static List<Integer>[] list;
    static int dfsCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            String[] nodes = br.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);

            list[u].add(v);
            list[v].add(u);
        }
        // 시작점은 1번 노드
        //System.out.println(bfs());
        dfs(1);
        System.out.println(dfsCnt);
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < list[node].size(); i++) {
                int linkedNode = list[node].get(i);
                if (!visited[linkedNode]) {
                    visited[linkedNode] = true;
                    queue.offer(linkedNode);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs (int node) {
        visited[node] = true;

        for (int i = 0; i < list[node].size(); i++) {
            int n = list[node].get(i);
            if (!visited[n]) {
                visited[n] = true;
                dfs (n);
                dfsCnt++;
            }
        }
    }
}
