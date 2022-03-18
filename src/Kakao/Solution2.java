package Kakao;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 * 숫자 문자열과 영단어
 * 난이도: Level1
 * map풀이와 string배열 두가지 풀이가 있다. 
 * */
public class Solution2 {
    private Map<String, Integer> map = new HashMap<>();
    public int solution(String s) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder nums = new StringBuilder();
        StringBuilder tmpStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                tmpStr.append(s.charAt(i));
                if (map.containsKey(tmpStr.toString())) {
                    nums.append(map.get(tmpStr.toString()));
                    tmpStr = new StringBuilder();
                }
            } else {
                nums.append(s.charAt(i) - '0');
            }
        }

        return Integer.parseInt(nums.toString());
    }

    public static int solution2(String s) {
        int answer = 0;
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for (int i = 0; i < 10; i++) {
           s = s.replaceAll(alphabets[i], digits[i]);
        }
        return Integer.parseInt(s.toString());
    }
    public static void main(String[] args) {
        solution2("one4seveneight");
    }
}
