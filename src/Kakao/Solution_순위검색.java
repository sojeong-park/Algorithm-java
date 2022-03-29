package Kakao;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/72412
 * 순위검색
 * 난이도: Level2
 * */
public class Solution_순위검색 {
    /**
     * 1. brute-force
     * - 시간복잡도: O(N^2)
     * - 정확성 테스트는 통과하지만 효율성 테스트는 통과하지 못한다.
     * */
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].split(" and ");
            int cnt = 0;
            for (int k = 0; k < info.length; k++) {
                String[] infoArr = info[k].split(" ");
                if (q[0].equals(infoArr[0]) || q[0].equals("-")) {
                    if (q[1].equals(infoArr[1]) || q[1].equals("-")) {
                        if (q[2].equals(infoArr[2]) || q[2].equals("-")) {
                            String food = q[3].substring(0, q[3].indexOf(" "));
                            String score = q[3].substring(q[3].indexOf(" ")+1);
                            if (food.equals(infoArr[3]) || food.equals("-")) {
                                if (Integer.parseInt(score) <= Integer.parseInt(infoArr[4])) {
                                    cnt++;
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    /**
     * 2. 조합 + binary search
     *
     * 1) 지원자들을 그룹별로 적절하게 미리 분류해두면 매 문의 조건마다 지원자들을 INFO 배열에서 찾지 않도록 구현
     *  -> 조합 + hashmap {"조합":점수}
     * 2) 만든 그룹을 점수 오름차순으로 정렬
     * 3) binary search 활용해 검색
     * */
    private static Map<String, List<Integer>> map = new HashMap<>();
    private static boolean[] visited = new boolean[5];
    public static int [] solution2(String[] info, String[] query) {
        //1) 조합으로 그룹 생성하기
        for (String in : info) {
            String[] infos = in.split(" ");
            int score = Integer.parseInt(infos[4]);
            infos[4] = "-";
            dfs(infos, "", 0,  score);
        }

        // 2) map value(점수) 오름차순으로 정렬하기
        // 정렬전 : {--juniorchicken=[80], pythonfrontend--=[210, 150], -backendjuniorchicken=[80], -backendjunior-=[150, 80],...
        // 정렬후 : {--juniorchicken=[80], pythonfrontend--=[150, 210], -backendjuniorchicken=[80], -backendjunior-=[80, 150], ...
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        int[] ans = new int[query.length];

        //3) binary search
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            int score = Integer.parseInt(q[1]);
            ans[i] = search(q[0], score);
        }
        return ans;
    }

    public static int search(String query, int score) {
        if (!map.containsKey(query)) return 0;
        List<Integer> list = map.get(query);
        int start = 0, mid = 0, end = list.size()-1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (list.get(mid) >= score) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return list.size() - start;
    }


    public static void dfs(String[] info, String path, int depth, int score) {
        if (depth == 4) {
            if (!map.containsKey(path)) {
                List<Integer> scoreList = new ArrayList<>();
                scoreList.add(score);
                map.put(path, scoreList);
            } else {
                map.get(path).add(score);
            }
            return;
        }
        dfs(info, path + "-", depth + 1, score);
        dfs(info, path + info[depth], depth + 1, score);
    }

    public static void main(String[] args) {
        solution2(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
    }
}
