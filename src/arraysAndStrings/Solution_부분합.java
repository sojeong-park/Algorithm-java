package arraysAndStrings;

import java.io.*;
import java.util.*;
/**
 * https://www.acmicpc.net/problem/1806
 * 부분합
 * */
public class Solution_부분합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        String[] numberStr  = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int target = Integer.parseInt(nums[1]);
        int[] numbers = new int[n];
        int i = 0;
        for (String num : numberStr) {
            numbers[i++] = Integer.parseInt(num);
        }

        int l = 0, r = 0, sum = 0, min = Integer.MAX_VALUE;
        while (true) {
            if (sum >= target) {
                min = Math.min(min, r - l);
                sum -= numbers[l++];
            } else if (r == n) {
                break;
            } else {
                sum += numbers[r++];
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
