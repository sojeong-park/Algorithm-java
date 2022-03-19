package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode179 {
    private static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            // return order1.compareTo(order2); 작은 숫자들로 정렬된다.
            return order2.compareTo(order1);
        }
    }
    public static String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, new LargerNumberComparator());
        for (int i = 0; i < nums.length; i++) {
            System.out.println(strNums[i]);
        }

        if (strNums[0].equals("0")) {
            return "0";
        }

        String largeNumber = new String();
        for (String str : strNums) {
            largeNumber += str;
        }
        return largeNumber;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }
}
