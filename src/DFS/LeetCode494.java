package DFS;

import java.util.*;

public class LeetCode494 {
    private static int visitied = 0;
    private static int count = 0;
    private static Set memo = new HashSet();

    public static int findTargetSumWays(int[] nums, int target) {
        calculate1(nums, 0, 0, target);
        return count;
    }

    /**
     * 방법1. brute-force!
     * 시간복잡도 O(2^n): n은 nums 배열의 길이
     * 공간복잡도 O(N): nums 배열의 길이만큼 높이의 공간 필요
     * */
    public static void calculate1(int[] nums, int index, int sum, int target) {
        visitied++;
        if (index == nums.length) {
            if (sum == target){
                count++;
            }
        } else {
            calculate1(nums, index + 1, sum + nums[index], target);
            calculate1(nums, index + 1, sum - nums[index], target);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;

        findTargetSumWays(nums, target);
        System.out.println(visitied);
    }
}
