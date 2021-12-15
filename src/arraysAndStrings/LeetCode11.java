package arraysAndStrings;

public class LeetCode11 {
    /**
     * 방법1. sliding window 활용
     *      - 빗물은 낮은 높이만큼만 쌓인다. -> volume, min함수 활용
     *      - 빗물은 right - left 만큼 고여있다.
     *      - left와 right값 중 더 작은 원소값을 가진 포인터를 움직여 max 값을 유지한다.
     *      - 시간복잡도 O(N), 공간복잡도 O(1)
     * */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1, res = 0;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            int volume = Math.min(leftMax, rightMax); // 빗물이 고인 부피
            int cnt = right - left; // 빗물이 고인 개수
            res = Math.max(res, volume * cnt);

            // left와 right값 중 더 작은값의 포인터를 움직여 max 고인값을 유지한다.
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
