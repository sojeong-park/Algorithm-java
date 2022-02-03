package arraysAndStrings;

import java.util.Arrays;

public class LeetCode4 {
    /**
     * 풀이 1.
     * 배열을 합치고 정렬해 중간값을 구한다. 시간복잡도는 O(log(m+n)) 을 충족해야 한다.
     * 시간복잡도 O(log(m+n))충족이 의미하는것은 Binary search 활용해 구현하라는 것이다.
     * 아래 풀이는 Binary Search 풀이는 아니지만 통과한다.
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int length = nums1.length + nums2.length;
        int[] merge = new int[length];

        System.arraycopy(nums1, 0, merge, 0, nums1.length);
        System.arraycopy(nums2, 0, merge,  nums1.length, nums2.length);

        Arrays.sort(merge); // 시간복잡도 평균  O(nlog(n)), 최악 O(n^2)

        if (length % 2 == 0) {
            result = (merge[(length/2) - 1] + merge[length/2]) / 2.0;
        } else {
            result = merge[length/2];
        }
        return result;
    }

    /**
     * 풀이 2.
     * Binary Search를 활용한 풀이
     * nums1과 nums2의 중앙값을 비교하여 각 단계에서 nums1과 num2의 절반을 재귀적으로 무시하는것.
     * */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = (m + n + 1) / 2; // 왼쪽 절반
        int r = (m + n + 2) / 2; // 오른쪽 절반

        // m+n이 홀수인 경우 두 함수가 동일한 값 return
        // 짝수인 경우 두 함수가 왼쪽 절반과 오른쪽 절반의 중앙값을 반환한다.
       return (search(nums1, 0, nums2, 0, l) +
               search(nums1, 0, nums2, 0, r)) / 2.0;
    }

    /**
     * num1과 num2 배열을 합친 k번째 원소를 찾는다.
     * */
    public static double search(int[] nums1, int startIndex1, int[] nums2, int startIndex2, int k) {
        if (startIndex1 > nums1.length - 1) return nums2[startIndex2 + k - 1];
        if (startIndex2 > nums2.length - 1) return nums1[startIndex1 + k - 1];

        if (k == 1) return Math.min(nums1[startIndex1], nums2[startIndex2]);

        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (startIndex1 + k / 2 - 1 < nums1.length) mid1 = nums1[startIndex1 + k / 2 - 1];
        if (startIndex2 + k / 2 - 1 < nums2.length) mid2 = nums2[startIndex2 + k / 2 - 1];

        if (mid1 < mid2) {
            return search(nums1, startIndex1 + k / 2, nums2, startIndex2, k - k / 2);
        } else {
            return search(nums1, startIndex1, nums2, startIndex2 + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays2(new int[]{1,2}, new int[]{3,4}));
    }
}
