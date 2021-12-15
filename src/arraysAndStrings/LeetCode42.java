package arraysAndStrings;

public class LeetCode42 {
    /**
     * 방법1. sliding window
     *       - 빗물이 고이는 조건?
     *          - [1,0,3] 에서 1만큼 고인다. > 배열이 양 끝에서 가운데로 이동해야 고인 빗물의 volume 구할수 있다.
     *       - 포인터를 이동하는 조건은 높은 포인터 쪽으로 한 포인터를 이동한다.
     *          - (가장 높은 값 - 현재 값) > 고인 빗물의 volume 알수있다.
     *              left 포인터가 지나온 최대 높이를 저장, right 포인터가 지나온 최대 높이를 저장
     * 시간복잡도 O(N), 공간복잡도 O(1)
     * */
    public static int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int res = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
