package recursion;

import java.util.*;

public class LeetCode46 {
    /**
     * permutation
     * */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        int size = nums.length;
        recursion(size, numList, result, 0);
        return result;
    }

    public static void recursion(int size, ArrayList<Integer> nums, List<List<Integer>> result, int first) {
        if (first == size)
            result.add(new ArrayList<>(nums));

        for (int i = first; i < size; i++) {
            Collections.swap(nums, first, i);
            recursion(size, nums, result, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
