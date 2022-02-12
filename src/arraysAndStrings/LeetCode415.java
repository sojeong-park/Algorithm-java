package arraysAndStrings;

public class LeetCode415 {
    /**
     * 시간복잡도: O(max(N+M)) -> num1.length + num2.length
     * 공간복잡도: O(max(N+M)) -> StringBuilder space 사용
     * */
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0, n1 = 0, n2 = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                n1 = 0;
            } else {
                n1 = num1.charAt(i) - '0';
            }
            if (j < 0) {
                n2 = 0;
            } else {
                n2 = num2.charAt(j) - '0';
            }
            int tmpSum = n1 + n2 + carry;
            carry = tmpSum / 10;
            result.append(tmpSum % 10);
            i--;
            j--;
        }
        if (carry==1) result.append(carry);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }
}
