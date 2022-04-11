package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 인접 행렬로 그래프 구현
 * */
public class AdjacencyMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split(" ");
        int node = Integer.parseInt(n[0]);
        int edge = Integer.parseInt(n[1]);

        int[][] arr = new int[node + 1][node + 1];

        for (int i = 0; i < edge; i++) {
            String[] nodes = br.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);

            // 무방향 그래프 양쪽 노드 연결
            arr[u][v] = arr[v][u] = 1;
        }

        /**
         * 결과 출력
         *
         * 0010010
         * 0100010
         * 0000100
         * 0001001
         * 0110000
         * 0000100
         * */
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
