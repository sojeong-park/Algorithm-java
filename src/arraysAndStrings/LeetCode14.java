package arraysAndStrings;

public class LeetCode14 {
    /**
     * 풀이 1. Horizontal 탐색
     *  - 시간복잡도: O(N) N: strs의 길이, 공간복잡도: O(1) 일정한 추가 공간을 사용함
     * */
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (prefix.isEmpty()) return "";
            int index = 0;
            while (strs[i].length() > index && prefix.length() > index && prefix.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            prefix = prefix.substring(0, index);
        }
        return prefix;

    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aaa","aa","aaa"}));
    }
}
