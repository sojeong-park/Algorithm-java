package arraysAndStrings;
enum Index {
    GOOD,
    UNKNOWN
}
public class LeetCode55 {
    /**
     * 방법1. backtracking
     *       재귀함수를 사용해 조건에 맞지 않으면 false, 조건에 맞으면 true 반환해 모든 경우의 수를 탐색한다.
     *       - 시간복잡도 O(2^n), 공간복잡도 O(N)
     * 방법2. Bottom-up DP
     *       마지막 인덱스 = 방문 가능
     *       i 인덱스에서 i+1 ~ i+nums[i] 위치 탐색 중 다음으로 이동가능한 인덱스가 있는지 체크
     *       0번째 인덱스가 방문 가능이면 true, 아니면 false
     *       - 시간복잡도 O(N^2), 공간복잡도 O(N)
     * 방법3. Greedy
     *      마지막 인덱스까지 방문 가능한지 현재 인덱스+원소값으로 체크
     *          가능하다면 lastValue는 현재 인덱스로 대체
     *      lastValue가 0이라면 (0번째 인덱스까지 방문체크완료) true반환
     *      - 시간복잡도 O(N), 공간복잡도 O(1)
     * */

    public static boolean canJumpRecursive(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length-1);
        for (int next = position+1; next <= furthestJump; next++) {
            if (canJumpRecursive(next, nums)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canJump(int[] nums) {
        return canJumpRecursive(0, nums);
    }

    public static boolean canJump2(int[] nums) {
        Index[] index = new Index[nums.length];

        for (int i = 0; i < nums.length; i++) {
            index[i] = Index.UNKNOWN;
        }
        index[nums.length-1] = Index.GOOD; // 마지막 인덱스는 방문 가능하다고 가정

        for (int i = nums.length-2; i >= 0; i--) {
            int nextJump = Math.min(i+nums[i], nums.length-1); // nums의 길이 만큼만 탐색하도록 제한
            for (int j = i+1; j <= nextJump; j++) { // 다음으로 이동가능한 인덱스가 있는지 체크
                if (index[j] == Index.GOOD) {
                    index[i] = Index.GOOD;
                    break;
                }
            }
        }
        return index[0] == Index.GOOD;
    }

    public static boolean canJump3(int[] nums) {
        int lastValue = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastValue) { // 현재 위치에서 이동 가능한 값이 lastValue보다 크거나 같으면 true
                lastValue = i;
            }
        }

        // 0번째 인덱스까지 이동가능하다면 true
        return lastValue == 0;
    }
}
