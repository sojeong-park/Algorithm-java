package DFS;

import java.util.*;

public class LeetCode78 {
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        //dfs(0, new ArrayList<>(), nums);
        dfs_linked(0, new LinkedList<>(), nums);
        return result;
    }

    public static void dfs (int index, List<Integer> path, int[] nums) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i+1, path, nums);
            path.remove(path.size()-1);
        }
    }

    public static void dfs_linked(int index, LinkedList<Integer> path, int[] nums) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i+1, path, nums);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
