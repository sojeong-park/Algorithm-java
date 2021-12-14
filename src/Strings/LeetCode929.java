package Strings;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 방법1. 모든 문자열을 for loop를 통해 순회
 *    . : 제외 후 문자열 이어붙이기
 *    + : 해당 문자 발견시 break
 *    @ : 해당 문자 발견시 break, .이 나와도 그대로 유지, 완성된 tmp에 이어붙이기
 *         -> 제거한 문자열은 set자료구조에 넣어 중복을 제거한후 set의 개수를 센다.
 *         - 시간복잡도 O(NM) -> N: emails 길이, M: 각문자열 평균 길이
 *         - 공간복잡도 O(NM) -> 동일
 *
 */

public class LeetCode929 {
    /**
     *  StringBuilder 활용시 Runtime: 	7 ms
     *  String 활용시 Runtime: 25ms
     */
    public int numUniqueEmails1(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < emails[i].length(); j++) {
                char a = emails[i].charAt(j);
                if (a == '+' || a == '@') break;
                if (a != '.') tmp.append(a);
            }
            tmp.append(emails[i].substring(emails[i].indexOf('@')));
            set.add(tmp.toString());
        }
        return set.size();
    }
}
