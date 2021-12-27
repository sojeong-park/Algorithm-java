package arraysAndStrings;

import java.util.*;

public class LeetCode163 {
    /**
     * 1. [] 배열의 원소가 0인 경우에도 (lower = upper) 둘중에 하나가 출력되어야 한다.
     * 2. upper의 값이 출력되어야한다.
     * 3. prev+1 (이전값+1) ~ curr-1 (현재값-1)로 범위를 표현한다.
     * */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = i < nums.length ? nums[i] : upper+1;
            if (prev + 1 <= curr - 1) {
                result.add(makeRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return result;
    }

    public String makeRange(int prev, int curr) {
        if (prev == curr) {
            return prev + "";
        }
        return prev + "->" + curr;
    }
}
