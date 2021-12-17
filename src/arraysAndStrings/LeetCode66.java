package arraysAndStrings;

public class LeetCode66 {
    /**
     * 가장 끝자리에 1을 더하기. 999 -> 1000, 129 -> 130
     * digits 배열을 순회한다 -> 1의 자리숫자에 1을 더하는 것이므로 역으로 순회를 한다.
     *     - 9를 만나면 0으로 변환
     *     - 9가 아닌 숫자라면 +1을 하고 return
     * (위의 반복문에서 반환되지 않을 경우 전부 숫자가 9이므로 000으로 변환된 상태. 남은 carry값을 맨 앞에 추가해주어야 한다.)
     * digits 배열을 int 형식으로 기존크기+1로 재선언한다.
     *      digit의 0번째 자리를 1로 변경하고 return.
     * */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }
}
