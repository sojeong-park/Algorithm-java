package arraysAndStrings;

public class LeetCode704 {
    /**
     * Binary Search 풀이
     * 시간복잡도 O(log(n)), 공간복잡도 O(1)
     * */
    public static int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        search(new int[]{-1,0,3,5,9,12}, 9);
    }
}
