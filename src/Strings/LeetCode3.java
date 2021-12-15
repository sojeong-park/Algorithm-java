package Strings;

import java.util.*;

/**
 * 문제정의:  문자를 반복하지 않는(without repeating characters) 가장 긴 substring 찾기
 * abcabcbb -> abc가 정답이라 전체 길이는 3이다. abcb가 안되는 이유> b가 반복되서 안된다.
 * pwwkew   -> pwwk가 안되는 이유 w가 반복됨. wke가 반복되는 문자열이 없으니 정답은 3
 *
 * 방법1. sliding window + array -> 시간복잡도 O(n), 공간복잡도 O(min(n.m))
 *                                 n: 문자열 길이, m: 알파벳 길이, min(m,n): 중복되지 않은 문자열 개수만큼 공간필요
 * 방법2. sliding window + hashMap -> 시간복잡도 O(n), 공간복잡도 O(min(n.m))
 * */
public class LeetCode3 {
    //1로 유지하는 이유는 중복된 문자열을 만들지 않기 위해서
    public int lengthOfLongestSubstring1(String s) {
        int[] chars = new int[128];
        int left = 0, right = 0, res = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            //중복 발생시 문자열 중복이 없는 위치까지 left 이동
            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) { //중복된 문자열이 있는지 판별
                i = Math.max(map.get(s.charAt(j)), i); // 중복된 문자열이 있는 인덱스로 이동
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1); //문자열 길이 저장
        }
        return ans;
    }
}
