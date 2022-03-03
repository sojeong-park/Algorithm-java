package DFS;

import java.util.*;

public class LeetCode39 {
    private static List<List<Integer>> result = new ArrayList<>();
    /**
     * Combination Sum
     * */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(target, 0, new ArrayList<>(), candidates);
        return result;
    }

    public static void dfs (int csum, int index, List<Integer> path, int[] candidates) {
        if (csum < 0) {
            return;
        }
        if (csum == 0) {
            result.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(csum - candidates[i], i, path, candidates);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7}, 7);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
