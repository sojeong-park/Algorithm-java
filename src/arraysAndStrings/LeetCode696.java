package arraysAndStrings;

public class LeetCode696 {
    /**
     * substring 이긴 하지만 연속된 0과 1의 수가 동일한 substring의 개수를 추출
     * 방법 1. 연속된 숫자를 그룹으로 만들기
     *  - 1과 0이 모두 동일하게 반복되어야 한다. (1*k)+(0*k) or (0*k)+(1*k)
     *  예시) 110001111000000 -> groups = [2,3,4,6]
     *  1100, 10 (2개)
     *  000111, 0011, 01 (3개)
     *  11110000, 111000, 1100, 10 (4개)
     * 시간복잡도: O(N), 공간복잡도: O(N)
     * */
    public static int countBinarySubstrings1(String s) {
        int[] groups = new int[s.length()];
        int tmp = 0;
        groups[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++tmp] = 1;
            } else {
                groups[tmp]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= tmp; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }

    /**
     * 방법 2. 투포인터 탐색
     * prev = groups[i-1], cur = groups[i] 두개의 값만 알면 정답을 구할 수 있다.
     * 시간복잡도 O(N), 공간복잡도 O(1)
     * */
    public static int countBinarySubstrings2(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }

    public static void main(String[] args) {
        countBinarySubstrings1("10101");
    }
}
