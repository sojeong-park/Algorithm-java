package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations, 순열
 * */
public class LeetCode77 {
    private static List<List<Integer>> result;
    public static List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        dfs(new ArrayList<>(), 1, n, k);
        return result;
    }

    public static void dfs(List<Integer> elements, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(elements));
            return;
        }
        for (int i = start; i <= n; i++) {
            elements.add(i);
            dfs(elements, i+1, n, k-1);
            elements.remove(elements.size()-1);
        }
    }

    public static void main(String[] args) {
        combine(4,2);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
