package arraysAndStrings;

import java.util.*;

public class LeetCode215 {

    /**
     * 방법1. 배열을 정렬하고 인덱스로 접근한다.
     * 배열 정렬하는 시간으로 인해 시간복잡도 O(n log n), 공간복잡도  O(1)
     * */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /**
     * 방법2. priority Queue
     * O(n log k) + O(k)
     * */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
