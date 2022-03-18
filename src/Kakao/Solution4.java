package Kakao;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/92334
 * 신고 결과 받기
 * 난이도 1
 *
 * */
public class Solution4 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportMap =  new HashMap<>(); //
        Map<String, Integer> reportCount = new HashMap<>(); // id별로 신고당한 횟수 저장
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
            reportCount.put(id, 0);
        }

        for (String rep : report) {
            String[] users = rep.split(" ");
            if (!reportMap.get(users[0]).contains(users[1])) {
                reportCount.put(users[1], reportCount.get(users[1]) + 1);
            }
            reportMap.get(users[0]).add(users[1]);
        }

        int i = 0;
        for (String id : id_list) {
            for (String reportId : reportMap.get(id)) {
                if (reportCount.get(reportId) >= k) {
                    answer[i] += 1;
                }
            }
            i++;
        }

        for (int j = 0; j < answer.length; j++) {
            System.out.println(answer[j]);
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                 new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2);

//        solution(new String[]{"con", "ryan"},
//                 new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
//                3);
    }
}
