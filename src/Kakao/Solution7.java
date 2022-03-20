package Kakao;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 * 메뉴 리뉴얼
 * 난이도: Level 2
 * // 각 사용자의 음식을 주어진 cource에 맞게 조합한다.
 * // 조합들을 map에 저장한다. cource : 2 ex) AB:2
 * // map을 순회하면서 2개 이상인 key만 정답배열에 저장한다.
 * */
public class Solution7 {
    private static Map<String, Integer> map = new HashMap<>();
    private static int[] maxCount = new int[11]; // 각 글자수당 가장 큰값 저장

    public static String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            char[] orderChar = order.toCharArray();
            Arrays.sort(orderChar);
            for (int count : course) {
                combination(0, new LinkedList<>(), orderChar, count);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String key : map.keySet()) {
            for (int c : course) {
                if (key.length() == c && map.get(key) == maxCount[c] && maxCount[c] >= 2) {
                    answer.add(key);
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    public static void combination(int start, LinkedList<Character> elements, char[] orderChar, int count) {
        if (elements.size() == count) {
            StringBuilder sb = new StringBuilder();
            for (Character st: elements) {
                sb.append(st);
            }
            String dishName = sb.toString();
            map.put(dishName, map.getOrDefault(dishName, 0) + 1);
            maxCount[count] = Math.max(map.get(dishName), maxCount[count]);
        }
        
        for (int i = start; i < orderChar.length; i++) {
            elements.add(orderChar[i]);
            combination(i + 1, elements, orderChar, count);
            elements.removeLast();
        }
    }

    public static void main(String[] args) {
        solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                new int[]{2,3,5});
    }
}
