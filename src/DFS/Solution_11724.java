package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/11724
 * 연결 요소의 개수
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성
 * */
public class Solution_11724 {
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split(" ");
        int node = Integer.parseInt(n[0]);
        int edge = Integer.parseInt(n[1]);


        // 인접행렬 구현
        int[][] a = new int[node+1][node+1];
        /*for (int i = 0; i < edge; i++) {
            String[] nodes = br.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);

            a[u][v] = 1;
            a[v][u] = 1;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }*/


        // 인접리스트 구현
        list = new ArrayList[node+1];
        for (int i = 1; i <= node; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) { // 간선 개수만큼 입력받기
            String[] nodes = br.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);

            // 방향이 없을 경우 양쪽 노드 연결
            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= node ; i++) {
            System.out.print(i + " => ");
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j) +" ");
            }
            System.out.println();
        }

        visited = new boolean[node + 1];
        int cnt = 0;

        // 연결된 그래프가 몇개인지 (덩어리를 count 해보자)
        for (int i = 1; i <= node; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int node) {
        if (visited[node]) return;

        visited[node] = true;
        for (int i = 0; i < list[node].size(); i++) {
            int n = list[node].get(i);
            if (!visited[n]) {
                dfs(n);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int n = queue.poll();
            if (!visited[n]) {
                visited[n] = true;
                for (int i = 0; i < list[n].size(); i++) {
                    queue.add(list[n].get(i));
                }
            }
        }
    }
}
