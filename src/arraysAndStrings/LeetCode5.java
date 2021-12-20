package arraysAndStrings;

public class LeetCode5 {
    /**
     * 방법1. sliding window 활용. 팰린드롬의 문자열이 짝수(i+1), 홀수(i+2)인 경우를 나누어서 탐색
     *      - 최대 길이의 팰린드롬일 경우 start, end에 인덱스값 재 설정
     *      - 시간복잡도 O(N^2), 공간복잡도 O(1)
     * */
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int a = expand(s, i, i+1);
            int b = expand(s, i, i+2);
            int len = Math.max(a, b);
            if (len > end - start) {
                start = i - (len - 1) / 2; // 시작위치 0 이상이 되게 하기위해 1을 뺀다. 길이가 2일 경우 시작값이 -1이 되므로 0을 만들기 위해서
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
