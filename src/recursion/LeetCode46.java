package recursion;

import java.util.*;

public class LeetCode46 {
    private static List<List<Integer>> resultList = new ArrayList<>();
    private static List<Integer> paramList = new ArrayList<>();
    private static boolean[] visited;

    /**
     * permutation - Collection swap 풀이
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

    /**
     * permutation  - dfs 풀이
     * */
    public static List<List<Integer>> permute2(int[] nums) {
        visited = new boolean[nums.length];
        dfs(paramList, nums);
        return resultList;
    }

    public static void dfs(List<Integer> paramList, int[] nums) {
        if (paramList.size() == nums.length) {
            resultList.add(new ArrayList<>(paramList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                paramList.add(nums[i]);
                dfs(paramList, nums);
                visited[i] = false;
                paramList.remove(paramList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
