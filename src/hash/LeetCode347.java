package hash;

import java.util.*;

public class LeetCode347 {
    /**
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     * */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // 시간복잡도가 O(n log n)의 정렬이 필요함
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2)
        );

        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k ) heap.poll();
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
