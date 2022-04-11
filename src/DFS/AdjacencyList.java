package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 인접리스트로 그래프 구현
 * */
public class AdjacencyList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split(" ");
        int node = Integer.parseInt(n[0]);
        int edge = Integer.parseInt(n[1]);
        List<Integer>[] list = new ArrayList[node + 1];

        // 각 배열의 원소로 ArrayList 가 올수있도록 초기화
        // [1] -> {}
        // [2] -> {}
        for (int i = 1; i <= node; i++) {
            list[i] = new ArrayList<>();
        }

        // 원소 입력
        for (int i = 0; i < edge; i++) {
            String[] nodes = br.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);

            // 무방향 그래프의 경우 양쪽 노드에 간선을 추가 해준다.
            list[u].add(v);
            list[v].add(u);
        }

        /**
         * 결과 출력
         *
         * 1 => 2 5
         * 2 => 1 5
         * 3 => 4
         * 4 => 3 6
         * 5 => 2 1
         * 6 => 4
         * */
        for (int i = 1; i <= node ; i++) {
            System.out.print(i + " => ");
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j) +" ");
            }
            System.out.println();
        }
    }
}
