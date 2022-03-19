package Kakao;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42889?language=java
 * 실패율
 * 난이도 leve1
 * 실패율 계산하고 map에 담아 value 내림차순으로 정렬하여 실패율이 높은 순서대로 출력되게 한다.
 * 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하자.
 * */
public class Solution5 {
    public static int[] solution(int N, int[] stages) {
        int[] stageNums = new int[N+1];
        Map<Integer, Double> map = new HashMap<>();

        int total = stages.length;
        for (int stage : stages) {
            if (stage <= N) {
                stageNums[stage] += 1;
                map.put(stage, 0.0);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (stageNums[i] == 0){
                map.put(i, 0.0);
            } else {
                map.put(i, stageNums[i] / (double)total);
            }
            total -= stageNums[i];
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(map.get(o2), map.get(o1));
            }
        });

        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
       // solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        solution(	4, new int[]{1, 2, 1, 2, 1});
    }
}
