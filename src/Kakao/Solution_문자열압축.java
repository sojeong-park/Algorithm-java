package Kakao;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 * 문자열 압축
 * 난이도: Level 2 
 * */
public class Solution_문자열압축 {
    public static int solution(String s) {
        if (s.length() == 1) return 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length()/2; i++) {
            String currStr = s.substring(0, i);
            int cnt = 1, ansCnt = 0;
            for (int j = i; j <= s.length() - i; j += i) {
                if (currStr.equals(s.substring(j, j + i))) {
                    cnt++;
                } else {
                    if (cnt > 1) ansCnt += Integer.toString(cnt).length();
                    ansCnt += currStr.length();
                    currStr = s.substring(j, j + i);
                    cnt = 1;
                }
            }
            if (cnt > 1) ansCnt += Integer.toString(cnt).length();
            ansCnt += currStr.length();

            int part = s.length() % i;
            min = Math.min(min, ansCnt + part);
        }
        return min;
    }

    public static void main(String[] args) {
        solution("aabbaccc");
        solution("abcabcabcabcdededededede");
    }
}
