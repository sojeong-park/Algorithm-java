package Kakao;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/92342
 * 양궁대회
 * 난이도: Level 2
 * 전 우승자인 라이언에게 불리한 규칙을 적용한 양궁 결승
 * 어피치가 화살 n개를 먼저 쏘고 그 결과가 info일때 라이언이 가장 큰 점수 차이로 이길수 있는 배열은 무엇인지 구하자.
 * 완전탐색 - dfs 풀이
 * */
public class Solution10 {
    private static int[] nums = new int[11];
    private static int[] res = {-1};
    private static int max = Integer.MIN_VALUE;
    public static int[] solution(int n, int[] info) {
        permutation(n, 0, info);
        return res;
    }

    public static void permutation(int n, int depth, int info[]) {
        if (depth == n) {
            int a = 0, l = 0;
            for (int j = 0; j < 11; j++) {
                if (info[j] != 0 || nums[j] != 0) {
                    if (info[j] >= nums[j]) a += (10 - j);
                    else l += (10 - j);
                }
            }
            if (l > a) {
                if (max <= l - a) {
                    max = l - a;
                    res = info.clone();
                }
            }
            return;
        }

        for (int i = 0; i <= 10 && nums[i] <= info[i]; i++) {
            nums[i]++;
            permutation(n, depth + 1, info);
            nums[i]--;
        }
    }

    public static void main(String[] args) {
        solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});

    }
}
